package com.severalities.rapinspi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "words.db";
    public static final String TABLE_NAME = "us";
    public static final String TABLE2_NAME = "fr";
    public static final String TABLE3_NAME = "dz";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,WORD TEXT)");
        db.execSQL("create table " + TABLE2_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,WORD TEXT)");
        db.execSQL("create table " + TABLE3_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,WORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE3_NAME);
        onCreate(db);
    }

    public void insertData(String word){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("WORD",word);
        db.insert(TABLE3_NAME,null ,contentValues);
        db.close();}

    public String getData(Integer ID, String table){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select WORD from "+table+" where ID="+ID,null);
        //
        return res.getString(-1);
        //

    }
}
