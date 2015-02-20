package com.example.namtarn.calapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String name = "calculate.sqlite3";
    private static final int version = 2;


    public DBHelper(Context ctx) {
        super(ctx, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE calculate (" +
                "_id integer primary key autoincrement," +
                "name text not null," +             // name
                "age int default 0," +           // age
                "height text not null," +
                "weight text not null," +           // letter grade e.g. A, B+
                "gender real default 0.0," +
                "todo double default 0,), +;";         // grade value e.g. 4, 3.5
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS course;";
        db.execSQL(sql);
        this.onCreate(db);
    }
}
