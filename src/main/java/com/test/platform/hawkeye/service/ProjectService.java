package com.test.platform.hawkeye.service;

import com.test.platform.hawkeye.domain.general.Project;

public interface ProjectService {

    public Project getProjectById(int ProjectId);

    public int saveProject(Project project);
}
