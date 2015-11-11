package com.tianyi.yw.model;

import java.util.Date;

import com.tianyi.yw.common.utils.Page;

public class Point extends Page{
    private Integer id;

    private String pointId;

    private String pointNumber;

    private String name;

    private Integer type;

    private String address;

    private String locationX;

    private String locationY;

    private Integer projectId;

    private Integer areaId;

    private Integer createUser;

    private Date createtTime;

    private String pointPicture;

    private String ipAddress;

    private Integer flag;

    private Date deleteTime;

    private Integer limitTime;
    
    /////
    private Project project;
    
    private String searchPointName;
    
    private String searchPointNumber;
    
    private String searchProjectName;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(String pointNumber) {
        this.pointNumber = pointNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
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

    public String getPointPicture() {
        return pointPicture;
    }

    public void setPointPicture(String pointPicture) {
        this.pointPicture = pointPicture;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSearchPointName() {
		return searchPointName;
	}

	public void setSearchPointName(String searchPointName) {
		this.searchPointName = searchPointName;
	}

	public String getSearchPointNumber() {
		return searchPointNumber;
	}

	public void setSearchPointNumber(String searchPointNumber) {
		this.searchPointNumber = searchPointNumber;
	}

	public String getSearchProjectName() {
		return searchProjectName;
	}

	public void setSearchProjectName(String searchProjectName) {
		this.searchProjectName = searchProjectName;
	}
}