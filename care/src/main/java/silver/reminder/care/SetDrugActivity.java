package silver.reminder.care;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import java.util.List;

import silver.reminder.R;
import silver.reminder.adapter.SetDrugAdapter;
import silver.reminder.care.dao.CareDrugDao;
import silver.reminder.care.model.CareDrug;

public class SetDrugActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "careLog: " + SetDrugActivity.class.getName();
    private ListView lvDrug;

    private SetDrugAdapter adapter;
    private List<CareDrug> drugs;
    private AlertDialog editor;
    private Button btnDelete;
    private View view;
    private Button btnUpdate;
    private EditText etItemValue;
    private CareDrugDao dao;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_setdd_drug);

        findViews();
        //將資料顯示在ListView中
        dao = new CareDrugDao();
        drugs = dao.query(this);
        adapter = new SetDrugAdapter(this, R.layout.care_listview_setdd, drugs);
        lvDrug.setAdapter(adapter);
        //class 已implement,故註冊Listener後,丟Contex就可,不必用匿名()
        lvDrug.setOnItemClickListener(this);
    }

    private void findViews() {
        lvDrug = (ListView) findViewById(R.id.lvDrug);
        view = getLayoutInflater().inflate(R.layout.activity_care_setdd_editor, null);
        btnDelete = (Button) view.findViewById(R.id.btnDelete);
        btnUpdate = (Button) view.findViewById(R.id.btnUpdate);
        etItemValue = (EditText) view.findViewById(R.id.etItemValue);
        editor = new AlertDialog.Builder(this, R.style.AppTheme_Care_DialogAlert)
            .setView(view)
            .create();
    }

    //ListView
    public void add(View view) {
        Log.d(TAG, "add() 開啟新增畫面");
        etItemValue.setText("");
        etItemValue.setHint(getString(R.string.inputItem));
        btnUpdate.setVisibility(View.GONE);
        btnDelete.setVisibility(View.INVISIBLE);
        editor.show();
        Log.d(TAG, "add() 資料筆數 " + drugs.size());
    }

    //AlertDialog
    public void doInsert(View view) {
        Log.d(TAG, "doInsert() 開啟新增畫面");
        CareDrug drug = new CareDrug();
        if (!validate()) return;
        drug.setDrugValue(etItemValue.getText().toString().trim());
        drug.setEnable("Y");
        //Log.d(TAG,"doInsert()1.."+drug.getDrugId());
        drug.setDrugId(dao.insert(this, drug));
        //Log.d(TAG,"doInsert()2.."+drug.getDrugId());
        drugs.add(drug);
        adapter.notifyDataSetChanged();
        editor.dismiss();
    }

    private boolean validate() {
        boolean pass = true;
        if (etItemValue.getText().toString().trim().length() <= 0) {
            etItemValue.setError(getString(R.string.inputNull));
            pass = false;
        }
        return pass;
    }

    public void doDelete(View view) {
        Log.d(TAG, "doDelete()..." + currentIndex);
        dao.delete(this, drugs.get(currentIndex));
        drugs.remove(currentIndex);
        adapter.notifyDataSetChanged();
        editor.dismiss();
    }

    public void doUpdate(View view) {
        Log.d(TAG, "doUpdate() 開啟編輯畫面");
        if (!validate()) return;
        CareDrug drug = drugs.get(currentIndex);
        drug.setDrugValue(etItemValue.getText().toString().trim());
        dao.update(this, drug);
        drugs.set(currentIndex, drug);
        adapter.notifyDataSetChanged();
        editor.dismiss();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        currentIndex = i;
        if (view.getId() == R.id.swEnable) {
            CareDrug drug = drugs.get(i);
            if (((Switch) view).isChecked()) {
                drug.setEnable("Y");
            } else {
                drug.setEnable("N");
            }
            Log.d(TAG, "onItemClick...i= " + i);
            dao.update(this, drug);
            drugs.set(i, drug);
            adapter.notifyDataSetChanged();
        } else {
            btnDelete.setVisibility(View.VISIBLE);
            btnUpdate.setVisibility(View.VISIBLE);
            etItemValue.setText(drugs.get(i).getDrugValue());
            //show之前ListView要註冊Listener
            editor.show();
        }
    }

}
