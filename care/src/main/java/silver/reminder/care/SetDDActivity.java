package silver.reminder.care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import silver.reminder.R;

public class SetDDActivity extends AppCompatActivity {

    private Button btnSetDrug;
    private Button btnSetMem;
    private Button btnSetTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_main_setdd);

        btnSetDrug = (Button) findViewById(R.id.btnSetDrug);
        btnSetDrug.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetDDActivity.this, SetDrugActivity.class);
                startActivity(intent);
            }
        });

        btnSetMem = (Button) findViewById(R.id.btnSetMem);
        btnSetMem.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetDDActivity.this, SetMemberActivity.class);
                startActivity(intent);
            }
        });

        btnSetTime = (Button) findViewById(R.id.btnSetTime);
        btnSetTime.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetDDActivity.this, SetTimeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goCare(View view) {
        startActivity(new Intent().setClass(this, CareActivity.class));
    }
}
