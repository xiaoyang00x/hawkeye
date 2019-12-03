package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.InterfaceMapper;
import com.test.platform.hawkeye.domain.general.Interface;
import com.test.platform.hawkeye.domain.general.InterfaceExample;
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

    @Override
    public List<Interface> getAllInterfaceByProjectId(int projectId) {
        InterfaceExample interfaceExample = new InterfaceExample();
        interfaceExample.createCriteria().andProjectIdEqualTo( projectId );
        return interfaceMapper.selectByExample( interfaceExample );
    }

    @Override
    public void updateIsAutoFalse(List<Interface> interfaceList) {

        for (Interface record :
                interfaceList) {
            InterfaceExample interfaceExample = new InterfaceExample();
            interfaceExample.createCriteria().andIdEqualTo( record.getId() );
            record.setIsAuto( 0 );
            interfaceMapper.updateByExampleSelective( record, interfaceExample );

        }

    }

    @Override
    public int updateIsAutoTrue(Interface interfaceRecord) {
        InterfaceExample interfaceExample = new InterfaceExample();
        interfaceExample.createCriteria().andIdEqualTo( interfaceRecord.getId() );
        interfaceRecord.setIsAuto( 1 );
        return interfaceMapper.updateByExampleSelective( interfaceRecord, interfaceExample );
    }

    @Override
    public int deleteByProjectId(int projectId) {
        return interfaceMapper.updateIsDeleteByProjectId( projectId );

    }


}
