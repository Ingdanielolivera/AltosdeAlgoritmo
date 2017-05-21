package com.example.ingdaniel.altosdealgoritmos;

import android.content.Intent;
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
        String nomen="", tama="", pisoapt = "",precio="", mensaje = "";
        ArrayList<Apartamento> apto = Datos.mayorPrecio(getApplicationContext());
        for (int i=0; i<apto.size(); i++){
            pisoapt = apto.get(i).getPiso();
            tama=apto.get(i).getTamanno();
            precio=apto.get(i).getPrecio();
            nomen = apto.get(i).getNomen();
        }
        mensaje = getResources().getString(R.string.mastamano)+"\n"+pisoapt+"\n"+getResources().getString(R.string.precio)+": $"+precio+"\n"+getResources().getString(R.string.nomenclatura)+": "+nomen+"\n"+getResources().getString(R.string.tamanno)+": "+tama+"mt2";
        new AlertDialog.Builder(this).setMessage(mensaje).setCancelable(true).show();
    }

    public void mayorTamanno(){
        String nomen="", pisoapt = "", tama="", mensaje = "";
        int cont=0;
        ArrayList<Apartamento> apto = Datos.mayortamanno(getApplicationContext());
        for (int i=0; i<apto.size(); i++){
            pisoapt = apto.get(i).getPiso();
            nomen = apto.get(i).getNomen();
            tama=apto.get(i).getTamanno();
        }
        mensaje = getResources().getString(R.string.mastamano)+"\n"+pisoapt+"\n"+getResources().getString(R.string.nomenclatura)+": "+nomen+"\n"+getResources().getString(R.string.tamanno)+": "+tama+"mt2";
        new AlertDialog.Builder(this).setMessage(mensaje).setCancelable(true).show();
    }

    



    }




