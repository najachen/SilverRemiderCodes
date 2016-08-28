package silver.reminder.care;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import silver.reminder.R;

public class SetMemberActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "careLog: " + SetMemberActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_setdd_member);


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public void add(View view) {
    }
}
