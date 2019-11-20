package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.AutoCaseInterfaceMapper;
import com.test.platform.hawkeye.domain.general.AutoCaseInterface;
import com.test.platform.hawkeye.domain.general.AutoCaseInterfaceExample;
import com.test.platform.hawkeye.service.AutoCaseInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutoCaseInterfaceServiceImpl implements AutoCaseInterfaceService {

    @Autowired
    AutoCaseInterfaceMapper autoCaseInterfaceMapper;

    @Override
    public int saveAutoCaseInterface(AutoCaseInterface autoCaseInterface) {
        return autoCaseInterfaceMapper.insert( autoCaseInterface );
    }

    @Override
    public int deleteAutoCaseInterfaceByProjectId(int projectId) {
        AutoCaseInterfaceExample autoCaseInterfaceExample = new AutoCaseInterfaceExample();
        autoCaseInterfaceExample.createCriteria().andProjectIdEqualTo( projectId );
        List<AutoCaseInterface> autoCaseInterfaceList = autoCaseInterfaceMapper.selectByExample( autoCaseInterfaceExample );
        for (AutoCaseInterface record :
                autoCaseInterfaceList) {
            //逻辑删除
            record.setIsDelete( (byte) 1 );
            AutoCaseInterfaceExample autoCaseInterfaceExampleIn = new AutoCaseInterfaceExample();
            autoCaseInterfaceExampleIn.createCriteria();
            autoCaseInterfaceExampleIn.createCriteria().andProjectIdEqualTo( projectId );
            autoCaseInterfaceExampleIn.createCriteria().andIdEqualTo( record.getId() );
            autoCaseInterfaceMapper.updateByExampleSelective( record, autoCaseInterfaceExampleIn );
        }
        return 0;
    }
}
