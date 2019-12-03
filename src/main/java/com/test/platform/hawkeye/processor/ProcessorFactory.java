package com.test.platform.hawkeye.processor;

import com.test.platform.hawkeye.domain.general.Project;
import com.test.platform.hawkeye.service.AutoCaseService;
import com.test.platform.hawkeye.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spoon.Launcher;
import spoon.SpoonAPI;
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

    @Autowired
    AutoCaseService autoCaseService;

    @Autowired
    InterfaceService interfaceService;


    /**
     * 初始化processor
     *
     * @param project  项目id
     * @param scanType 扫描类型 0增量、1全量
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void InitProcessor(Project project, Integer scanType) throws IllegalAccessException, InstantiationException {


        SpoonAPI spoon = new Launcher();

        //添加需要解析的类文件或者文件夹 后续在参数化
        spoon.addInputResource( project.getScanPath() );

        //解析后目标文件
        spoon.setSourceOutputDirectory( "target/spoon" );


        //运行解析
        spoon.run();

        Factory factory = spoon.getFactory();
        ProcessingManager processingManager = new QueueProcessingManager( factory );


        //ClassProcessor类 集成抽象类 AbstractProcessor<E extends CtElement>，实现process方法
        switch (project.getType()) {
            case 0:
                httpClassProcessor.setType( scanType );
                httpClassProcessor.setProjectId( project.getId() );
                //是否为全量
                if (scanType == 1)
                    interfaceService.deleteByProjectId( project.getId() );
                processingManager.addProcessor( httpClassProcessor );
                break;
            case 1:
                //是否为全量
                break;
            default:
                autoClassProcessor.setType( scanType );
                autoClassProcessor.setProjectId( project.getId() );
                //是否为全量
                if (scanType == 1)
                    autoCaseService.deleteByProjectId( project.getId() );
                processingManager.addProcessor( autoClassProcessor );
                break;
        }

        processingManager.process( factory.Class().getAll() );


    }


}
