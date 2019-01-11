package com.example.joserodolfofigueroachavez.sqliteexample2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLietHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Cars (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT, color TEXT)";

    public SQLietHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Cars");
        db.execSQL(sqlCreate);
    }
}
