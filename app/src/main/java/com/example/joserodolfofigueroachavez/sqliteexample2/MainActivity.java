package com.example.joserodolfofigueroachavez.sqliteexample2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText insertName;
    private EditText insertColor;
    private Button save;
    private Button showData;

    private SQLietHelper carsHelper;
    private SQLiteDatabase db;

    private String name;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertName = (EditText) findViewById(R.id.editTextName);
        insertColor = (EditText) findViewById(R.id.editTextColor);
        save = (Button) findViewById(R.id.buttonSave);
        showData = (Button) findViewById(R.id.buttonShow);

        carsHelper = new SQLietHelper(this, "DBTest", null, 1);
        db = carsHelper.getWritableDatabase();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create();
                insertName.setText("");
                insertColor.setText("");
            }
        });

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
            }
        });

    }

    private void create(){
        name = insertName.getText().toString();
        color = insertColor.getText().toString();

        if (db != null){
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("name", name);
            nuevoRegistro.put("color", color);
            db.insert("Cars", null, nuevoRegistro);
        }
    }
}
