package com.example.ingdaniel.altosdealgoritmos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarApartamentos extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Apartamento> apartamentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_apartamentos);

        tabla=(TableLayout)findViewById(R.id.tblPersonas);
        apartamentos = Datos.traerPersonas(getApplicationContext());

        for (int i = 0;i <apartamentos.size(); i++){
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);
            TextView c7 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(apartamentos.get(i).getPiso()+"  ");
            c3.setText(apartamentos.get(i).getBalcon()+"  ");
            c4.setText(apartamentos.get(i).getSombra()+"  ");
            c5.setText(apartamentos.get(i).getTamanno()+"  ");
            c6.setText(apartamentos.get(i).getPrecio()+"  ");
            c7.setText(apartamentos.get(i).getNomen()+"  ");

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);
            fila.addView(c7);

            tabla.addView(fila);
        }
    }
}
