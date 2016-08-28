package silver.reminder.care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import silver.reminder.R;

public class SetTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_setdd_time);
    }

    public void goSetDD(View view) {
        startActivity(new Intent().setClass(this, SetDDActivity.class));
    }
}
