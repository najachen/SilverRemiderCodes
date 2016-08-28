package silver.reminder.care.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import silver.reminder.care.model.CareTask;
import silver.reminder.manager.SqliteManager;

public class CareTaskDao {

    private static final String TAG = "careLog: " + CareTaskDao.class.getName();

    public CareTaskDao() {
    }

    public List<CareTask> query(Context context) {

        List<CareTask> tasks = new ArrayList<>();
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        String sql = "" +
            "SELECT " + CareTask.COL_CARE_ID +
            "     , " + CareTask.COL_CARE_SEQ +
            "     , " + CareTask.COL_CARE_DESC +
            "     , " + CareTask.COL_REMIND_DATETIME +
            "     , " + CareTask.COL_REMIND_TIMES +
            "     , " + CareTask.COL_CONFIRM +
            "     , " + CareTask.COL_CONFIRM_DATETIME +
            "     , " + CareTask.COL_MODIFIED_ON +
            "  FROM " + CareTask.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            CareTask task = new CareTask();
            task.setCareId(cursor.getInt(cursor.getColumnIndex(CareTask.COL_CARE_ID)));
            task.setCareSeq(cursor.getInt(cursor.getColumnIndex(CareTask.COL_CARE_SEQ)));
            task.setCareDesc(cursor.getString(cursor.getColumnIndex(CareTask.COL_CARE_DESC)));
            task.setRemindDateTime(cursor.getString(cursor.getColumnIndex(CareTask.COL_REMIND_DATETIME)));
            task.setRemindTimes(cursor.getString(cursor.getColumnIndex(CareTask.COL_REMIND_TIMES)));
            task.setConfirm(cursor.getString(cursor.getColumnIndex(CareTask.COL_CONFIRM)));
            task.setConfirmDateTime(cursor.getString(cursor.getColumnIndex(CareTask.COL_CONFIRM_DATETIME)));
            task.setModifiedOn(cursor.getString(cursor.getColumnIndex(CareTask.COL_MODIFIED_ON)));
            tasks.add(task);
        }
        cursor.close();
        SqliteManager.getInstance(context).closeDatabase();
        return tasks;
    }

    public int insert(Context context, CareTask task) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ContentValues values = new ContentValues();
        values.put(CareTask.COL_CARE_ID, task.getCareId());
        values.put(CareTask.COL_CARE_SEQ, task.getCareSeq());
        values.put(CareTask.COL_CARE_DESC, task.getCareDesc());
        values.put(CareTask.COL_REMIND_DATETIME, task.getRemindDateTime());
        values.put(CareTask.COL_REMIND_TIMES, 0);
        values.put(CareTask.COL_CONFIRM, "N");
        values.put(CareTask.COL_MODIFIED_ON, now);
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        int rowId = (int) db.insert(CareTask.TABLE_NAME, null, values);
        SqliteManager.getInstance(context).closeDatabase();
        return rowId;
    }

    public int update(Context context, CareTask task) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ContentValues values = new ContentValues();
        values.put(CareTask.COL_CARE_DESC, task.getCareDesc());
        values.put(CareTask.COL_REMIND_DATETIME, task.getRemindDateTime());
        values.put(CareTask.COL_REMIND_TIMES, task.getRemindTimes());
        values.put(CareTask.COL_CONFIRM, task.getConfirm());
        values.put(CareTask.COL_MODIFIED_ON, now);
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        int rowCount = (int) db.update(CareTask.TABLE_NAME, values,
            CareTask.COL_CARE_ID + "=? AND " + CareTask.COL_CARE_SEQ + " =? ",
            new String[]{task.getCareId() + "", task.getCareSeq() + ""}
        );
        SqliteManager.getInstance(context).closeDatabase();
        return rowCount;
    }

    public int delete(Context context, CareTask task) {
        SQLiteDatabase db = SqliteManager.getInstance(context).openDatabase();
        int rowCount = (int) db.delete(
            CareTask.TABLE_NAME,
            CareTask.COL_CARE_ID + "=? AND " + CareTask.COL_CARE_SEQ + "=? ",
            new String[]{task.getCareId() + "", task.getCareSeq() + ""}
        );
        SqliteManager.getInstance(context).closeDatabase();
        return rowCount;
    }
}
