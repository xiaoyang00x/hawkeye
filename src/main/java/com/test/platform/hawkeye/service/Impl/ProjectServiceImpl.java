package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.ProjectMapper;
import com.test.platform.hawkeye.domain.general.Project;
import com.test.platform.hawkeye.domain.general.ProjectAnalysisExample;
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

    @Override
    public int saveProject(Project project) {
        return projectMapper.insertSelective( project );
    }

    @Override
    public int updateProject(Project project) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andIdEqualTo( project.getId() );
        return projectMapper.updateByExampleSelective( project, projectExample );
    }
}
