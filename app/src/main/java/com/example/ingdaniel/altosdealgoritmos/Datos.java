package com.example.ingdaniel.altosdealgoritmos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by ING DANIEL on 20/05/2017.
 */

public class Datos {


    public static ArrayList<Apartamento> traerPersonas(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Apartamentos";
        Cursor c =db.rawQuery(sql,null);

        //Recorido del cursor
        if(c.moveToFirst()){
            do{
                piso = c.getString(0);
                balcon=c.getString(1);
                sombra=c.getString(2);
                tamanno=c.getString(3);
                precio=c.getString(4);
                nomen=c.getString(5);
                a = new Apartamento (piso, balcon, sombra, tamanno, precio, nomen);
                apartamentos.add(a);
            } while (c.moveToNext());
        }
        //Cierro la base de datos y retorno personas
        db.close();
        return apartamentos;
    }


    public ArrayList<Apartamento> csombrabalcon(Context contexto){
        ArrayList<Apartamento> apartamentos =new ArrayList<>();
        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Apartamentos WHERE balcon = 'si' AND sombra='si'";
        Cursor c =db.rawQuery(sql,null);

        //Recorido del cursor
        if(c.moveToFirst()){
            do{
                piso = c.getString(0);
                balcon=c.getString(1);
                sombra=c.getString(2);
                tamanno=c.getString(3);
                precio=c.getString(4);
                nomen=c.getString(5);
                a = new Apartamento (piso, balcon, sombra, tamanno, precio, nomen);
                apartamentos.add(a);
            } while (c.moveToNext());
        }
        //Cierro la base de datos y retorno personas
        db.close();
        return apartamentos;

    }

}
