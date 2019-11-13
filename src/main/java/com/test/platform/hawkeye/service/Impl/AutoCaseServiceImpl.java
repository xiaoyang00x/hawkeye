package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.AutoCaseMapper;
import com.test.platform.hawkeye.domain.general.AutoCase;
import com.test.platform.hawkeye.domain.general.AutoCaseExample;
import com.test.platform.hawkeye.domain.general.UserExample;
import com.test.platform.hawkeye.service.AutoCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutoCaseServiceImpl implements AutoCaseService {

    @Autowired
    AutoCaseMapper autoCaseMapper;

    @Override
    public int saveAutocase(AutoCase record) {
        return autoCaseMapper.insert( record );
    }

    @Override
    public AutoCase getAutoCaseById(int id) {
        AutoCaseExample autoCaseExample = new AutoCaseExample();
        autoCaseExample.createCriteria().andIdEqualTo( id );
        return autoCaseMapper.selectByExampleWithBLOBs( autoCaseExample ).get( 0 );
    }

    @Override
    public List<AutoCase> getAutoCaseByPath(String path) {
        AutoCaseExample autoCaseExample = new AutoCaseExample();
        autoCaseExample.createCriteria().andPathEqualTo( path );
        return autoCaseMapper.selectByExampleWithBLOBs( autoCaseExample );
    }
}
