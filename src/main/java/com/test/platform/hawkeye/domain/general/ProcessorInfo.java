package com.test.platform.hawkeye.domain.general;

import com.test.platform.hawkeye.constant.ProcessorEnum;

public class ProcessorInfo {

    private ProcessorEnum processorEnum;

    private String processorTargePath;

    private String scanPath;

    public ProcessorEnum getProcessorEnum() {
        return processorEnum;
    }

    public void setProcessorEnum(ProcessorEnum processorEnum) {
        this.processorEnum = processorEnum;
    }

    public String getProcessorTargePath() {
        return processorTargePath;
    }

    public void setProcessorTargePath(String processorTargePath) {
        this.processorTargePath = processorTargePath;
    }

    public String getScanPath() {
        return scanPath;
    }

    public void setScanPath(String scanPath) {
        this.scanPath = scanPath;
    }

    @Override
    public String toString() {
        return "ProcessorInfo{" +
                "processorEnum=" + processorEnum +
                ", processorTargePath='" + processorTargePath + '\'' +
                ", scanPath='" + scanPath + '\'' +
                '}';
    }
}
