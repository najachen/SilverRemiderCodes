package silver.reminder.care.model;

import java.io.Serializable;

public class CareTime implements Serializable {

    public static final String TABLE_NAME = "CARE_TIME";

    public static final String COL_TIME_ID_ = "TIME_ID";
    public static final String COL_TIME_TYPE = "TIME_TYPE";
    public static final String COL_TIME_CODE = "TIME_CODE";
    public static final String COL_TIME_VALUE1 = "TIME_VALUE1";
    public static final String COL_TIME_VALUE2 = "TIME_VALUE2";
    public static final String COL_MODIFIED_ON = "MODIFIED_ON";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
        "(" +
        COL_TIME_ID_ + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
        COL_TIME_TYPE + " TEXT NOT NULL, " +
        COL_TIME_CODE + " TEXT NOT NULL, " +
        COL_TIME_VALUE1 + " TEXT, " +
        COL_TIME_VALUE2 + " TEXT, " +
        COL_MODIFIED_ON + " TEXT " +
        ")";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private int timeId;
    private String timeType;
    private String timeCode;
    private String timeValue1;
    private String timeValue2;
    private String modifiedOn;

    public CareTime() {
    }

    public CareTime(int timeId, String timeType, String timeCode, String timeValue1, String timeValue2, String modifiedOn) {
        this.timeId = timeId;
        this.timeType = timeType;
        this.timeCode = timeCode;
        this.timeValue1 = timeValue1;
        this.timeValue2 = timeValue2;
        this.modifiedOn = modifiedOn;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(String timeCode) {
        this.timeCode = timeCode;
    }

    public String getTimeValue1() {
        return timeValue1;
    }

    public void setTimeValue1(String timeValue1) {
        this.timeValue1 = timeValue1;
    }

    public String getTimeValue2() {
        return timeValue2;
    }

    public void setTimeValue2(String timeValue2) {
        this.timeValue2 = timeValue2;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
