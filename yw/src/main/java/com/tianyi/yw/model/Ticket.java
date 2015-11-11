package com.tianyi.yw.model;

import java.util.Date;

public class Ticket {
    private Integer id;

    private String typeKey;

    private String ticketNumber;

    private Integer userId;

    private Date createTime;

    private String summary;

    private String comment;

    private Integer status;

    private Date updateTime;

    private Integer sourceId;

    private Integer pointId;

    private Integer projectId;

    private String clientPhone;

    private Integer messageSend;

    private String handleHour;

    private Integer intoStore;

    private Integer alertStatus;

    private String alertComment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Integer getMessageSend() {
        return messageSend;
    }

    public void setMessageSend(Integer messageSend) {
        this.messageSend = messageSend;
    }

    public String getHandleHour() {
        return handleHour;
    }

    public void setHandleHour(String handleHour) {
        this.handleHour = handleHour;
    }

    public Integer getIntoStore() {
        return intoStore;
    }

    public void setIntoStore(Integer intoStore) {
        this.intoStore = intoStore;
    }

    public Integer getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(Integer alertStatus) {
        this.alertStatus = alertStatus;
    }

    public String getAlertComment() {
        return alertComment;
    }

    public void setAlertComment(String alertComment) {
        this.alertComment = alertComment;
    }
}