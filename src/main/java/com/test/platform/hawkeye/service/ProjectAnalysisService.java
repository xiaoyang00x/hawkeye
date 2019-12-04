package com.test.platform.hawkeye.service;

import com.test.platform.hawkeye.domain.general.ProjectAnalysis;

public interface ProjectAnalysisService {

    int insertProjectAnalysis(ProjectAnalysis record);

    int updateProjectAnalysis(ProjectAnalysis record);

    ProjectAnalysis getProjectAnalysisById(Integer id);


}
