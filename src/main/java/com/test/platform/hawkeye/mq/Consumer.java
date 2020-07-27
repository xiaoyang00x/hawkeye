package com.test.platform.hawkeye.mq;

import com.test.platform.hawkeye.constant.MQConst;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class Consumer {


    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("yangyu_test_consumer_name");

        consumer.setNamesrvAddr( MQConst.NAMESRV_ADDR);

        consumer.setConsumeFromWhere( ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        consumer.subscribe("yangyutest", "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println("消息消费中...");

                MessageExt me = msgs.get(0);
                try {
                    String topic = me.getTopic();
                    String tags = me.getTags();
                    String keys = me.getKeys();
                    String msgBody = new String(me.getBody(), RemotingHelper.DEFAULT_CHARSET);
                    System.out.println("topic: " + topic + ",tags: " + tags + ",key: " + keys + ",msgBody: " + msgBody);
                } catch (Exception e) {
                    e.printStackTrace();
                    int reconsumeTimes = me.getReconsumeTimes();
                    System.err.println("reconsumeTimes: " + reconsumeTimes);
                    if (reconsumeTimes == 3) {
                        //  记录日志...
                        //  做补偿处理
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
        System.out.println("consumer start...");

    }


}
