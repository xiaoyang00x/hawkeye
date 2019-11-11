package com.test.platform.hawkeye.controller;


import com.test.platform.hawkeye.constant.ProcessorEnum;
import com.test.platform.hawkeye.processor.HttpClassProcessor;
import com.test.platform.hawkeye.processor.ProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processing.AbstractProcessor;
import spoon.processing.ProcessingManager;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

@RequestMapping("/testInterface")
@RestController
public class testHttpInterface {

    @Autowired
    ProcessorFactory processorFactory;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String requestmethodpost() throws Exception {

        processorFactory.InitProcessor( ProcessorEnum.HTTP );

        return "执行完成";

    }
}
