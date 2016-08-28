package silver.reminder.care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import silver.reminder.R;

public class LogDDActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_main_logdd);
    }

    public void goCare(View view) {
        startActivity(new Intent().setClass(this, CareActivity.class));
    }

    public void doFind(View view) {
        new AlertDialog.Builder(this, R.style.AppTheme_Care_DialogAlert)
            .setMessage("依成員\n依時間")
            .setPositiveButton("確定", null)
            .setNeutralButton("取消", null)
            .show();
    }


}
