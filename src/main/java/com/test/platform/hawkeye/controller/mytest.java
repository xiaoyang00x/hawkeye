package com.test.platform.hawkeye.controller;

import com.test.platform.hawkeye.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangyu on 2019/7/26.
 */

@RestController
@RequestMapping("/mytest1234")
public class mytest {

    protected static final Logger logger = LoggerFactory.getLogger( mytest.class );

    @Autowired
    UserService userService;

    @RequestMapping(value = "/no", method = RequestMethod.POST)
    public String requestmethodpost(@RequestParam int i) throws Exception {
        logger.info( "进入到mytest,参数为i{}", i );
        return userService.getUserById( i ).toString();
    }


    @RequestMapping(value = "/have")
    @GetMapping
    public String getmapping(@RequestParam int i) throws Exception {
        logger.info( "进入到mytest,参数为i{}", i );
        return userService.getUserById( i ).toString();
    }


    @RequestMapping(value = "/havepost")
    @PostMapping
    public String postmappint(@RequestParam int i) throws Exception {
        logger.info( "进入到mytest,参数为i{}", i );
        return userService.getUserById( i ).toString();
    }

}
