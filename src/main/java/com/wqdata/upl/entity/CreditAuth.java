package com.wqdata.upl.entity;

public class CreditAuth {
    private String agreeName;

    private String idcard;

    private String applicationNo;

    private String agreeTime;

    private String createtime;

    private String updatetime;

    private String zoneCode;

    private String signedFile;

    public String getAgreeName() {
        return agreeName;
    }

    public void setAgreeName(String agreeName) {
        this.agreeName = agreeName == null ? null : agreeName.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo == null ? null : applicationNo.trim();
    }

    public String getAgreeTime() {
        return agreeTime;
    }

    public void setAgreeTime(String agreeTime) {
        this.agreeTime = agreeTime == null ? null : agreeTime.trim();
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

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode == null ? null : zoneCode.trim();
    }

    public String getSignedFile() {
        return signedFile;
    }

    public void setSignedFile(String signedFile) {
        this.signedFile = signedFile == null ? null : signedFile.trim();
    }
}