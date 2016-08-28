package silver.reminder.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import silver.reminder.R;
import silver.reminder.care.model.CareMember;

public class SetMemberAdapter extends BaseAdapter {

    private static final String TAG = "careLog: " + SetMemberAdapter.class.getName();

    private LayoutInflater layoutInflater;
    private List<CareMember> data = new ArrayList<CareMember>();
    private int resId;

    public SetMemberAdapter(Context c, int resId, List<CareMember> data) {
        this.layoutInflater = LayoutInflater.from(c);
        this.data = data;
        this.resId = resId;
    }

    //一定要指定size()
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        View v = layoutInflater.inflate(resId, null);
        CareMember member = data.get(i);
        TextView tvValue = (TextView) v.findViewById(R.id.tvValue);
        Switch swEnable = (Switch) v.findViewById(R.id.swEnable);
        tvValue.setText(member.getMemberValue());
        if (member.getEnable().equals("N")) {
            tvValue.setTextColor(tvValue.getResources().getColor(R.color.disable_38));
            swEnable.setChecked(false);
        } else {
            swEnable.setChecked(true);
        }
        swEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG, "Switch");
                ((ListView) viewGroup).performItemClick(compoundButton, i, 0);

            }
        });
        return v;
    }
}
