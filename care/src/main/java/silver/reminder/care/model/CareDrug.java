package silver.reminder.care.model;


import java.io.Serializable;

public class CareDrug implements Serializable {

    //資炓表, 用在dao
    public static final String TABLE_NAME = "CARE_DRUG";

    //資料表欄位, 用在dao
    public static final String COL_DRUG_ID = "DRUG_ID";
    public static final String COL_DRUG_VALUE = "DRUG_VALUE";
    public static final String COL_ENABLE = "ENABLE";
    public static final String COL_MODIFIED_ON = "MODIFIED_ON";

    //建立資料表SQL, 用在SqliteHelper.onCreate()
    public static final String CREATE_TABLE = "" + "CREATE TABLE " + TABLE_NAME +
        "(" +
        COL_DRUG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
        COL_DRUG_VALUE + " TEXT NOT NULL, " +
        COL_ENABLE + " TEXT NOT NULL, " +
        COL_MODIFIED_ON + " TEXT " +
        ")";

    //刪除資料表SQL, 用在SqliteHelper.onUpgrade()
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    //
    private int drugId;
    private String drugValue;
    private String enable;
    private String modifiedOn;

    public CareDrug() {
    }

    public CareDrug(int drugId, String drugValue, String enable, String modifiedOn) {
        this.drugId = drugId;
        this.drugValue = drugValue;
        this.enable = enable;
        this.modifiedOn = modifiedOn;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugValue() {
        return drugValue;
    }

    public void setDrugValue(String drugValue) {
        this.drugValue = drugValue;
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
