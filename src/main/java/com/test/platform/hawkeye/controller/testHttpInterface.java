package com.test.platform.hawkeye.controller;


import com.test.platform.hawkeye.constant.ProcessorEnum;
import com.test.platform.hawkeye.domain.general.AutoCase;
import com.test.platform.hawkeye.domain.general.ProcessorInfo;
import com.test.platform.hawkeye.domain.general.Project;
import com.test.platform.hawkeye.domain.general.ProjectAnalysis;
import com.test.platform.hawkeye.processor.HttpClassProcessor;
import com.test.platform.hawkeye.processor.ProcessorFactory;
import com.test.platform.hawkeye.service.AutoCaseService;
import com.test.platform.hawkeye.service.MatchService;
import com.test.platform.hawkeye.service.ProjectAnalysisService;
import com.test.platform.hawkeye.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/testInterface")
@RestController
public class testHttpInterface {

    protected static final Logger logger = LoggerFactory.getLogger( testHttpInterface.class );


    @Autowired
    ProcessorFactory processorFactory;


    @Autowired
    AutoCaseService autoCaseService;


    @Autowired
    MatchService matchService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectAnalysisService projectAnalysisService;


    /**
     * 扫描自动化接口方法
     *
     * @param projectId 项目id
     * @param scanType  扫描形式, 0增量 1全量
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/testScan", method = RequestMethod.POST)
    public String testAutoTest(@RequestParam int projectId, @RequestParam int scanType) throws Exception {
        logger.info( "进入到/testAuto,projectId:{} , scanType:{}", projectId, scanType );

        //通过获取当前操作人信息sso
        String operator = "等待获取";

        //获取project
        Project project = projectService.getProjectById( projectId );

        //初始化ProcessorInfo
        ProcessorInfo processorInfo = new ProcessorInfo();
        processorInfo.setOperator( operator );
        processorInfo.setProject( project );
        processorInfo.setScanType( scanType );

        //插入未开始状态的分析表数据 返回id
        ProjectAnalysis projectAnalysis = new ProjectAnalysis();
        projectAnalysis.setProjectId( projectId );
        projectAnalysis.setOperator( operator );
        projectAnalysisService.insertProjectAnalysis( projectAnalysis );

        //id传递到initprocessor中
        processorInfo.setAnalysisId( projectAnalysis.getId() );

        synchronized (ProcessorFactory.class) {
            processorFactory.InitProcessor( processorInfo );
        }

        return "执行完成";

    }


    @RequestMapping(value = "/saveProject", method = RequestMethod.POST)
    public String saveProject(@RequestBody Project project) throws Exception {
        logger.info( "进入到/saveProject,project:{},", project.toString() );

        projectService.saveProject( project );

        return "执行完成";

    }


    @RequestMapping(value = "/InsertProjectAnalysis", method = RequestMethod.GET)
    public String saveProjectAnalysis() throws Exception {
        logger.info( "进入到/ProjectAnalysis" );

        ProjectAnalysis projectAnalysis = new ProjectAnalysis();
        projectAnalysis.setProjectId( 8 );
        projectAnalysis.setStatus( 0 );
        projectAnalysis.setOperator( "杨宇" );
        int id = projectAnalysisService.insertProjectAnalysis( projectAnalysis );
        logger.info( "id:{}", id );
        logger.info( "projectAnalysis.id:{}", projectAnalysis.getId() );
        return "执行完成";
    }


    @RequestMapping(value = "/updateProjectAnalysis", method = RequestMethod.GET)
    public String updateProjectAnalysis() throws Exception {
        logger.info( "进入到/updateProjectAnalysis" );

        ProjectAnalysis projectAnalysis = projectAnalysisService.getProjectAnalysisById( 8 );
        projectAnalysis.setErrReason( "我不知道啊12321" );
        projectAnalysisService.updateProjectAnalysis( projectAnalysis );

        return "执行完成";
    }


    @RequestMapping(value = "/getAuto", method = RequestMethod.GET)
    public String GetAutoTest(@RequestParam int i) throws Exception {
        logger.info( "进入到getAuto,参数为i{}", i );

        AutoCase autoCase = autoCaseService.getAutoCaseById( i );
        return autoCase.toString();

    }

    @RequestMapping(value = "/getProject", method = RequestMethod.GET)
    public String GetProject(@RequestParam int i) throws Exception {
        logger.info( "进入到getAuto,参数为i{}", i );
        return projectService.getProjectById( i ).toString();

    }

    @RequestMapping(value = "/getMatch", method = RequestMethod.GET)
    public String GetMatch() throws Exception {
        logger.info( "进入到GetMatch" );

        //matchService.matchnIcrement( 1 );
        //matchService.matchnIcrement( 2 );
        //matchService.matchnTotalQuantity( 1 );
        matchService.matchnTotalQuantity( 1 );

        return "执行完成";

    }


    @RequestMapping(value = "/updateProject", method = RequestMethod.GET)
    public String updateProject() throws Exception {
        logger.info( "进入到/updateProject" );

        Project project = projectService.getProjectById( 3 );
        project.setOperator( "杨宇哈哈哈" );
        projectService.updateProject( project );

        return "执行完成";
    }


}
