package com.test.platform.hawkeye.service;

import com.test.platform.hawkeye.domain.general.Interface;

import java.util.List;

public interface InterfaceService {
    public int saveInterface(Interface record);

    public int saveInterface(List<Interface> list);
}
