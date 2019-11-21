package com.test.platform.hawkeye.domain.general;

import java.util.Date;

public class Interface {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.project_id
     *
     * @mbg.generated
     */
    private Integer projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.path
     *
     * @mbg.generated
     */
    private String path;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.is_auto
     *
     * @mbg.generated
     */
    private Integer isAuto = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.is_delete
     *
     * @mbg.generated
     */
    private Integer isDelete = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.request_type
     *
     * @mbg.generated
     */
    private Integer requestType = 0;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_interface.is_exclude
     *
     * @mbg.generated
     */
    private Integer isExclude = 0;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.id
     *
     * @return the value of he_interface.id
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.id
     *
     * @param id the value for he_interface.id
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.project_id
     *
     * @return the value of he_interface.project_id
     * @mbg.generated
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.project_id
     *
     * @param projectId the value for he_interface.project_id
     * @mbg.generated
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.name
     *
     * @return the value of he_interface.name
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.name
     *
     * @param name the value for he_interface.name
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.path
     *
     * @return the value of he_interface.path
     * @mbg.generated
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.path
     *
     * @param path the value for he_interface.path
     * @mbg.generated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.type
     *
     * @return the value of he_interface.type
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.type
     *
     * @param type the value for he_interface.type
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.is_auto
     *
     * @return the value of he_interface.is_auto
     * @mbg.generated
     */
    public Integer getIsAuto() {
        return isAuto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.is_auto
     *
     * @param isAuto the value for he_interface.is_auto
     * @mbg.generated
     */
    public void setIsAuto(Integer isAuto) {
        this.isAuto = isAuto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.create_time
     *
     * @return the value of he_interface.create_time
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.create_time
     *
     * @param createTime the value for he_interface.create_time
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.is_delete
     *
     * @return the value of he_interface.is_delete
     * @mbg.generated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.is_delete
     *
     * @param isDelete the value for he_interface.is_delete
     * @mbg.generated
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.request_type
     *
     * @return the value of he_interface.request_type
     * @mbg.generated
     */
    public Integer getRequestType() {
        return requestType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.request_type
     *
     * @param requestType the value for he_interface.request_type
     * @mbg.generated
     */
    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_interface.is_exclude
     *
     * @return the value of he_interface.is_exclude
     * @mbg.generated
     */
    public Integer getIsExclude() {
        return isExclude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_interface.is_exclude
     *
     * @param isExclude the value for he_interface.is_exclude
     * @mbg.generated
     */
    public void setIsExclude(Integer isExclude) {
        this.isExclude = isExclude;
    }


    @Override
    public String toString() {
        return "Interface{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", type=" + type +
                ", isAuto=" + isAuto +
                ", createTime=" + createTime +
                ", isDelete=" + isDelete +
                ", requestType=" + requestType +
                ", isExclude=" + isExclude +
                '}';
    }
}