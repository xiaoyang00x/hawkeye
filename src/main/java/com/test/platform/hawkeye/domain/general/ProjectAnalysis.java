package com.test.platform.hawkeye.domain.general;

import java.util.Date;

public class ProjectAnalysis {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project_analysis.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project_analysis.project_id
     *
     * @mbg.generated
     */
    private Integer projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project_analysis.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project_analysis.operator
     *
     * @mbg.generated
     */
    private String operator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project_analysis.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project_analysis.is_delete
     *
     * @mbg.generated
     */
    private Byte isDelete = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project_analysis.err_reason
     *
     * @mbg.generated
     */
    private String errReason;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project_analysis.id
     *
     * @return the value of he_project_analysis.id
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project_analysis.id
     *
     * @param id the value for he_project_analysis.id
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project_analysis.project_id
     *
     * @return the value of he_project_analysis.project_id
     * @mbg.generated
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project_analysis.project_id
     *
     * @param projectId the value for he_project_analysis.project_id
     * @mbg.generated
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project_analysis.status
     *
     * @return the value of he_project_analysis.status
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project_analysis.status
     *
     * @param status the value for he_project_analysis.status
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project_analysis.operator
     *
     * @return the value of he_project_analysis.operator
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project_analysis.operator
     *
     * @param operator the value for he_project_analysis.operator
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project_analysis.create_time
     *
     * @return the value of he_project_analysis.create_time
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project_analysis.create_time
     *
     * @param createTime the value for he_project_analysis.create_time
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project_analysis.is_delete
     *
     * @return the value of he_project_analysis.is_delete
     * @mbg.generated
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project_analysis.is_delete
     *
     * @param isDelete the value for he_project_analysis.is_delete
     * @mbg.generated
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project_analysis.err_reason
     *
     * @return the value of he_project_analysis.err_reason
     * @mbg.generated
     */
    public String getErrReason() {
        return errReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project_analysis.err_reason
     *
     * @param errReason the value for he_project_analysis.err_reason
     * @mbg.generated
     */
    public void setErrReason(String errReason) {
        this.errReason = errReason == null ? null : errReason.trim();
    }
}