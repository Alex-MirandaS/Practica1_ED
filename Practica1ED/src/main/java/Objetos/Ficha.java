/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Listas.Lista;
import Principal.Constantes;

/**
 *
 * @author alex
 */
public class Ficha {
    private String datos;
    private String apostador;
    private double monto;
    private int [] ordenCaballos;

    public Ficha(String apostador, double monto, int[] ordenCaballos) {
        this.apostador = apostador;
        this.monto = monto;
        this.ordenCaballos = ordenCaballos;
    }
    
    public Ficha(String datos) {
        this.datos = datos;
    }

    public String getApostador() {
        return apostador;
    }

    public void setApostador(String apostador) {
        this.apostador = apostador;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int[] getOrdenCaballos() {
        return ordenCaballos;
    }

    public void setOrdenCaballos(int[] ordenCaballos) {
        this.ordenCaballos = ordenCaballos;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    
    
}
