package com.example.budget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDadapter extends SQLiteOpenHelper {
    public BDadapter(Context context) {
        super(context, "formalab", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE depense (id integer Primary key,number text,name text)";
        db.execSQL(createtable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = "DROP Table  IF EXISTS depense ";
        db.execSQL(deleteTable);
        onCreate(db);

    }

    public void ajouter(Model M) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("achat", M.getAchat());
        contentValues.put("prix", M.getPrix());
        contentValues.put("date", M.getDate());
        db.insert("Model", null, contentValues);
    }

    public ArrayList<Model> afficher() {
        SQLiteDatabase db = getReadableDatabase();
        String selectall = "SELECT * from depense ";
        Cursor cursor = db.rawQuery(selectall, null);

        ArrayList<Model> dependes = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Model nouveau = new Model(cursor.getString(1), cursor.getFloat(2));
                nouveau.setId(cursor.getInt(0));
                nouveau.setDate(cursor.getString(3));
                dependes.add(nouveau);


            } while (cursor.moveToNext());
        }

        return (dependes);

    }

    public void remove(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("depense", "id=" + Integer.toString(id), null);
    }

    public Float total() {
        Float s = 0f;

        SQLiteDatabase db = getReadableDatabase();
        String selectall = "SELECT * FROM depense";
        Cursor cursor = db.rawQuery(selectall, null);
        ArrayList<Model> depenses = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                s += cursor.getFloat(2);
            }
            while (cursor.moveToNext());
        }
        return s ;


    }
}