package com.test.platform.hawkeye.service;

import com.test.platform.hawkeye.domain.general.AutoCase;

public interface AutoCaseService {

    public int saveAutocase(AutoCase record);

    public AutoCase getAutoCaseById(int id);

}
