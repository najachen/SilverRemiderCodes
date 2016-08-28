package silver.reminder.care.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import silver.reminder.care.model.CareTime;
import silver.reminder.manager.SqliteManager;

public class CareTimeDao {

    private static final String TAG = "careLog: " + CareTimeDao.class.getName();

    public CareTimeDao() {
    }

    public List<CareTime> query(Context context) {

        List<CareTime> times = new ArrayList<>();
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        String sql = "" +
            "SELECT " + CareTime.COL_TIME_ID_ +
            "     , " + CareTime.COL_TIME_TYPE +
            "     , " + CareTime.COL_TIME_CODE +
            "     , " + CareTime.COL_TIME_VALUE1 +
            "     , " + CareTime.COL_TIME_VALUE2 +
            "     , " + CareTime.COL_MODIFIED_ON +
            "  FROM " + CareTime.TABLE_NAME;

        Cursor cursor = db.rawQuery(sql, null);
        //
        while (cursor.moveToNext()) {
            CareTime tm = new CareTime();
            tm.setTimeId(cursor.getInt(cursor.getColumnIndex(CareTime.COL_TIME_ID_)));
            tm.setTimeType(cursor.getString(cursor.getColumnIndex(CareTime.COL_TIME_TYPE)));
            tm.setTimeCode(cursor.getString(cursor.getColumnIndex(CareTime.COL_TIME_CODE)));
            tm.setTimeValue1(cursor.getString(cursor.getColumnIndex(CareTime.COL_TIME_VALUE1)));
            tm.setTimeValue2(cursor.getString(cursor.getColumnIndex(CareTime.COL_TIME_VALUE2)));
            tm.setModifiedOn(cursor.getString(cursor.getColumnIndex(CareTime.COL_MODIFIED_ON)));
            times.add(tm);

        }
        cursor.close();
        SqliteManager.getInstance(context).closeDatabase();
        return times;
    }

    public int insert(Context context, CareTime tm) {
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ContentValues values = new ContentValues();
        values.put(CareTime.COL_TIME_CODE, tm.getTimeCode());
        values.put(CareTime.COL_TIME_TYPE, tm.getTimeType());
        values.put(CareTime.COL_TIME_VALUE1, tm.getTimeValue1());
        values.put(CareTime.COL_TIME_VALUE2, tm.getTimeValue2());
        values.put(CareTime.COL_MODIFIED_ON, now);
        int rowId = (int) db.insert(CareTime.TABLE_NAME, null, values);
        return rowId;

    }
}
