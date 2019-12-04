package com.test.platform.hawkeye.processor;

import com.test.platform.hawkeye.domain.general.ProcessorInfo;
import com.test.platform.hawkeye.domain.general.Project;
import com.test.platform.hawkeye.domain.general.ProjectAnalysis;
import com.test.platform.hawkeye.service.AutoCaseService;
import com.test.platform.hawkeye.service.InterfaceService;
import com.test.platform.hawkeye.service.ProjectAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.SpoonException;
import spoon.processing.ProcessingManager;
import spoon.reflect.factory.Factory;
import spoon.support.QueueProcessingManager;


/**
 * 通用Processor工厂
 */
@Service
public class ProcessorFactory {

    protected static final Logger logger = LoggerFactory.getLogger( ProcessorFactory.class );


    @Autowired
    HttpClassProcessor httpClassProcessor;

    @Autowired
    AutoClassProcessor autoClassProcessor;

    @Autowired
    AutoCaseService autoCaseService;

    @Autowired
    InterfaceService interfaceService;

    @Autowired
    ProjectAnalysisService projectAnalysisService;


    /**
     * 初始化processor
     * 异步方法,扫描中间状态变更
     *
     * @param processorInfo 介质参数,根据属性判断分支逻辑
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Async
    public void InitProcessor(ProcessorInfo processorInfo) throws IllegalAccessException, InstantiationException {

        Project project = processorInfo.getProject();
        int scanType = processorInfo.getScanType();

        logger.info( "进入到ProcessorFactory.InitProcessor方法中,project:{} , scanType:{}, analysisId:{}", project.toString(), scanType, processorInfo.getAnalysisId() );


        SpoonAPI spoon = new Launcher();

        //添加需要解析的类文件或者文件夹 后续在参数化
        spoon.addInputResource( processorInfo.getProject().getScanPath() );

        //解析后目标文件
        spoon.setSourceOutputDirectory( "target/spoon/" + processorInfo.getAnalysisId() );
        logger.info( "目标路径：" + "target/spoon/:{}", processorInfo.getAnalysisId() );


        //扫描前修改状态
        ProjectAnalysis projectAnalysis = projectAnalysisService.getProjectAnalysisById( processorInfo.getAnalysisId() );
        projectAnalysis.setStatus( 1 );
        projectAnalysisService.updateProjectAnalysis( projectAnalysis );


        //运行解析
        spoon.run();

        Factory factory = spoon.getFactory();
        ProcessingManager processingManager = new QueueProcessingManager( factory );


        //ClassProcessor类 集成抽象类 AbstractProcessor<E extends CtElement>，实现process方法
        //project.type 0为http、1位rpc、2为自动化用例
        switch (processorInfo.getProject().getType()) {
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


        //扫描后修改状态
        projectAnalysis.setStatus( 2 );
        projectAnalysisService.updateProjectAnalysis( projectAnalysis );

    }


}
