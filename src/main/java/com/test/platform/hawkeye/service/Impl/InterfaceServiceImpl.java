package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.InterfaceMapper;
import com.test.platform.hawkeye.domain.general.Interface;
import com.test.platform.hawkeye.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    InterfaceMapper interfaceMapper;

    @Override
    public int saveInterface(Interface record) {
        return interfaceMapper.insert( record );
    }

    @Override
    public int saveInterface(List<Interface> list) {
        return 0;
    }



}
