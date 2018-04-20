package com.wqdata.upl.entity;

public class ClientInfo {

    private String mobile;

    private String deviceId;

    private String name;

    private String sex;

    private String idcard;

    private String edcationMax;

    private String isMarry;

    private String live;

    private String income;

    private String emaill;

    private String clientType;

    private String status;

    private String createtime;

    private String updatetime;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getEdcationMax() {
        return edcationMax;
    }

    public void setEdcationMax(String edcationMax) {
        this.edcationMax = edcationMax == null ? null : edcationMax.trim();
    }

    public String getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(String isMarry) {
        this.isMarry = isMarry == null ? null : isMarry.trim();
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live == null ? null : live.trim();
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill == null ? null : emaill.trim();
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType == null ? null : clientType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}