package com.test.platform.hawkeye.mq;

import com.test.platform.hawkeye.constant.MQConst;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;


@Service
public class Producer {

    public void SendMQ() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer( "ProducerGroupName" );

        producer.setNamesrvAddr( MQConst.NAMESRV_ADDR );

        producer.start();

        for (int i = 0; i < 5; i++) {

            //1.创建消息
            Message message = new Message(
                    "yangyutest",//主题
                    "TagA",//标签
                    "OrderID188" + i,//用户自定义的key,唯一的标识
                    ("Hello RocketMQ" + i).getBytes()//消息内容实体(byte[])
            );

            //2.发送消息
            SendResult sr = producer.send( message );
            System.out.println( "消息发出: " + sr );
        }

        producer.shutdown();

    }
}
