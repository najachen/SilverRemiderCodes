package silver.reminder.care.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import silver.reminder.care.model.CareDrug;
import silver.reminder.manager.SqliteManager;

public class CareDrugDao {

    private static final String TAG = "careLog: " + CareDrugDao.class.getName();

    public CareDrugDao() {
    }

    //查詢全部資料
    public List<CareDrug> query(Context context) {
        Log.i(TAG, "query() 查詢全部資料");
        List<CareDrug> drugs = new ArrayList<>();
        //開啟資料庫連線
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        String sql = "" +
            "SELECT " + CareDrug.COL_DRUG_ID +
            "     , " + CareDrug.COL_DRUG_VALUE +
            "     , " + CareDrug.COL_ENABLE +
            "     , " + CareDrug.COL_MODIFIED_ON +
            "  FROM " + CareDrug.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            CareDrug drug = new CareDrug();
            drug.setDrugId(cursor.getInt(cursor.getColumnIndex(CareDrug.COL_DRUG_ID)));
            drug.setDrugValue(cursor.getString(cursor.getColumnIndex(CareDrug.COL_DRUG_VALUE)));
            drug.setEnable(cursor.getString(cursor.getColumnIndex(CareDrug.COL_ENABLE)));
            drug.setModifiedOn(cursor.getString(cursor.getColumnIndex(CareDrug.COL_MODIFIED_ON)));
            drugs.add(drug);
        }
        cursor.close();
        //關閉資料庫連線
        SqliteManager.getInstance(context).closeDatabase();
        Log.i(TAG, "query() ...資料筆數=" + drugs.size());
        return drugs;
    }

    //新增
    public int insert(Context context, CareDrug drug) {
        Log.i(TAG, "insert() 新增");
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ContentValues values = new ContentValues();
        values.put(CareDrug.COL_DRUG_VALUE, drug.getDrugValue());
        values.put(CareDrug.COL_ENABLE, drug.getEnable());
        values.put(CareDrug.COL_MODIFIED_ON, now);
        int rowId = (int) db.insert(CareDrug.TABLE_NAME, null, values);
        Log.i(TAG, "insert() ...rowId=" + rowId);
        SqliteManager.getInstance(context).closeDatabase();
        return rowId;
    }

    public int update(Context context, CareDrug drug) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ContentValues values = new ContentValues();
        values.put(CareDrug.COL_DRUG_VALUE, drug.getDrugValue());
        values.put(CareDrug.COL_ENABLE, drug.getEnable());
        values.put(CareDrug.COL_MODIFIED_ON, now);
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        int rowCount = db.update(CareDrug.TABLE_NAME, values, CareDrug.COL_DRUG_ID + " =? ", new String[]{drug.getDrugId() + ""});
        SqliteManager.getInstance(context).closeDatabase();
        Log.i(TAG, "update() ...rowCount=" + rowCount);
        return rowCount;
    }

    public int delete(Context context, CareDrug drug) {
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        int rowCount = db.delete(CareDrug.TABLE_NAME, CareDrug.COL_DRUG_ID + " =? ", new String[]{drug.getDrugId() + ""});
        SqliteManager.getInstance(context).closeDatabase();
        Log.i(TAG, "delete() ...rowCount=" + rowCount);
        return rowCount;
    }
}
