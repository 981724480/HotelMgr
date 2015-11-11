package com.tianyi.yw.model;

import java.util.Date;

import com.tianyi.yw.common.utils.Page;

/**
 * 维护区域分配人员
 * @author liqiang
 *
 */
public class AreaUser  extends Page{
    private Integer id;

    private Integer areaId;

    private Integer projectId;

    private Integer userId;

    private Integer createUser;

    private Date createtTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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