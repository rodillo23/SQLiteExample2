package com.example.joserodolfofigueroachavez.sqliteexample2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShowActivity extends AppCompatActivity {

    private ListView listView;
    private List<Car> list;
    private MyAdapter adapter;
    private Button btnDeleteAll;

    private SQLietHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        btnDeleteAll = (Button) findViewById(R.id.buttonDeleteAll);
        helper = new SQLietHelper(this, "DBTest", null, 1);
        db = helper.getReadableDatabase();

        list = new ArrayList<Car>();



        listView = (ListView) findViewById(R.id.listView);
        adapter = new MyAdapter(this, R.layout.item_db, list);
        listView.setAdapter(adapter);

        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAll();
                update();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        update();

    }

    private void deleteAll() {
        db.delete("Cars", "", null);
    }

    private void update() {
        list.clear();
        list.addAll(getAllCars());
        adapter.notifyDataSetChanged();
    }

    private List<Car> getAllCars() {
        Cursor cursor = db.rawQuery("select * from Cars", null);
        List<Car> cars = new ArrayList<Car>();
        if (cursor.moveToFirst()){
            while (cursor.isAfterLast() == false){
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String color = cursor.getString(cursor.getColumnIndex("color"));
                list.add(new Car(id, name, color));
                cursor.moveToNext();
            }
        }
        return cars;
    }
}
