package com.example.ingdaniel.altosdealgoritmos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by ING DANIEL on 20/05/2017.
 */

public class Datos {


    public static ArrayList<Apartamento> traerApartamentos(Context contexto) {
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

    public static ArrayList<Apartamento> conSombrayBalcon(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();
        //cursor

        sql = "SELECT * FROM Apartamentos WHERE balcon = 'Si' AND sombra ='Si'";
        Cursor c = db.rawQuery(sql, null);


        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
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
        db.close();

        return apartamentos;
    }

    public static ArrayList<Apartamento> mayorPrecio(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();

        sql = "SELECT * FROM Apartamentos ORDER BY precio DESC LIMIT 1";
        Cursor c = db.rawQuery(sql, null);

        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
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
        db.close();

        return apartamentos;
    }


    public static ArrayList<Apartamento> mayortamanno(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();
        //cursor

        sql = "SELECT * FROM Apartamentos ORDER BY tamanno DESC LIMIT 1";
        Cursor c = db.rawQuery(sql, null);


        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
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
        db.close();

        return apartamentos;
    }

//Filtro por piso
    public static ArrayList<Apartamento> piso1(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();
        //cursor

        sql = "SELECT * FROM Apartamentos WHERE piso = 'Piso 1'";
        Cursor c = db.rawQuery(sql, null);


        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
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
        db.close();

        return apartamentos;
    }
    public static ArrayList<Apartamento> piso2(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();
        //cursor

        sql = "SELECT * FROM Apartamentos WHERE piso = 'Piso 2'";
        Cursor c = db.rawQuery(sql, null);


        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
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
        db.close();

        return apartamentos;
    }
    public static ArrayList<Apartamento> piso3(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();
        //cursor

        sql = "SELECT * FROM Apartamentos WHERE piso = 'Piso 3'";
        Cursor c = db.rawQuery(sql, null);


        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
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
        db.close();

        return apartamentos;
    }
    public static ArrayList<Apartamento> piso4(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();
        //cursor

        sql = "SELECT * FROM Apartamentos WHERE piso = 'Piso 4'";
        Cursor c = db.rawQuery(sql, null);


        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
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
        db.close();

        return apartamentos;
    }
    public static ArrayList<Apartamento> piso5(Context contexto) {
        ArrayList<Apartamento> apartamentos= new ArrayList<>();

        //Declarar Variables
        SQLiteDatabase db;
        String sql, piso, balcon, sombra, tamanno, precio, nomen;
        Apartamento a;
        //Abrir conexción
        ApartamentoSQLiteOpenHelper aux = new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getReadableDatabase();
        //cursor

        sql = "SELECT * FROM Apartamentos WHERE piso = 'Piso 5'";
        Cursor c = db.rawQuery(sql, null);


        //recorremos el cursor
        if (c.moveToFirst()) {
            do {
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
        db.close();

        return apartamentos;
    }
}
