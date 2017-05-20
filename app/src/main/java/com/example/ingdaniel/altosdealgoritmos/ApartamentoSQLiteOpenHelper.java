package com.example.ingdaniel.altosdealgoritmos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ING DANIEL on 20/05/2017.
 */

public class ApartamentoSQLiteOpenHelper extends SQLiteOpenHelper {
    private String sql = "CREATE TABLE Apartamentos(piso text, balcon text, sombra text, tamanno text, precio text, nomen text)";

    public ApartamentoSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Apartamentos");
        db.execSQL(sql);
    }
}
