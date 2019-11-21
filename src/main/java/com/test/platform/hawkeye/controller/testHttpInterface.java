package com.test.platform.hawkeye.controller;


import com.test.platform.hawkeye.constant.ProcessorEnum;
import com.test.platform.hawkeye.domain.general.AutoCase;
import com.test.platform.hawkeye.processor.HttpClassProcessor;
import com.test.platform.hawkeye.processor.ProcessorFactory;
import com.test.platform.hawkeye.service.AutoCaseService;
import com.test.platform.hawkeye.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "/testHttp", method = RequestMethod.GET)
    public String requestmethodpost(@RequestParam int i) throws Exception {
        logger.info( "进入到mytest,参数为i{}", i );

        processorFactory.InitProcessor( ProcessorEnum.HTTP );

        return "执行完成";

    }


    @RequestMapping(value = "/testAuto", method = RequestMethod.GET)
    public String testAutoTest(@RequestParam int i) throws Exception {
        logger.info( "进入到testAutoTest,参数为i{}", i );

        processorFactory.InitProcessor( ProcessorEnum.AUTO );

        return "执行完成";

    }


    @RequestMapping(value = "/getAuto", method = RequestMethod.GET)
    public String GetAutoTest(@RequestParam int i) throws Exception {
        logger.info( "进入到getAuto,参数为i{}", i );

        AutoCase autoCase = autoCaseService.getAutoCaseById( i );
        return autoCase.toString();

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
