package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.ProjectMapper;
import com.test.platform.hawkeye.domain.general.Project;
import com.test.platform.hawkeye.domain.general.ProjectExample;
import com.test.platform.hawkeye.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public Project getProjectById(int ProjectId) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andIdEqualTo( ProjectId );
        return projectMapper.selectByExample( projectExample ).get( 0 );
    }
}
