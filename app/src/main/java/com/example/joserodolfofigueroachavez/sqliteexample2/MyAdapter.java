package com.example.joserodolfofigueroachavez.sqliteexample2;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter /*implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener*/{

    private Context context;
    private int layout;
    private List<Car> list;

    public MyAdapter(Context context, int layout, List<Car> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.id = (TextView) convertView.findViewById(R.id.textViewId);
            vh.name = (TextView) convertView.findViewById(R.id.textViewName);
            vh.color = (TextView) convertView.findViewById(R.id.textViewColor);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        Car currentCar = list.get(position);

        vh.id.setText(currentCar.getId() + "");
        vh.name.setText(currentCar.getName());
        vh.color.setText(currentCar.getColor());

        return convertView;
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        Car currentCar =
//    }
//
//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        return false;
//    }

    public class ViewHolder{
        TextView id;
        TextView name;
        TextView color;
    }
}
