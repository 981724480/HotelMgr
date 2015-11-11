package com.tianyi.yw.model;

import java.util.Date;
import java.util.List;

import com.tianyi.yw.common.utils.Page;

public class User extends Page{
    private Integer id;

    private String name;

    private Integer companyId;

    private Integer sex;

    private String phone;

    private String email;

    private String post;

    private String roleKey;

    private Date createTime;

    private Integer createUser;

    private Integer flag;

    private Date deleteTime;

    private String logo;

    private String account;

    private String password;

    private String salt;

    private Integer signStatus;

    private Date signTime;
    
    
    
    
    /////自定义
    private String  searchName;
    
    private String companyName;
    
    private int selectedMainMemu;
    
    private int selectedChildMenu;
    
    private List<Function> childMenuList;
    
    private boolean rememberMe;
    
    /**
     * 前台角色选择模块
     */
    private List<Integer> userTypeList;
    
    private List<Integer> userFunList;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCredentialsSalt() {
        return account + salt;
    }

	public int getSelectedMainMemu() {
		return selectedMainMemu;
	}

	public void setSelectedMainMemu(int selectedMainMemu) {
		this.selectedMainMemu = selectedMainMemu;
	}

	public int getSelectedChildMenu() {
		return selectedChildMenu;
	}

	public void setSelectedChildMenu(int selectedChildMenu) {
		this.selectedChildMenu = selectedChildMenu;
	}

	public List<Function> getChildMenuList() {
		return childMenuList;
	}

	public void setChildMenuList(List<Function> childMenuList) {
		this.childMenuList = childMenuList;
	}

	public List<Integer> getUserTypeList() {
		return userTypeList;
	}

	public void setUserTypeList(List<Integer> userTypeList) {
		this.userTypeList = userTypeList;
	}

	public List<Integer> getUserFunList() {
		return userFunList;
	}

	public void setUserFunList(List<Integer> userFunList) {
		this.userFunList = userFunList;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
}