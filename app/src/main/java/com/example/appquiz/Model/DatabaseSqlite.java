package com.example.appquiz.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseSqlite extends SQLiteOpenHelper {
    public DatabaseSqlite(@Nullable Context context, @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void setDatabase(String query){
        SQLiteDatabase data = getWritableDatabase();
        data.execSQL(query);
    }

    public Cursor getDatabase(String query){
        SQLiteDatabase data = getReadableDatabase();
        return data.rawQuery(query,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
