package com.test.platform.hawkeye.controller;

import com.test.platform.hawkeye.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangyu on 2019/7/26.
 */

@RestController
public class mytest {

    protected static final Logger logger = LoggerFactory.getLogger( mytest.class );

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    @GetMapping
    public String mytest(@RequestParam int i) throws Exception {
        logger.info( "进入到mytest,参数为i{}", i );
        return userService.getUserById( i ).toString();
    }

}