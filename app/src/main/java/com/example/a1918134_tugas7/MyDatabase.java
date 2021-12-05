package com.example.a1918134_tugas7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_kampus";
    private static final String tb_komik = "tb_komik";
    private static final String tb_komik_id = "id";
    private static final String tb_komik_judul = "judul";
    private static final String tb_komik_author = "author";
    private static final String CREATE_TABLE_KOMIK = "CREATE TABLE " +
            tb_komik +"("
            + tb_komik_id + " INTEGER PRIMARY KEY ,"
            + tb_komik_judul + " TEXT ,"
            + tb_komik_author + " TEXT " + ")";    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KOMIK);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateKomik(Komik data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_komik_id, data.get_id());
        values.put(tb_komik_judul, data.get_judul());
        values.put(tb_komik_author, data.get_author());
        db.insert(tb_komik, null, values);
        db.close();
    }
    public List<Komik> ReadKomik() {
        List<Komik> listKomik = new ArrayList<Komik>();
        String selectQuery = "SELECT * FROM " + tb_komik;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Komik data = new Komik();
                data.set_id(cursor.getString(0));
                data.set_judul(cursor.getString(1));
                data.set_author(cursor.getString(2));
                listKomik.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listKomik;
    }
    public int UpdateKomik (Komik data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_komik_judul, data.get_judul());
        values.put(tb_komik_author, data.get_author());
        return db.update(tb_komik, values, tb_komik_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteKomik(Komik data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_komik,tb_komik_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
