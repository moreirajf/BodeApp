package com.example.josef.esportsfeedapp.bodeapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class InserirFt extends AppCompatActivity implements View.OnClickListener {

    public int a,b;
    public LinearLayout denominadorLayout, numeradorLayout;
    public ArrayList<EditText> numeradores = new ArrayList<>();
    public ArrayList<EditText> denominadores = new ArrayList<>();
    public Button btn3;
    public double[] vetNumerador, vetDenominador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_ft);

        Intent in = getIntent();

        Bundle bundle = in.getExtras();


        b = bundle.getInt("grauDenominador");
        a = bundle.getInt("grauNumerador");

        vetNumerador = new double[a+1];
        vetDenominador = new double[b+1];

        denominadorLayout = (LinearLayout) findViewById(R.id.denominadorLayout);
        numeradorLayout = (LinearLayout) findViewById(R.id.numeradorLayout);
        btn3 = (Button) findViewById(R.id.button3);

        btn3.setOnClickListener(this);


        for (int i = a; i > -1; i--){

            EditText aux = new EditText(this);
            aux.setTextSize(30);
            aux.setEms(2);
            aux.setMaxLines(1);
            aux.setBackgroundColor(Color.WHITE);
            numeradores.add(aux);
            numeradorLayout.addView(aux);

            TextView aux2 = new TextView(this);
            aux2.setText(" s^" + i + " ");
            aux2.setTextSize(24);
            numeradorLayout.addView(aux2);

        }
        for (int i = b; i > -1; i--){
            EditText aux = new EditText(this);
            aux.setTextSize(30);
            aux.setEms(2);
            aux.setMaxLines(1);
            aux.setBackgroundColor(Color.WHITE);
            denominadores.add(aux);
            denominadorLayout.addView(aux);

            TextView aux2 = new TextView(this);
            aux2.setText(" s^" + i + " ");
            aux2.setTextSize(24);
            denominadorLayout.addView(aux2);
        }



    }

    @Override
    public void onClick(View v) {
        int aux = a;
        if (v == btn3){
            for (int i = 0; i < a+1; i++){
                String test = numeradores.get(i).getText().toString();
                vetNumerador[aux] = Double.parseDouble(test);
                Log.d("teste 1", ""+ vetNumerador[aux]);
                aux--;

            }
            int aux2 = b;
            for (int i = 0; i < b+1 ; i++){
                String test1 = denominadores.get(i).getText().toString();
                vetDenominador[aux2] = Double.parseDouble(test1);
                //Log.d("teste 2", "" + vetDenominador[aux]);
                aux2--;
            }

            Principal x =  new Principal(vetNumerador,vetDenominador,a,b);


            Intent in = new Intent(this,GerarGrafico.class);
            startActivity(in);

        }
    }
}
