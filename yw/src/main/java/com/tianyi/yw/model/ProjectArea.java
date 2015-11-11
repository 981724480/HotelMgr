package com.tianyi.yw.model;

import java.util.Date;

import com.tianyi.yw.common.utils.Page;

/**
 * 项目区域关系
 * @author liqiang
 *
 */
public class ProjectArea  extends Page{
    private Integer id;

    private Integer projectId;

    private Integer areaId;

    private Integer createUser;

    private Date createtTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreatetTime() {
        return createtTime;
    }

    public void setCreatetTime(Date createtTime) {
        this.createtTime = createtTime;
    }
}