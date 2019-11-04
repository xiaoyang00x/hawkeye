package com.test.platform.hawkeye.domain.general;

import java.util.Date;

public class Project {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.branch
     *
     * @mbg.generated
     */
    private String branch;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.git
     *
     * @mbg.generated
     */
    private String git;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.operator
     *
     * @mbg.generated
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.is_delete
     *
     * @mbg.generated
     */
    private Integer isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.group
     *
     * @mbg.generated
     */
    private Integer group;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column he_project.scan_path
     *
     * @mbg.generated
     */
    private String scanPath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.id
     *
     * @return the value of he_project.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.id
     *
     * @param id the value for he_project.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.name
     *
     * @return the value of he_project.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.name
     *
     * @param name the value for he_project.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.description
     *
     * @return the value of he_project.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.description
     *
     * @param description the value for he_project.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.branch
     *
     * @return the value of he_project.branch
     *
     * @mbg.generated
     */
    public String getBranch() {
        return branch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.branch
     *
     * @param branch the value for he_project.branch
     *
     * @mbg.generated
     */
    public void setBranch(String branch) {
        this.branch = branch == null ? null : branch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.git
     *
     * @return the value of he_project.git
     *
     * @mbg.generated
     */
    public String getGit() {
        return git;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.git
     *
     * @param git the value for he_project.git
     *
     * @mbg.generated
     */
    public void setGit(String git) {
        this.git = git == null ? null : git.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.type
     *
     * @return the value of he_project.type
     *
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.type
     *
     * @param type the value for he_project.type
     *
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.operator
     *
     * @return the value of he_project.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.operator
     *
     * @param operator the value for he_project.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.create_time
     *
     * @return the value of he_project.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.create_time
     *
     * @param createTime the value for he_project.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.update_time
     *
     * @return the value of he_project.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.update_time
     *
     * @param updateTime the value for he_project.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.is_delete
     *
     * @return the value of he_project.is_delete
     *
     * @mbg.generated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.is_delete
     *
     * @param isDelete the value for he_project.is_delete
     *
     * @mbg.generated
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.group
     *
     * @return the value of he_project.group
     *
     * @mbg.generated
     */
    public Integer getGroup() {
        return group;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.group
     *
     * @param group the value for he_project.group
     *
     * @mbg.generated
     */
    public void setGroup(Integer group) {
        this.group = group;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column he_project.scan_path
     *
     * @return the value of he_project.scan_path
     *
     * @mbg.generated
     */
    public String getScanPath() {
        return scanPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column he_project.scan_path
     *
     * @param scanPath the value for he_project.scan_path
     *
     * @mbg.generated
     */
    public void setScanPath(String scanPath) {
        this.scanPath = scanPath == null ? null : scanPath.trim();
    }
}