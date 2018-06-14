package com.example.josef.esportsfeedapp.bodeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public Spinner grauNumerador, grauDenominador;
    public int gDenomi = 0, gNume = 0;
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grauNumerador = (Spinner) findViewById(R.id.spinner);
        grauDenominador = (Spinner) findViewById(R.id.spinner2);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(this);

        grauDenominador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gDenomi = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        grauNumerador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gNume = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // gDenomi = grauDenominador.getSelectedItemPosition();
        // gNume = grauNumerador.getSelectedItemPosition();
        Log.d("TAG", "teste" + gDenomi);

        List<String> c = new ArrayList<String>();
        c.add("0");
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");
        c.add("6");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_text_layout, c);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        grauNumerador.setAdapter(dataAdapter);
        grauDenominador.setAdapter(dataAdapter);


    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putInt("grauDenominador", gDenomi);
        bundle.putInt("grauNumerador", gNume);
        Intent in = new Intent(this, InserirFt.class);
        in.putExtras(bundle);
        startActivity(in);
    }

}
