package com.example.josef.esportsfeedapp.bodeapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.josef.esportsfeedapp.bodeapp.Single;

import java.util.ArrayList;

import static com.example.josef.esportsfeedapp.bodeapp.Single.single;

public class Principal {
    int grauNumerador = 0;
    int grauDenominador = 0;

    //double pontosParaPlotar[] = {0.001, 0.002, 0.003, 0.004, 0.005, 0.006, 0.007, 0.008,0.009, 0.01,0.02,0.03,0.04,0.05,0.06,0.07,0.08,0.09,0.1	,	1	,	10	,	100	,	1000	,	10000	,	100000  , 0.2	,	2	,	20	,	200	,	2000	,	20000	,	200000  ,                                0.3	,	3	,	30	,	300	,	3000	,	30000	,	300000  ,                                0.4	,	4	,	40	,	400	,	4000	,	40000	,	400000  ,                                0.5	,	5	,	50	,	500	,	5000	,	50000	,	500000  ,                                0.6	,	6	,	60	,	600	,	6000	,	60000	,	600000  ,                                0.7	,	7	,	70	,	700	,	7000	,	70000	,	700000  ,                                0.8	,	8	,	80	,	800	,	8000	,	80000	,	800000  ,                                0.9	,	9	,	90	,	900	,	9000	,	90000	,	900000};

    double pontosParaPlotar[] = {0.001, 0.002, 0.003, 0.004, 0.005, 0.006, 0.007, 0.008,0.009, 0.01,0.02,0.03,0.04,0.05,0.06,0.07,0.08,0.09,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100};
    //double pontosParaPlotar[] = {0.001,0.001,0.01,1,10,100};
    //double pontosParaPlotar[] = {1,10,1000};
    ArrayList <double[]> meusResultadosNumerador;
    ArrayList <double[]> meusResultadosDivisoes;
    ArrayList <double[]> meusResultadosDenominador;
    ArrayList <Double> meusResultadosPitagoras;
    ArrayList <Double> meusResultadosLog;
    ArrayList <double[]> meusFinais;
    ArrayList <double[]> meusFinalOrdenado;

    //contrutor
    public Principal(double itenNumerador[], double itenDenominador[], int grauNumerador, int grauDenominador){

        int fator = 1;


        this.grauNumerador = grauNumerador;
        this.grauDenominador = grauDenominador;

        resolveOmega(itenNumerador,itenDenominador);
        resolveDivisao();

        single.getSingle().setValoresFase(meusResultadosDivisoes);

        resolvePitagoras();
        resolveLog();
        montaFinal();

        //Intent i = new Intent(this,GerarGrafico.class);

        //for (int i = 0;i < meusFinais.size();i++){
            //Log.d("TEST","" + meusFinais.get(i)[0] +"," + meusFinais.get(i)[i]);
        //}
        print2(meusFinais);
        montaFinalOrdenado(meusFinais);

        single.getSingle().setValores(meusFinalOrdenado);



    }

    //metodos
    public void resolveOmega(double itenNumerador[], double itenDenominador[]){

        meusResultadosNumerador = new ArrayList <double[]> ();
        meusResultadosDenominador = new ArrayList <double[]> ();

        Operacoes o = new Operacoes();

        for(int pontoAtual=0;pontoAtual<pontosParaPlotar.length;pontoAtual++){

            double rNumerador[] = {0,0};


            for(int i=0;i<itenNumerador.length;i++){

                double termo[] = o.termo(i,pontosParaPlotar[pontoAtual]);

                if(termo[1] == 0){
                    rNumerador[0] = rNumerador[0] + (itenNumerador[i] * termo[0]);
                    System.out.println("- PontoParaPlotar: "+pontosParaPlotar[pontoAtual]+"\n re: "+itenNumerador[i]);
                }
                else if(termo[1] == 1){
                    rNumerador[1] = rNumerador[1] + (itenNumerador[i] * termo[0]);
                    System.out.println("n co: "+itenNumerador[i]);
                }
            }
            meusResultadosNumerador.add(rNumerador);
            double rDenominador[] = {0,0};

            for(int i=0;i<itenDenominador.length;i++){

                double termo[] = o.termo(i,pontosParaPlotar[pontoAtual]);

                if(termo[1] == 0){
                    rDenominador[0] = rDenominador[0] + (itenDenominador[i] * termo[0]);
                    System.out.println("d re: "+itenDenominador[i]);
                }
                else if(termo[1] == 1){
                    rDenominador[1] = rDenominador[1] + (itenDenominador[i] * termo[0]);
                    System.out.println("d co: " +itenDenominador[i]);
                }

            }
            meusResultadosDenominador.add(rDenominador);

        }
    }

    public void resolveDivisao(){

        meusResultadosDivisoes = new ArrayList <double[]> ();
        Operacoes o = new Operacoes();

        double rDivisao[] = {0,0};

        for(int i=0;i<meusResultadosNumerador.size();i++){
            double aux[] = o.divisao(meusResultadosNumerador.get(i), meusResultadosDenominador.get(i));

            meusResultadosDivisoes.add(aux);
        }
    }

    public void resolvePitagoras(){

        meusResultadosPitagoras= new ArrayList <Double> ();
        Operacoes o = new Operacoes();

        for(int i=0;i<meusResultadosDivisoes.size();i++){
            meusResultadosPitagoras.add(o.p(meusResultadosDivisoes.get(i)));
        }
    }

    public void resolveLog(){

        meusResultadosLog = new ArrayList <Double> ();
        Operacoes o = new Operacoes();

        for(int i=0;i<meusResultadosPitagoras.size();i++){
            meusResultadosLog.add(o.l(meusResultadosPitagoras.get(i)));
        }
    }

    public void print1(ArrayList a){
        System.out.println("-");

        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
    }

    public void print2(ArrayList <double[]> a){
        System.out.println("--");

        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i)[0]+" "+a.get(i)[1]);
        }

    }

    public void montaFinal(){

        meusFinais = new ArrayList <double[]>();
        double r[] = {0,0};

        for(int i=0;i<meusResultadosLog.size();i++){

            r[0] = meusResultadosLog.get(i);
            r[1] = pontosParaPlotar[i];

            meusFinais.add(r);

            r = new double[2];
        }
    }

    public void montaFinalOrdenado(ArrayList<double[]> a){

        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.size();j++){

                if(a.get(i)[1] < a.get(j)[1] ){
                    double aux[] = a.get(i);
                    a.set(i,a.get(j));
                    a.set(j,aux);

                }

            }

        }

        meusFinalOrdenado = a;

    }

}


    /*
    public double verificaTipo(Object obj){
        if (obj.getClass().equals("int") || obj.getClass().equals("double")){
            return (double)obj;
        }
        return 0;
    }
    */



