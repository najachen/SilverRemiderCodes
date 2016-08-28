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

import silver.reminder.care.model.CareMember;
import silver.reminder.manager.SqliteManager;


public class CareMemberDao {

    private static final String TAG = "careLog: " + CareMemberDao.class.getName();

    public CareMemberDao() {
    }

    public List<CareMember> query(Context context) {

        List<CareMember> members = new ArrayList<>();
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        String sql = "" +
            "SELECT " + CareMember.COL_MEMBER_ID +
            "     , " + CareMember.COL_MEMBER_VALUE +
            "     , " + CareMember.COL_ENABLE +
            "     , " + CareMember.COL_MODIFIED_ON +
            "  FROM " + CareMember.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            CareMember mem = new CareMember();
            mem.setMemberId(cursor.getInt(cursor.getColumnIndex(CareMember.COL_MEMBER_ID)));
            mem.setMemberValue(cursor.getString(cursor.getColumnIndex(CareMember.COL_MEMBER_VALUE)));
            mem.setEnable(cursor.getString(cursor.getColumnIndex(CareMember.COL_ENABLE)));
            mem.setModifiedOn(cursor.getString(cursor.getColumnIndex(CareMember.COL_MODIFIED_ON)));
            members.add(mem);
        }
        cursor.close();
        SqliteManager.getInstance(context).closeDatabase();

        Log.d(TAG, "query() 成員資料筆數= " + members.size());
        return members;
    }

    public int insert(Context context, CareMember mem) {
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ContentValues values = new ContentValues();
        values.put(CareMember.COL_MEMBER_VALUE, mem.getMemberValue());
        values.put(CareMember.COL_ENABLE, mem.getEnable());
        values.put(CareMember.COL_MODIFIED_ON, now);
        //回傳long,cast to
        int rowId = (int) db.insert(CareMember.TABLE_NAME, null, values);
        Log.d(TAG, "insert() 成員資料筆數= " + rowId);
        return rowId;
    }

    public int update(Context context, CareMember mem) {
        String now = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss").format(new Date());
        ContentValues values = new ContentValues();
        values.put(CareMember.COL_MEMBER_VALUE, mem.getMemberValue());
        values.put(CareMember.COL_ENABLE, mem.getEnable());
        values.put(CareMember.COL_MODIFIED_ON, now);
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        int rowCount = db.update(CareMember.TABLE_NAME, values, CareMember.COL_MEMBER_ID + " =? ", new String[]{mem.getMemberId() + ""});
        SqliteManager.getInstance(context).closeDatabase();
        return rowCount;
    }

    public int delete(Context context, CareMember mem) {
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        int rowCount = db.delete(CareMember.TABLE_NAME, CareMember.COL_MEMBER_ID + " =? ", new String[]{mem.getMemberId() + ""});
        SqliteManager.getInstance(context).closeDatabase();
        return rowCount;
    }
}
