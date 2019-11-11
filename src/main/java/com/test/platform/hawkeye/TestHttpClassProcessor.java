package com.test.platform.hawkeye;

import com.test.platform.hawkeye.processor.HttpClassProcessor;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;

public class TestHttpClassProcessor {

    public static void main(String[] args) {
        final SpoonAPI spoon = new Launcher();

        //添加需要解析的类文件或者文件夹
        spoon.addInputResource( "/Users/yangyu/code/rd/unify-mobile/mina" );
        //添加解析后输出的文件夹
        spoon.setSourceOutputDirectory( "target/spoon" );
        //运行解析
        spoon.run();

        Factory factory = spoon.getFactory();
        final ProcessingManager processingManager = new QueueProcessingManager( factory );

        //ClassProcessor类 集成抽象类 AbstractProcessor<E extends CtElement>，实现process方法
        final HttpClassProcessor processor = new HttpClassProcessor();
        processingManager.addProcessor( processor );
        processingManager.process( factory.Class().getAll() );

        System.out.println( "执行完成" );


    }
}
