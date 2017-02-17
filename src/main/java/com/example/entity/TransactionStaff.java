package com.example.entity;

public class TransactionStaff {
    private Integer staffId;

    private String staffCode;

    private String staffName;

    private String staffNameKana;

    private Integer staffDivisionId;

    private String staffMailaddress;

    private Byte staffStatus;

    public TransactionStaff(Integer staffId, String staffCode, String staffName, String staffNameKana, Integer staffDivisionId, String staffMailaddress, Byte staffStatus) {
        this.staffId = staffId;
        this.staffCode = staffCode;
        this.staffName = staffName;
        this.staffNameKana = staffNameKana;
        this.staffDivisionId = staffDivisionId;
        this.staffMailaddress = staffMailaddress;
        this.staffStatus = staffStatus;
    }

    public TransactionStaff() {
        super();
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffNameKana() {
        return staffNameKana;
    }

    public void setStaffNameKana(String staffNameKana) {
        this.staffNameKana = staffNameKana == null ? null : staffNameKana.trim();
    }

    public Integer getStaffDivisionId() {
        return staffDivisionId;
    }

    public void setStaffDivisionId(Integer staffDivisionId) {
        this.staffDivisionId = staffDivisionId;
    }

    public String getStaffMailaddress() {
        return staffMailaddress;
    }

    public void setStaffMailaddress(String staffMailaddress) {
        this.staffMailaddress = staffMailaddress == null ? null : staffMailaddress.trim();
    }

    public Byte getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(Byte staffStatus) {
        this.staffStatus = staffStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staffId=").append(staffId);
        sb.append(", staffCode=").append(staffCode);
        sb.append(", staffName=").append(staffName);
        sb.append(", staffNameKana=").append(staffNameKana);
        sb.append(", staffDivisionId=").append(staffDivisionId);
        sb.append(", staffMailaddress=").append(staffMailaddress);
        sb.append(", staffStatus=").append(staffStatus);
        sb.append("]");
        return sb.toString();
    }
}