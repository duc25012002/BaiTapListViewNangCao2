package com.hdcompany.android02b1.listviewnangcaobai2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hdcompany.android02b1.listviewnangcaobai2.MainActivity;
import com.hdcompany.android02b1.listviewnangcaobai2.R;
import com.hdcompany.android02b1.listviewnangcaobai2.model.Flag;

import java.util.ArrayList;
import java.util.List;

public class FlagsAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Flag> listFlags;

    public FlagsAdapter(MainActivity mainActivity, int item_flag, ArrayList<Flag> arrFlag) {
    }


    public FlagsAdapter() {
    }


    public FlagsAdapter(Context context, int layout, List<Flag> listFlags) {
        this.context = context;
        this.layout = layout;
        this.listFlags = listFlags;
    }

    @Override
    public int getCount() {
        return listFlags.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);


        TextView txt_name = (TextView) convertView.findViewById(R.id.txt_name);
        TextView txt_money = (TextView) convertView.findViewById(R.id.txt_money);
        ImageView img_flag = (ImageView) convertView.findViewById(R.id.img_flag);

        Flag flag = listFlags.get(position);
        txt_name.setText(flag.getFlag_name());
        txt_money.setText(flag.getMoney());
        img_flag.setImageResource(flag.getImage());


        return convertView;
    }
}
