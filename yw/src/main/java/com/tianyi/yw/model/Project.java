package com.tianyi.yw.model;

import java.util.Date;

import com.tianyi.yw.common.utils.Page;
/**
 * 项目
 * @author liqiang
 *
 */
public class Project  extends Page {
    private Integer id;

    private String projectNumber;

    private String name;

    private String district;

    private String industryKey;

    private Date startDate;

    private Date endDate;

    private String clientManager;

    private String maintainContract;

    private String contractNum;

    private Integer createUser;

    private Date createtTime;

    private Integer flag;

    private Date deleteTime;

    private Integer clientCompany;

    //自定义
    private String  searchName;
    
    private String maintainUsername;
    
    private Integer pointCount;
    
    private String areaName;
    
    private String maintainCompanyName;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIndustryKey() {
        return industryKey;
    }

    public void setIndustryKey(String industryKey) {
        this.industryKey = industryKey;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getClientManager() {
        return clientManager;
    }

    public void setClientManager(String clientManager) {
        this.clientManager = clientManager;
    }

    public String getMaintainContract() {
        return maintainContract;
    }

    public void setMaintainContract(String maintainContract) {
        this.maintainContract = maintainContract;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(Integer clientCompany) {
        this.clientCompany = clientCompany;
    }

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getMaintainUsername() {
		return maintainUsername;
	}

	public void setMaintainUsername(String maintainUsername) {
		this.maintainUsername = maintainUsername;
	}

	public Integer getPointCount() {
		return pointCount;
	}

	public void setPointCount(Integer pointCount) {
		this.pointCount = pointCount;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getMaintainCompanyName() {
		return maintainCompanyName;
	}

	public void setMaintainCompanyName(String maintainCompanyName) {
		this.maintainCompanyName = maintainCompanyName;
	}
}