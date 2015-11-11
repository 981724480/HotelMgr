package com.tianyi.yw.model;

import com.tianyi.yw.common.utils.Page;

/**
 * 项目和维护公司关系
 * @author liqiang
 *
 */
public class ProjectCompany  extends Page{
    private Integer id;

    private Integer projectId;

    private Integer companyId;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}