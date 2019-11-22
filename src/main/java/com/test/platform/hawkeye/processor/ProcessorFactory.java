package com.test.platform.hawkeye.processor;

import com.test.platform.hawkeye.constant.ProcessorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processing.AbstractProcessor;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;


/**
 * 通用Processor工厂
 */
@Service
public class ProcessorFactory {


    @Autowired
    HttpClassProcessor httpClassProcessor;

    @Autowired
    AutoClassProcessor autoClassProcessor;


    public void InitProcessor(ProcessorEnum processorEnum) throws IllegalAccessException, InstantiationException {
        SpoonAPI spoon = new Launcher();

        //添加需要解析的类文件或者文件夹 后续在参数化
        spoon.addInputResource( "/Users/yangyu/code/test/benmu_auto_test/src/test/java/com/benmu" );
        //添加解析后输出的文件夹
        spoon.setSourceOutputDirectory( "target/spoon" );
        //运行解析
        spoon.run();

        Factory factory = spoon.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager( factory );


        //ClassProcessor类 集成抽象类 AbstractProcessor<E extends CtElement>，实现process方法
        switch (processorEnum.getValue()) {
            case "HTTP":
                processingManager.addProcessor( httpClassProcessor );
                break;
            case "RPC":
                break;
            default:
                processingManager.addProcessor( autoClassProcessor );
                break;
        }

        processingManager.process( factory.Class().getAll() );


    }


}
