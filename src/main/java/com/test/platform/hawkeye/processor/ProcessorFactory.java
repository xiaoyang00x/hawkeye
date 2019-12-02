package com.test.platform.hawkeye.processor;

import com.test.platform.hawkeye.constant.ProcessorEnum;
import com.test.platform.hawkeye.domain.general.ProcessorInfo;
import com.test.platform.hawkeye.service.AutoCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.compiler.Environment;
import spoon.processing.AbstractProcessor;
import spoon.processing.ProcessingManager;
import spoon.processing.ProcessorProperties;
import spoon.processing.ProcessorPropertiesImpl;
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

    @Autowired
    AutoCaseService autoCaseService;

    Integer projectId = 1;

    Integer type = 1; //0增量 1全量


    public void InitProcessor(ProcessorInfo processorInfo) throws IllegalAccessException, InstantiationException {


        SpoonAPI spoon = new Launcher();

        //添加需要解析的类文件或者文件夹 后续在参数化
        spoon.addInputResource( processorInfo.getScanPath() );
        //运行解析
        spoon.run();

        Factory factory = spoon.getFactory();
        ProcessingManager processingManager = new QueueProcessingManager( factory );



        //ClassProcessor类 集成抽象类 AbstractProcessor<E extends CtElement>，实现process方法
        switch (processorInfo.getProcessorEnum().getValue()) {
            case "HTTP":
                httpClassProcessor.setType( type );
                httpClassProcessor.setProjectId( projectId );
                //是否为全量
                if (type==1)
                    autoCaseService.deleteByProjectId( projectId );
                processingManager.addProcessor( httpClassProcessor );
                break;
            case "RPC":
                //是否为全量
                break;
            default:
                autoClassProcessor.setType( type );
                autoClassProcessor.setProjectId( projectId );
                //是否为全量
                if (type==1)
                    autoCaseService.deleteByProjectId( projectId );
                processingManager.addProcessor( autoClassProcessor );
                break;
        }

        processingManager.process( factory.Class().getAll() );


    }


}
