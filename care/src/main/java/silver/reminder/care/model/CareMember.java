package silver.reminder.care.model;

import java.io.Serializable;

public class CareMember implements Serializable {

    public static final String TABLE_NAME = "CARE_MEMBER";

    public static final String COL_MEMBER_ID = "MEMBER_ID";
    public static final String COL_MEMBER_VALUE = "MEMBER_VALUE";
    public static final String COL_ENABLE = "ENABLE";
    public static final String COL_MODIFIED_ON = "MODIFIED_ON";

    public static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + "(" +
        COL_MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
        COL_MEMBER_VALUE + " TEXT NOT NULL, " +
        COL_ENABLE + " TEXT NOT NULL,  " +
        COL_MODIFIED_ON + " TEXT " +
        ")";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private int memberId;
    private String memberValue;
    private String enable;
    private String modifiedOn;

    public CareMember() {
    }

    public CareMember(int memberId, String memberValue, String enable, String modifiedOn) {
        this.memberId = memberId;
        this.memberValue = memberValue;
        this.enable = enable;
        this.modifiedOn = modifiedOn;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberValue() {
        return memberValue;
    }

    public void setMemberValue(String memberValue) {
        this.memberValue = memberValue;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
