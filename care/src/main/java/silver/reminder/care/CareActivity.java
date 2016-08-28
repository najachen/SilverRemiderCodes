package silver.reminder.care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import silver.reminder.R;

public class CareActivity extends AppCompatActivity {

    private Button btnMyDD;
    private Button btnAddDD;
    private Button btnLogDD;
    private Button btnSetDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_main);
        createView();
        createController();
    }

    //連結畫面上的物件
    private void createView() {
        btnMyDD = (Button) findViewById(R.id.btnMyDD);
        btnAddDD = (Button) findViewById(R.id.btnAddDD);
        btnLogDD = (Button) findViewById(R.id.btnLogDD);
        btnSetDD = (Button) findViewById(R.id.btnSetDD);

    }

    //畫面上物件的動作
    private void createController() {
        //進入我的提醒
        btnMyDD.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CareActivity.this, MyDDActivity.class);
                startActivity(intent);
            }
        });
        //進入新增提醒
        btnAddDD.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CareActivity.this, AddDDActivity.class);
                startActivity(intent);
            }
        });
        //進入歷史提醒
        btnLogDD.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CareActivity.this, LogDDActivity.class);
                startActivity(intent);
            }
        });
        //進入設定管理
        btnSetDD.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CareActivity.this, SetDDActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goCare(View view) {
        startActivity(new Intent().setClass(this, CareActivity.class));
    }
}
