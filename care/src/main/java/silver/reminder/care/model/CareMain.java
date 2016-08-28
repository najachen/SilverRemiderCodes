package silver.reminder.care.model;

import java.io.Serializable;

public class CareMain implements Serializable {

    public static final String TABLE_NAME = "CARE_MAIN";

    //column
    public static final String COL_CARE_ID = "CARE_ID";
    public static final String COL_MEMBER_ID = "MEMBER_ID";
    public static final String COL_MEMBER_VALUE = "MEMBER_VALUE";
    public static final String COL_MEAL_ID = "MEAL_ID";
    public static final String COL_MEAL_VALUE = "MEAL_VALUE";
    public static final String COL_CYCLE_ID = "CYCLE_ID";
    public static final String COL_CYCLE_VALUE = "CYCLE_VALUE";
    public static final String COL_BEGIN_DATE = "BEGIN_DATE";
    public static final String COL_TIME_ID = "TIME_ID";
    public static final String COL_TIME_VALUE = "TIME_VALUE";
    public static final String COL_DRUG_ID = "DRUG_ID";
    public static final String COL_DRUG_VALUE = "DRUG_VALUE";
    public static final String COL_CARE_DESC = "CARE_DESC";
    public static final String COL_CONFIRM = "CONFIRM";
    public static final String COL_CONFIRM_DATETIME = "CONFIRM_DATETIME";
    public static final String COL_MODIFIED_ON = "MODIFIED_ON";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
        "(" +
        COL_CARE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
        COL_MEMBER_ID + " INTEGER NOT NULL, " +
        COL_MEMBER_VALUE + " TEXT, " +
        COL_MEAL_ID + " INTEGER NOT NULL, " +
        COL_MEAL_VALUE + " TEXT, " +
        COL_CYCLE_ID + " INTEGER NOT NULL, " +
        COL_CYCLE_VALUE + " TEXT, " +
        COL_BEGIN_DATE + " TEXT NOT NULL, " +
        COL_TIME_ID + " TEXT NOT NULL, " +
        COL_TIME_VALUE + " TEXT, " +
        COL_DRUG_ID + " TEXT NOT NULL, " +
        COL_DRUG_VALUE + " TEXT, " +
        COL_CARE_DESC + " TEXT, " +
        COL_CONFIRM + " TEXT, " +
        COL_CONFIRM_DATETIME + " TEXT, " +
        COL_MODIFIED_ON + " TEXT " +
        ")";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private int careId;
    private int memberId;
    private String memberValue;
    private int mealId;
    private String mealValue;
    private int cycleId;
    private String cycleValue;
    private String beginDate;
    private String timeId;
    private String timeValue;
    private String drugId;
    private String drugValue;
    private String careDesc;
    private String confirm;
    private String confirmDateTime;
    private String modifiedOn;

    public CareMain() {
    }

    public CareMain(int careId, int memberId, String memberValue, int mealId, String mealValue, int cycleId, String cycleValue, String beginDate, String timeId, String timeValue, String drugId, String drugValue, String careDesc, String confirm, String confirmDateTime, String modifiedOn) {
        this.careId = careId;
        this.memberId = memberId;
        this.memberValue = memberValue;
        this.mealId = mealId;
        this.mealValue = mealValue;
        this.cycleId = cycleId;
        this.cycleValue = cycleValue;
        this.beginDate = beginDate;
        this.timeId = timeId;
        this.timeValue = timeValue;
        this.drugId = drugId;
        this.drugValue = drugValue;
        this.careDesc = careDesc;
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

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealValue() {
        return mealValue;
    }

    public void setMealValue(String mealValue) {
        this.mealValue = mealValue;
    }

    public int getCycleId() {
        return cycleId;
    }

    public void setCycleId(int cycleId) {
        this.cycleId = cycleId;
    }

    public String getCycleValue() {
        return cycleValue;
    }

    public void setCycleValue(String cycleValue) {
        this.cycleValue = cycleValue;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }

    public String getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(String timeValue) {
        this.timeValue = timeValue;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugValue() {
        return drugValue;
    }

    public void setDrugValue(String drugValue) {
        this.drugValue = drugValue;
    }

    public String getCareDesc() {
        return careDesc;
    }

    public void setCareDesc(String careDesc) {
        this.careDesc = careDesc;
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
