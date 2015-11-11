package com.tianyi.yw.model;

import java.util.Date;

import com.tianyi.yw.common.utils.Page;
/**
 * 客户联系人
 * @author liqiang
 *
 */
public class CustomerUser extends Page {
    private Integer id;

    private String name;

    private Integer clientCompanyId;

    private Integer sex;

    private String phone;

    private String email;

    private String post;

    private String clientManager;

    private String clientManagerPhone;

    private Date createTime;

    private Integer createUser;

    private Integer flag;

    private Date deleteTime;

    private String logo;

    private Date firstTime;

    private String account;

    private String password;

    private String salt;

    //自定义
    private String  searchName;
    
    private String createUsername;
    
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

    public Integer getClientCompanyId() {
        return clientCompanyId;
    }

    public void setClientCompanyId(Integer clientCompanyId) {
        this.clientCompanyId = clientCompanyId;
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

    public String getClientManager() {
        return clientManager;
    }

    public void setClientManager(String clientManager) {
        this.clientManager = clientManager;
    }

    public String getClientManagerPhone() {
        return clientManagerPhone;
    }

    public void setClientManagerPhone(String clientManagerPhone) {
        this.clientManagerPhone = clientManagerPhone;
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

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
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

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
}