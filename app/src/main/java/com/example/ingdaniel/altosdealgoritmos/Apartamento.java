package com.example.ingdaniel.altosdealgoritmos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ING DANIEL on 20/05/2017.
 */

public class Apartamento {
    private String piso;
    private String balcon;
    private String sombra;
    private String tamanno;
    private String precio;
    private String nomen;

    public Apartamento(String piso, String balcon, String sombra, String tamanno, String precio, String nomen) {
        this.piso = piso;
        this.balcon = balcon;
        this.sombra = sombra;
        this.tamanno = tamanno;
        this.precio = precio;
        this.nomen = nomen;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getBalcon() {
        return balcon;
    }

    public void setBalcon(String balcon) {
        this.balcon = balcon;
    }

    public String getSombra() {
        return sombra;
    }

    public void setSombra(String sombra) {
        this.sombra = sombra;
    }

    public String getTamanno() {
        return tamanno;
    }

    public void setTamanno(String tamanno) {
        this.tamanno = tamanno;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNomen() {
        return nomen;
    }

    public void setNomen(String nomen) {
        this.nomen = nomen;
    }


    public void guardar (Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexión de base de datos en modo escritura
        ApartamentoSQLiteOpenHelper aux =new ApartamentoSQLiteOpenHelper(contexto,"DBApartamentos",null,1);
        db = aux.getWritableDatabase();

      /*  //insertar forma 1
        sql ="INSERT INTO Personas Values('"+this.getFoto()+"','"+this.getCedula()+"','"+this.getNombre()+"','"+this.getApellido()+"','"+this.getSexo()+"','"+this.getPasatiempo()+"')";
        db.execSQL(sql);*/

        //insertar forma 2
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("piso",this.getPiso());
        nuevoRegistro.put("balcon",this.getBalcon());
        nuevoRegistro.put("sombra",this.getSombra());
        nuevoRegistro.put("tamanno",this.getTamanno());
        nuevoRegistro.put("precio",this.getPrecio());
        nuevoRegistro.put("nomen",this.getNomen());
        //Inserto en la base de datos
        db.insert("Apartamentos",null, nuevoRegistro);
        //cierro la conexión
        db.close();
    }




}
