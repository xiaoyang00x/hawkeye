package com.test.platform.hawkeye;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.test.platform.hawkeye.dao")
public class HawkeyeApplication {

    public static void main(String[] args) {
        SpringApplication.run( HawkeyeApplication.class, args );
    }

}
