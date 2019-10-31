package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.UserMapper;
import com.test.platform.hawkeye.domain.general.User;
import com.test.platform.hawkeye.domain.general.UserExample;
import com.test.platform.hawkeye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserById(Integer id) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo( id );
        return userMapper.selectByExample( userExample ).get( 0 );
    }
}
