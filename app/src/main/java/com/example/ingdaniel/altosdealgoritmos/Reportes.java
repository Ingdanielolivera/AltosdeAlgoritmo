package com.example.ingdaniel.altosdealgoritmos;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Reportes extends AppCompatActivity {
    private ListView opcionesReport;
    private  String []opc;
    private ArrayAdapter adapter;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        opcionesReport=(ListView)findViewById(R.id.lstopcionesR);
        opc = getResources().getStringArray(R.array.opcionesR);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        opcionesReport.setAdapter(adapter);
        opcionesReport.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        conSombrayBalcon();
                        break;
                    case 1:
                        mayorPrecio();
                        break;
                    case 2:
                        mayorTamanno();
                        break;
                    case 3:
                        promedioTamannoxPiso();
                        break;
                }
            }
        });

    }

    public void conSombrayBalcon(){
        String mcSombra, mcBalcon, mensaje = "";
        int cont=0;
        ArrayList<Apartamento> apto = Datos.conSombrayBalcon(getApplicationContext());
        for (int i=0; i<apto.size(); i++){
            mcSombra = apto.get(i).getSombra();
            mcBalcon = apto.get(i).getBalcon();
            if (mcBalcon.equalsIgnoreCase(getResources().getString(R.string.si)) && mcSombra.equalsIgnoreCase(getResources().getString(R.string.si)) ){
                cont+=1;
            }
        }
        mensaje = getResources().getString(R.string.sombraybalcon)+"\n"+getResources().getString(R.string.napartamentos)+cont;
        new AlertDialog.Builder(this).setMessage(mensaje).setCancelable(true).show();
    }


    public void mayorPrecio(){
        String  pisoapt="",precio="", mensaje="", nomen="", tama="";
        ArrayList<Apartamento> apto = Datos.mayorPrecio(getApplicationContext());
        for (int i=0; i<apto.size(); i++){
            pisoapt = apto.get(i).getPiso();
            tama = apto.get(i).getTamanno();
            precio = apto.get(i).getPrecio();
            nomen = apto.get(i).getNomen();
        }
        mensaje = getResources().getString(R.string.mayorpre)+"\n"+pisoapt+"\n"+getResources().getString(R.string.precio)+": $"+precio+
                "\n"+getResources().getString(R.string.nomenclatura)+": "+nomen+"\n"+getResources().getString(R.string.tamanno)+": "+tama+"mt2";
        new AlertDialog.Builder(this).setMessage(mensaje).setCancelable(true).show();
    }


    public void mayorTamanno(){
        String nomen="", pisoapt = "", tama="", mensaje = "";
        int cont=0;
        ArrayList<Apartamento> apto = Datos.mayortamanno(getApplicationContext());
        for (int i=0; i<apto.size(); i++){
            pisoapt = apto.get(i).getPiso();
            nomen = apto.get(i).getNomen();
            tama = apto.get(i).getTamanno();
        }
        mensaje = getResources().getString(R.string.mastamano)+"\n"+pisoapt+"\n"+getResources().getString(R.string.nomenclatura)+": "+nomen+"\n"
                +getResources().getString(R.string.tamanno)+": "+tama+"mt2";
        new AlertDialog.Builder(this).setMessage(mensaje).setCancelable(true).show();
    }


    public void promedioTamannoxPiso(){
        String mensaje,pisoapt1,pisoapt2,pisoapt3,pisoapt4,pisoapt5;
        int metros1=0,metros2=0, metros3=0,metros4=0,metros5=0;
        int promedio1=0,promedio2=0,promedio3=0,promedio4=0,promedio5=0;
        ArrayList<Apartamento> apto1=Datos.piso1(getApplicationContext());
        ArrayList<Apartamento> apto2=Datos.piso2(getApplicationContext());
        ArrayList<Apartamento> apto3=Datos.piso3(getApplicationContext());
        ArrayList<Apartamento> apto4=Datos.piso4(getApplicationContext());
        ArrayList<Apartamento> apto5=Datos.piso5(getApplicationContext());
        for (int i=0;i<apto1.size();i++) {
            pisoapt1 = apto1.get(i).getPiso();
            pisoapt2 = apto2.get(i).getPiso();
            pisoapt3 = apto3.get(i).getPiso();
            pisoapt4 = apto4.get(i).getPiso();
            pisoapt5 = apto5.get(i).getPiso();
            if (pisoapt1.equals(getResources().getString(R.string.piso1))) {
                metros1 = metros1 + Integer.parseInt(apto1.get(i).getTamanno());
                promedio1 = metros1 / apto1.size();
                if (pisoapt2.equals(getResources().getString(R.string.piso2))) {
                    metros2 = metros2 + Integer.parseInt(apto2.get(i).getTamanno());
                    promedio2 = metros2 / apto2.size();
                    if (pisoapt3.equals(getResources().getString(R.string.piso3))) {
                        metros3 = metros3 + Integer.parseInt(apto3.get(i).getTamanno());
                        promedio3 = metros3 / apto3.size();
                        if (pisoapt4.equals(getResources().getString(R.string.piso4))) {
                            metros4 = metros4 + Integer.parseInt(apto4.get(i).getTamanno());
                            promedio4 = metros4 / apto4.size();
                            if (pisoapt5.equals(getResources().getString(R.string.piso5))) {
                                metros5 = metros5 + Integer.parseInt(apto5.get(i).getTamanno());
                                promedio5 = metros5 / apto5.size();
                            }
                        }
                    }
                }
            }
        }
        mensaje=getResources().getString(R.string.promediototal)+"\n"+getResources().getString(R.string.promedio1)+": "+promedio1+"\n"
                +getResources().getString(R.string.promedio2)+": "+promedio2+"\n"+getResources().getString(R.string.promedio3)+": "+promedio3+"\n"
                +getResources().getString(R.string.promedio4)+": "+promedio4+"\n"+getResources().getString(R.string.promedio5)+": "+promedio5;
        new AlertDialog.Builder(this).setMessage(mensaje).setCancelable(true).show();
    }

}




