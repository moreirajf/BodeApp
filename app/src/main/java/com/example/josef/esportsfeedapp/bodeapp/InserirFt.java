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

public class InserirFt extends AppCompatActivity implements View.OnClickListener {

    public int a,b;
    public LinearLayout denominadorLayout, numeradorLayout;
    public ArrayList<EditText> numeradores = new ArrayList<>();
    public ArrayList<EditText> denominadores = new ArrayList<>();
    public Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_ft);

        Intent in = getIntent();

        Bundle bundle = in.getExtras();


        a = bundle.getInt("grauDenominador");
        b = bundle.getInt("grauNumerador");

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
        for (int i = a; i > -1; i--){
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

    }
}
