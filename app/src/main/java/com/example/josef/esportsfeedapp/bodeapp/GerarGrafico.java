package com.example.josef.esportsfeedapp.bodeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.example.josef.esportsfeedapp.bodeapp.Single.getSingle;
import static com.example.josef.esportsfeedapp.bodeapp.Single.single;

public class GerarGrafico extends AppCompatActivity {

    GraphView graph;
    GraphView graphFase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_grafico);

        graph = (GraphView) findViewById(R.id.graph_modulo);
        graph.setTitle("Modulo");

        graphFase = (GraphView) findViewById(R.id.graph_phase);
        graphFase.setTitle("Fase");


        DataPoint[] dados = new DataPoint[single.getSingle().getValores().size()];
        for(int i=0;i<dados.length;i++){

            double x = Math.log(single.getSingle().getValores().get(i)[1])/Math.log(10);
            Log.d("TEstr: ", "" + x + " : " + single.getSingle().getValores().get(i)[1]);


            dados[i] = new DataPoint(x,single.getSingle().getValores().get(i)[0]);
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dados);
        graph.addSeries(series);

        //fase
        DataPoint[] dadosFase = new DataPoint[single.getSingle().getValoresFase().size()];
        for(int i=0;i<dadosFase.length;i++){

            double conta = Math.atan2(single.getSingle().getValoresFase().get(i)[1],single.getSingle().getValoresFase().get(i)[0]);
            conta = (conta*180)/Math.PI;

            Log.d("teste img", "" + single.getSingle().getValoresFase().get(i)[1]);
            Log.d("teste real", "" + single.getSingle().getValoresFase().get(i)[0]);
            Log.d("teste arc", "" + conta);
            Log.d("teste x","" + single.getSingle().getValores().get(i)[1]);
            double x = single.getSingle().getValores().get(i)[1];
            x = Math.log(x)/Math.log(10);

            dadosFase[i] = new DataPoint(x,conta);
            System.out.println("oiiii");
        }
        LineGraphSeries<DataPoint> seriesFase = new LineGraphSeries<>(dadosFase);
        graphFase.addSeries(seriesFase);


    }
}
