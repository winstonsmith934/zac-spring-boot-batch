package com.example.entity;

import java.util.Date;

public class MasterDivision {
    private Integer divisionId;

    private String divisionName;

    private Date createTime;

    private Date updateTime;

    public MasterDivision(Integer divisionId, String divisionName, Date createTime, Date updateTime) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public MasterDivision() {
        super();
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName == null ? null : divisionName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", divisionId=").append(divisionId);
        sb.append(", divisionName=").append(divisionName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}