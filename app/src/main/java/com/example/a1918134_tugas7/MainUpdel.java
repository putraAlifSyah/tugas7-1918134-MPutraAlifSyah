package com.example.a1918134_tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjudul, Sauthor;
    private EditText Ejudul, Eauthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjudul = i.getStringExtra("Ijudul");
        Sauthor = i.getStringExtra("Iauthor");
        Ejudul = (EditText) findViewById(R.id.updel_judul);
        Eauthor = (EditText) findViewById(R.id.updel_author);
        Ejudul.setText(Sjudul);
        Eauthor.setText(Sauthor);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sauthor = String.valueOf(Eauthor.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi judul",
                            Toast.LENGTH_SHORT).show();
                } else if (Sauthor.equals("")){
                    Eauthor.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi author",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateKomik(new Komik(Sid, Sjudul,
                            Sauthor));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteKomik(new Komik(Sid, Sjudul,
                        Sauthor));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}