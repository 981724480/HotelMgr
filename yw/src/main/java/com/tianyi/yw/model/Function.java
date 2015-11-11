package com.tianyi.yw.model;

import java.util.List;

public class Function {
    private Integer id;

    private String name;

    private String url;

    private Integer sort;

    private Integer flag;

    private String serialCode;

    private Integer parentId;

    private String cssCode;
    
    private int selected;
    
    private List<Function> childFunctionlist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCssCode() {
        return cssCode;
    }

    public void setCssCode(String cssCode) {
        this.cssCode = cssCode;
    }

	public List<Function> getChildFunctionlist() {
		return childFunctionlist;
	}

	public void setChildFunctionlist(List<Function> childFunctionlist) {
		this.childFunctionlist = childFunctionlist;
	}
}