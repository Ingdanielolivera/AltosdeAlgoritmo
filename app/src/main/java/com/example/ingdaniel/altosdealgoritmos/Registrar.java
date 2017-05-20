package com.example.ingdaniel.altosdealgoritmos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Registrar extends AppCompatActivity {
    private Spinner opcionesPiso;
    private String[] opc;
    private ArrayAdapter adapter;
    private RadioButton rdBalconsi;
    private RadioButton rdBalconno;
    private RadioButton rdSombrasi;
    private RadioButton rdSombrano;
    private EditText cajaTamanno;
    private EditText cajaPrecio;
    private EditText cajaNomen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        opcionesPiso =(Spinner)findViewById(R.id.oppiso);
        opc = getResources().getStringArray(R.array.pisos);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        opcionesPiso.setAdapter(adapter);
        rdBalconsi=(RadioButton)findViewById(R.id.rdbbalconsi);
        rdBalconno=(RadioButton)findViewById(R.id.rdbalconno);
        rdSombrasi=(RadioButton)findViewById(R.id.rdbSombrasi);
        rdSombrano=(RadioButton)findViewById(R.id.rdbSombrano);
        cajaTamanno=(EditText)findViewById(R.id.txttamanno);
        cajaPrecio=(EditText)findViewById(R.id.txtPrecio);
        cajaNomen=(EditText)findViewById(R.id.txtnomenclatura);

    }


    public void guardar(View v) {

        String piso, balcon, sombra, tamanno, precio, nomenclatura;
        Apartamento a;

        if (validar()) {
            //Piso
            piso = opcionesPiso.getSelectedItem().toString();
            //validar que no se agregen mas de 3 apartamento por piso

            //balcon
            //Verifico si tiene balcon o no
            if (rdBalconsi.isChecked()) balcon = getResources().getString(R.string.si);
            else balcon = getResources().getString(R.string.no);

            //Sombra
            //Verifico si tiene sombra o no
            if (rdSombrasi.isChecked()) sombra = getResources().getString(R.string.si);
            else sombra = getResources().getString(R.string.no);

            //EditText
            tamanno = cajaTamanno.getText().toString();
            precio = cajaPrecio.getText().toString();
            nomenclatura = cajaNomen.getText().toString();


            a = new Apartamento(piso, balcon, sombra, tamanno, precio, nomenclatura);
            a.guardar(getApplicationContext());

            new AlertDialog.Builder(this).setMessage("Apartamento Guardado Exitosamente!").setCancelable(true).show();
            limpiar();
        }
    }


    public void limpiar(){
        rdBalconsi.setChecked(true);
        rdBalconno.setChecked(false);
        rdSombrasi.setChecked(true);
        rdSombrano.setChecked(false);
        cajaTamanno.setText("");
        cajaPrecio.setText("");
        cajaNomen.setText("");
        cajaTamanno.requestFocus();
    }


    public boolean validar(){
        if (cajaTamanno.getText().toString().isEmpty()) {
            cajaTamanno.setError(getResources().getString(R.string.errortamanno));
            cajaTamanno.requestFocus();
            return false;
        }if (cajaPrecio.getText().toString().isEmpty()){
            cajaPrecio.setError(getResources().getString(R.string.errorprecio));
            cajaPrecio.requestFocus();
            return false;
        }if (cajaNomen.getText().toString().isEmpty()) {
            cajaNomen.setError(getResources().getString(R.string.errornomen));
            cajaNomen.requestFocus();
            return false;
        }
        return true;
    }


    public boolean validarpiso(){


        return true;
    }





}
