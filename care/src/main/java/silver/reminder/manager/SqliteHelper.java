package silver.reminder.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import silver.reminder.care.model.CareDrug;
import silver.reminder.care.model.CareMain;
import silver.reminder.care.model.CareMember;
import silver.reminder.care.model.CareTask;
import silver.reminder.care.model.CareTime;


public class SqliteHelper extends SQLiteOpenHelper {

    //系統紀錄
    private static final String TAG = "careLog: " + SqliteHelper.class.getName();

    //資料庫參數
    private static final String DATABASE_NAME = "care.db";
    private static final int DATABASE_VERSION = 5;

    //建立Sqlite物件
    public SqliteHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG,"SqliteHelper() 建立Sqlite物件");
    }

    //初次新增Sqlite(*.db)時會呼叫此方法
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //建立資料表
        Log.d(TAG,"onCreate() 建立資料表");
        sqLiteDatabase.execSQL(CareMain.CREATE_TABLE);
        Log.d(TAG,"onCreate() ...提醒主檔資料表建立");
        sqLiteDatabase.execSQL(CareTask.CREATE_TABLE);
        Log.d(TAG,"onCreate() ...提醒任務資料表建立");
        sqLiteDatabase.execSQL(CareDrug.CREATE_TABLE);
        Log.d(TAG,"onCreate() ...保健項目資料表建立");
        sqLiteDatabase.execSQL(CareMember.CREATE_TABLE);
        Log.d(TAG,"onCreate() ...成員名單資料表建立");
        sqLiteDatabase.execSQL(CareTime.CREATE_TABLE);
        Log.d(TAG,"onCreate() ...時間參數資料表建立");
        //
        Log.d(TAG,"onCreate() 新增預設資料");
    }

    //Sqlite版本(DATABASE_VERSION)升級時會呼叫此方法
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //備份資料表
        Log.d(TAG,"onUpgrade() 備份資料表");
        //移除資料表
        Log.d(TAG,"onUpgrade() 移除資料表");
        sqLiteDatabase.execSQL(CareMain.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ...提醒主檔資料表移除");
        sqLiteDatabase.execSQL(CareTask.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ...提醒任務資料表移除");
        sqLiteDatabase.execSQL(CareDrug.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ...保健項目資料表移除");
        sqLiteDatabase.execSQL(CareMember.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ...成員名單資料表移除");
        sqLiteDatabase.execSQL(CareTime.DROP_TABLE);
        Log.d(TAG,"onUpgrade() ...時間參數資料表移除");
        //重新建立資料表及新增預設資料
        onCreate(sqLiteDatabase);
    }
}
