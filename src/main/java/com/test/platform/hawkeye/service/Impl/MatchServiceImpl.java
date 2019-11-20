package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.controller.testHttpInterface;
import com.test.platform.hawkeye.domain.general.AutoCase;
import com.test.platform.hawkeye.domain.general.AutoCaseInterface;
import com.test.platform.hawkeye.domain.general.Interface;
import com.test.platform.hawkeye.domain.general.Project;
import com.test.platform.hawkeye.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class MatchServiceImpl implements MatchService {

    protected static final Logger logger = LoggerFactory.getLogger( MatchServiceImpl.class );


    @Autowired
    ProjectService projectService;

    @Autowired
    InterfaceService interfaceService;

    @Autowired
    AutoCaseService autoCaseService;

    @Autowired
    AutoCaseInterfaceService autoCaseInterfaceService;

    /**
     * 增量匹配
     *
     * @param rdProjectId
     */

    @Override
    @Transactional
    public void matchnIcrement(int rdProjectId) {


        Project project = projectService.getProjectById( rdProjectId );

        if (project.getType() > 1) {
            logger.info( "增量匹配工程为自动化项目代码,参数rdProjectId为:{}", rdProjectId );
            return;
        }

        logger.info( "增量匹配工程为开发项目代码,参数rdProjectId为:{}", rdProjectId );

        //通过rdProjectId获取所有interface

        List<Interface> interfacesList = interfaceService.getAllInterfaceByProjectId( rdProjectId );

        //遍历interface
        for (Interface record :
                interfacesList) {
            //单个path匹配autocase

            List<AutoCase> autoCaseList = autoCaseService.getAutoCaseByPath( record.getPath() );

            // >0修改interface is_auto 状态 =0不修改
            if (autoCaseList.size() > 0) {

                interfaceService.updateIsAutoTrue( record );

                //新增关联关系表
                for (AutoCase autoCase : autoCaseList) {
                    AutoCaseInterface autoCaseInterface = new AutoCaseInterface();
                    autoCaseInterface.setInterfaceId( record.getId() );
                    autoCaseInterface.setProjectId( record.getProjectId() );
                    autoCaseInterface.setCaseId( autoCase.getId() );
                    autoCaseInterfaceService.saveAutoCaseInterface( autoCaseInterface );
                }

            }

        }

    }

    /**
     * 全量匹配
     *
     * @param rdProjectId
     */

    @Override
    @Transactional
    public void matchnTotalQuantity(int rdProjectId) {

        Project project = projectService.getProjectById( rdProjectId );

        if (project.getType() > 1) {
            logger.info( "全量匹配工程为自动化项目代码,参数rdProjectId为:{}", rdProjectId );
            return;
        }

        logger.info( "全量匹配工程为开发项目代码,参数rdProjectId为:{}", rdProjectId );

        //通过rdProjectId获取所有interface

        List<Interface> interfacesList = interfaceService.getAllInterfaceByProjectId( rdProjectId );

        //通过rdProjectId把is_auto全部制为未自动化

        interfaceService.updateIsAutoFalse( interfacesList );

        //删除该rdProjectId下的所有关联关系

        autoCaseInterfaceService.deleteAutoCaseInterfaceByProjectId( rdProjectId );


        //遍历interface
        for (Interface record :
                interfacesList) {
            //单个path匹配autocase

            List<AutoCase> autoCaseList = autoCaseService.getAutoCaseByPath( record.getPath() );

            // >0修改interface is_auto 状态 =0不修改
            if (autoCaseList.size() > 0) {

                interfaceService.updateIsAutoTrue( record );

                //新增关联关系表
                for (AutoCase autoCase : autoCaseList) {
                    AutoCaseInterface autoCaseInterface = new AutoCaseInterface();
                    autoCaseInterface.setInterfaceId( record.getId() );
                    autoCaseInterface.setProjectId( record.getProjectId() );
                    autoCaseInterface.setCaseId( autoCase.getId() );
                    autoCaseInterfaceService.saveAutoCaseInterface( autoCaseInterface );
                }

            }

        }

    }
}
