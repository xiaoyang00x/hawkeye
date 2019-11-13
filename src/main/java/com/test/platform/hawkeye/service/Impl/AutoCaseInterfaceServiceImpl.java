package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.AutoCaseInterfaceMapper;
import com.test.platform.hawkeye.domain.general.AutoCaseInterface;
import com.test.platform.hawkeye.domain.general.AutoCaseInterfaceExample;
import com.test.platform.hawkeye.service.AutoCaseInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutoCaseInterfaceServiceImpl implements AutoCaseInterfaceService {

    @Autowired
    AutoCaseInterfaceMapper autoCaseInterfaceMapper;

    @Override
    public int saveAutoCaseInterface(AutoCaseInterface autoCaseInterface) {
        return autoCaseInterfaceMapper.insert( autoCaseInterface );
    }
}
