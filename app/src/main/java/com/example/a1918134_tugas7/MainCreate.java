package com.example.a1918134_tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ejudul, Eauthor;
    private String Sjudul, Sauthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        db = new MyDatabase(this);
        Ejudul = (EditText) findViewById(R.id.create_judul);
        Eauthor = (EditText) findViewById(R.id.create_author);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sauthor = String.valueOf(Eauthor.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi judul",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sauthor.equals("")) {
                    Eauthor.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi author",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Ejudul.setText("");
                    Eauthor.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateKomik(new Komik(null, Sjudul,
                            Sauthor));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}