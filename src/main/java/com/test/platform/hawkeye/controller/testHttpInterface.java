package com.test.platform.hawkeye.controller;


import com.test.platform.hawkeye.constant.ProcessorEnum;
import com.test.platform.hawkeye.domain.general.AutoCase;
import com.test.platform.hawkeye.domain.general.ProcessorInfo;
import com.test.platform.hawkeye.domain.general.Project;
import com.test.platform.hawkeye.processor.HttpClassProcessor;
import com.test.platform.hawkeye.processor.ProcessorFactory;
import com.test.platform.hawkeye.service.AutoCaseService;
import com.test.platform.hawkeye.service.MatchService;
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

        Project project = projectService.getProjectById( projectId );

        processorFactory.InitProcessor( project, scanType );

        return "执行完成";

    }


    @RequestMapping(value = "/saveProject", method = RequestMethod.POST)
    public String saveProject(@RequestBody Project project) throws Exception {
        logger.info( "进入到/saveProject,project:{},", project.toString() );

        projectService.saveProject( project );

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

}
