package com.tianyi.yw.model;

import java.util.Date;

public class TicketUser {
    private Integer id;

    private Integer userId;

    private Integer dispatchUser;

    private Date dispatchTime;

    private Integer status;

    private Integer ticketId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDispatchUser() {
        return dispatchUser;
    }

    public void setDispatchUser(Integer dispatchUser) {
        this.dispatchUser = dispatchUser;
    }

    public Date getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}