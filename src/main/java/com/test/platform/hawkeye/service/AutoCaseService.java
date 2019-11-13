package com.test.platform.hawkeye.service;

import com.test.platform.hawkeye.domain.general.AutoCase;

import java.util.List;

public interface AutoCaseService {

    public int saveAutocase(AutoCase record);

    public AutoCase getAutoCaseById(int id);

    public List<AutoCase> getAutoCaseByPath(String path);

}
