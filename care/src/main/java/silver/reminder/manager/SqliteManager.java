package silver.reminder.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqliteManager {

    //系統紀錄
    private static final String TAG = "careLog: " + SqliteManager.class.getName();

    //資料庫物件管理參數
    private Integer openCounter = 0;
    private static SqliteManager instance;
    private static SQLiteOpenHelper sqlhelper;
    private SQLiteDatabase database;

    //建立SQLite物件
    public static synchronized SqliteManager getInstance(Context c) {
        //null表示物件未建立，所以建立資料庫物件
        if (instance == null) {
            instance = new SqliteManager();
            sqlhelper = new SqliteHelper(c);
            Log.d(TAG,"getInstance() 建立SQLite物件");
        }
        return instance;
    }

    //開啟SQLite連線
    public synchronized SQLiteDatabase openDatabase() {
        //計算SQLite連線開啟次數
        openCounter++;
        //於第一次(=1)開啟連線即可
        if(openCounter == 1) {
            database = sqlhelper.getWritableDatabase();
            Log.d(TAG,"openDatabase() 開啟SQLite連線");
        }
        return database;
    }

    //關閉SQLite連線
    public synchronized void closeDatabase() {
        //計算SQLite連線開啟次數
        openCounter--;
        //於不使用時(=0)關閉連線即可
        if(openCounter == 0) {
            database.close();
            Log.d(TAG,"closeDatabase() 關閉SQLite連線");
        }
    }
}
