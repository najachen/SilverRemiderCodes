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

    private static final String TAG = "careLog: " + SqliteHelper.class.getName();

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
        sqLiteDatabase.execSQL(CareMain.CREATE_TABLE);
        sqLiteDatabase.execSQL(CareTask.CREATE_TABLE);
        sqLiteDatabase.execSQL(CareDrug.CREATE_TABLE);
        sqLiteDatabase.execSQL(CareMember.CREATE_TABLE);
        sqLiteDatabase.execSQL(CareTime.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(CareMain.DROP_TABLE);
        sqLiteDatabase.execSQL(CareTask.DROP_TABLE);
        sqLiteDatabase.execSQL(CareDrug.DROP_TABLE);
        sqLiteDatabase.execSQL(CareMember.DROP_TABLE);
        sqLiteDatabase.execSQL(CareTime.DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}
