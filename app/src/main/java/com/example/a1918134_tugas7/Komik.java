package com.example.a1918134_tugas7;

public class Komik {
    private String _id, _judul, _author;
    public Komik (String id, String judul, String author) {
        this._id = id;
        this._judul = judul;
        this._author = _author;
    }
    public Komik() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_judul() {
        return _judul;
    }
    public void set_judul(String _judul) {
        this._judul = _judul;
    }
    public String get_author() {
        return _author;
    }
    public void set_author(String _author) {
        this._author = _author;
    }
}
