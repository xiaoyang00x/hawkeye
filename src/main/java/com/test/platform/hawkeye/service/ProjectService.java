package com.test.platform.hawkeye.service;

import com.test.platform.hawkeye.domain.general.Project;

public interface ProjectService {

    Project getProjectById(int ProjectId);

    int saveProject(Project project);

    int updateProject(Project project);
}
