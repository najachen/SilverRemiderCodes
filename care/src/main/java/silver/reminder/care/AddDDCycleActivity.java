package silver.reminder.care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import silver.reminder.R;

public class AddDDCycleActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_add_cycle);

    }

    public void doDate(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doNDay(View view) {
        Intent intent = new Intent().setClass(this, AddDDNHourActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doPerNDay(View view) {
        Intent intent = new Intent().setClass(this, AddDDNHourActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

}
