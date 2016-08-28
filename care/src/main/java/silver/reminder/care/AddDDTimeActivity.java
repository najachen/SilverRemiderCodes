package silver.reminder.care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import silver.reminder.R;

public class AddDDTimeActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_add_time);
    }

    //選擇時段(早中午晚)
    public void doMorning(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doNoon(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doAfternoon(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doNight(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doPerNHour(View view) {
        Intent intent = new Intent().setClass(this, AddDDNHourActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
}
