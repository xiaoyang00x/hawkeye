package com.test.platform.hawkeye;

import com.test.platform.hawkeye.processor.AutoClassProcessor;
import com.test.platform.hawkeye.processor.HttpClassProcessor;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

public class TestHttpClassProcessor {

    public static void main(String[] args) {
        SpoonAPI spoon = new Launcher();

        //添加需要解析的类文件或者文件夹
        spoon.addInputResource( "/Users/yangyu/code/test/benmu_auto_test/src/test/java/com/benmu/data/business" );
        //添加解析后输出的文件夹
        spoon.setSourceOutputDirectory( "target/spoon" );
        //运行解析
        spoon.run();

        Factory factory = spoon.getFactory();
        ProcessingManager processingManager = new QueueProcessingManager( factory );

        //ClassProcessor类 集成抽象类 AbstractProcessor<E extends CtElement>，实现process方法
        AutoClassProcessor processor = new AutoClassProcessor();
        processingManager.addProcessor( processor );
        processingManager.process( factory.Class().getAll() );

        System.out.println( "执行完成" );


    }
}
