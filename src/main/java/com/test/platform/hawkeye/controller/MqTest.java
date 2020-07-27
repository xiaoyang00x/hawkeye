package com.test.platform.hawkeye.controller;


import com.test.platform.hawkeye.domain.general.ProcessorInfo;
import com.test.platform.hawkeye.domain.general.Project;
import com.test.platform.hawkeye.domain.general.ProjectAnalysis;
import com.test.platform.hawkeye.mq.Producer;
import com.test.platform.hawkeye.processor.ProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mqtest")
@RestController
public class MqTest {


    @Autowired
    Producer producer;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testAutoTest() throws Exception {


        producer.SendMQ( );


        return "完成";

    }



}
