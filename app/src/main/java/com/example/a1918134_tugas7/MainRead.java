package com.example.a1918134_tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Komik> ListKomik = new
            ArrayList<Komik>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListKomik);
        mListView = (ListView) findViewById(R.id.list_komik);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListKomik.clear();
        List<Komik> Komik = db.ReadKomik();
        for (Komik komik : Komik) {
            Komik daftar = new Komik();
            daftar.set_id(komik.get_id());
            daftar.set_judul(komik.get_judul());
            daftar.set_author(komik.get_author());
            ListKomik.add(daftar);
            if ((ListKomik.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Komik detailKomik = (Komik)o;
        String Sid = detailKomik.get_id();
        String Sjudul = detailKomik.get_judul();
        String Sauthor = detailKomik.get_author();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijudul", Sjudul);
        goUpdel.putExtra("Iauthor", Sauthor);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListKomik.clear();
        mListView.setAdapter(adapter_off);
        List<Komik> Komik = db.ReadKomik();
        for (Komik komik : Komik) {
            Komik daftar = new Komik();
            daftar.set_id(komik.get_id());
            daftar.set_judul(komik.get_judul());
            daftar.set_author(komik.get_author());
            ListKomik.add(daftar);
            if ((ListKomik.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}