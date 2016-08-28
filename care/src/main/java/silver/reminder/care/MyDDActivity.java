package silver.reminder.care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import silver.reminder.R;

public class MyDDActivity extends AppCompatActivity {

    private Button btnCare;
    private Button btnAdd;
    private ListView lvDD;
    private String[] dd = new String[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_main_mydd);
        createTestData();
        createView();
        createController();
    }

    private void createController() {
        btnCare.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyDDActivity.this, CareActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyDDActivity.this, AddDDActivity.class);
                startActivity(intent);
            }
        });


    }

    private void createView() {
        btnCare = (Button) findViewById(R.id.btnCare);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lvDD = (ListView) findViewById(R.id.lvDD);

        ArrayAdapter<String> a = new ArrayAdapter<String>(MyDDActivity.this,
            android.R.layout.simple_list_item_1, dd
        );
        lvDD.setAdapter(a);

    }

    private void createTestData() {
        dd[0] = "8月6日,早上07:00,喝水一杯";
        dd[1] = "8月7日,早上07:00,眼藥水一滴";
        dd[2] = "8月7日,中午12:00,眼藥水一滴";
        dd[3] = "8月7日,下午06:00,眼藥水一滴";
        dd[4] = "8月7日,晚上09:00,熱敷";
        dd[5] = "8月8日,早上08:00,降膽固醇藥2顆";
        dd[6] = "8月8日,晚上07:00,降膽固醇藥2顆";
        dd[7] = "8月9日,晚上07:00,葡萄糖胺20ml";
    }


    public void find(View view) {
        new AlertDialog.Builder(this, R.style.AppTheme_Care_DialogAlert)
            .setMessage("依成員\n依時間")
            .setPositiveButton("確定", null)
            .setNeutralButton("取消", null)
            .show();
    }
}
