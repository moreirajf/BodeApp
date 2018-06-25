package com.example.josef.esportsfeedapp.bodeapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Denis
 */
public class Operacoes {
    public double[] soma(double a[], double b[]){
        double r[] = {a[0]+b[0],a[1]+b[1]};

        return r;
    }
    public double[] subtracao(double a[], double b[]){
        double r[] = {a[0]-b[0],a[1]-b[1]};

        return r;
    }
    public double[] multiplicacao(double a[], double b[]){
        double r[] = {((a[0]*b[0])-(a[1]*b[1])),((a[0]*b[1])+(b[0]*a[1]))};

        return r;
    }
    public double[] divisao(double a[], double b[]){
        double[] r =  new double[2];
        r[0] = ((a[0]*b[0])+(a[1]*b[1]))/((Math.pow(b[0],2))+(Math.pow(b[1],2)));
        r[1] = ((b[0]*a[1])-(a[0]*b[1]))/((Math.pow(b[0],2))+(Math.pow(b[1],2)));
        return r;
    }


    public double[] termo(int grau, double ponto){

        double r[] = new double[2];

        if(grau == 0){
            r[0] = 1;
            r[1] = 0
            ;
            return r;
        }
        else if(grau == 1){
            r[0] = ponto;
            r[1] = 1;

            return r;
        }
        else if(grau == 2){
            r[0] = -1 * Math.pow(ponto,grau);
            r[1] = 0;

            return r;
        }
        else if(grau == 3){
            r[0] = -ponto * Math.pow(ponto,grau);
            r[1] = 1;

            return r;
        }
        else if(grau == 4){
            r[0] = 1 * Math.pow(ponto,grau);
            r[1] = 0;

            return r;
        }
        else if(grau == 5){
            r[0] = ponto * Math.pow(ponto,grau);
            r[1] = 1;

            return r;
        }
        else{
            r[0] = -1 * Math.pow(ponto,6);
            r[1] = 0;

            return r;
        }
    }

    public double p(double a[]){

        double aux = Math.pow(a[0], 2) + Math.pow(a[1], 2);
        return Math.sqrt(aux);

    }

        public double l(Double a){

            return 20*(Math.log(a)/Math.log(10));

    }

}
