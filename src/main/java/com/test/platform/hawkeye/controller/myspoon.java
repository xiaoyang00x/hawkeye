package com.test.platform.hawkeye.controller;

import com.test.platform.hawkeye.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/mytest")
@Resource(name="bean名字")
public class myspoon {

    protected static final Logger logger = LoggerFactory.getLogger( mytest.class );


    @RequestMapping("/testspoon")
    @GetMapping
    public String mytest(@RequestParam int i) throws Exception {
        return "test";
    }

}
