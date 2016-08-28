package silver.reminder.care.model;

import java.io.Serializable;

public class CareTask implements Serializable {

    public static final String TABLE_NAME = "CARE_TASK";

    //資料表欄位, 用在dao
    public static final String COL_CARE_ID = "CARE_ID";
    public static final String COL_CARE_SEQ = "CARE_SEQ";
    public static final String COL_CARE_DESC = "CARE_DESC";
    public static final String COL_REMIND_DATETIME = "REMIND_DATETIME";
    public static final String COL_REMIND_TIMES = "REMIND_TIMES";
    public static final String COL_CONFIRM = "CONFIRM";
    public static final String COL_CONFIRM_DATETIME = "CONFIRM_DATETIME";
    public static final String COL_MODIFIED_ON = "MODIFIED_ON";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
        "(" +
        COL_CARE_ID + " INTEGER NOT NULL, " +
        COL_CARE_SEQ + " INTEGER NOT NULL, " +
        COL_CARE_DESC + " TEXT NOT NULL, " +
        COL_REMIND_DATETIME + " TEXT NOT NULL, " +
        COL_REMIND_TIMES + " TEXT NOT NULL, " +
        COL_CONFIRM + " TEXT NOT NULL, " +
        COL_CONFIRM_DATETIME + " TEXT NOT NULL, " +
        COL_MODIFIED_ON + " TEXT, " +
        "PRIMARY KEY ( " + COL_CARE_ID + " ASC, " + COL_CARE_SEQ + " ASC )" +
        ")";

    //刪除資料表SQL, 用在SqliteHelper.onUpgrade()
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private int careId;
    private int careSeq;
    private String careDesc;
    private String remindDateTime;
    private String remindTimes;
    private String confirm;
    private String confirmDateTime;
    private String modifiedOn;

    public CareTask() {
    }

    public CareTask(int careId, int careSeq, String careDesc, String remindDateTime, String remindTimes, String confirm, String confirmDateTime, String modifiedOn) {
        this.careId = careId;
        this.careSeq = careSeq;
        this.careDesc = careDesc;
        this.remindDateTime = remindDateTime;
        this.remindTimes = remindTimes;
        this.confirm = confirm;
        this.confirmDateTime = confirmDateTime;
        this.modifiedOn = modifiedOn;
    }

    public int getCareId() {
        return careId;
    }

    public void setCareId(int careId) {
        this.careId = careId;
    }

    public int getCareSeq() {
        return careSeq;
    }

    public void setCareSeq(int careSeq) {
        this.careSeq = careSeq;
    }

    public String getCareDesc() {
        return careDesc;
    }

    public void setCareDesc(String careDesc) {
        this.careDesc = careDesc;
    }

    public String getRemindDateTime() {
        return remindDateTime;
    }

    public void setRemindDateTime(String remindDateTime) {
        this.remindDateTime = remindDateTime;
    }

    public String getRemindTimes() {
        return remindTimes;
    }

    public void setRemindTimes(String remindTimes) {
        this.remindTimes = remindTimes;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getConfirmDateTime() {
        return confirmDateTime;
    }

    public void setConfirmDateTime(String confirmDateTime) {
        this.confirmDateTime = confirmDateTime;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
