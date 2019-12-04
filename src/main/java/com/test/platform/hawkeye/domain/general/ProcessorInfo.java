package com.test.platform.hawkeye.domain.general;


/**
 * 介质类
 */
public class ProcessorInfo {
    private Project project;

    private Integer scanType;

    private String operator;

    private Integer analysisId;


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getScanType() {
        return scanType;
    }

    public void setScanType(Integer scanType) {
        this.scanType = scanType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Integer analysisId) {
        this.analysisId = analysisId;
    }

    @Override
    public String toString() {
        return "ProcessorInfo{" +
                "project=" + project +
                ", scanType=" + scanType +
                ", operator='" + operator + '\'' +
                ", analysisId='" + analysisId + '\'' +
                '}';
    }
}
