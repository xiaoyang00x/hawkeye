package com.test.platform.hawkeye.service.Impl;

import com.test.platform.hawkeye.dao.ProjectAnalysisMapper;
import com.test.platform.hawkeye.domain.general.ProjectAnalysis;
import com.test.platform.hawkeye.domain.general.ProjectAnalysisExample;
import com.test.platform.hawkeye.service.ProjectAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectAnalysisServiceImpl implements ProjectAnalysisService {

    @Autowired
    ProjectAnalysisMapper projectAnalysisMapper;


    @Override
    public int insertProjectAnalysis(ProjectAnalysis record) {
        return projectAnalysisMapper.insert( record );
    }

    @Override
    public int updateProjectAnalysis(ProjectAnalysis record) {

        ProjectAnalysisExample projectAnalysisExample = new ProjectAnalysisExample();
        projectAnalysisExample.createCriteria().andIdEqualTo( record.getId() );
        return projectAnalysisMapper.updateByExampleWithBLOBs( record, projectAnalysisExample );
    }

    @Override
    public ProjectAnalysis getProjectAnalysisById(Integer id) {
        ProjectAnalysisExample projectAnalysisExample = new ProjectAnalysisExample();
        projectAnalysisExample.createCriteria().andIdEqualTo( id );
        return projectAnalysisMapper.selectByExampleWithBLOBs( projectAnalysisExample ).get( 0 );
    }
}
