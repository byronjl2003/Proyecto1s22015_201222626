/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArbolChoferes;

/**
 *
 * @author byron
 */
public class NTiempos {
    
    private String entrada,salida;
    private NTiempos next,back;
    
    public NTiempos(String entrada, String salida)
    {
        this.entrada = entrada;
        this.salida = salida;
        this.next = null;
    }
    public String ToStringEncabezado()
    {
        return "NTiempos"+entrada+""+salida+"[label=\"<f0>|<f1>Entrada: "+entrada+"\\SALIDA:"+salida+"|<f2>\"];";
    }
    
    public String ToString()
    {
        return "NTiempos"+entrada+""+salida;
    }

    /**
     * @return the entrada
     */
    public String getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the salida
     */
    public String getSalida() {
        return salida;
    }

    /**
     * @param salida the salida to set
     */
    public void setSalida(String salida) {
        this.salida = salida;
    }

    /**
     * @return the next
     */
    public NTiempos getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NTiempos next) {
        this.next = next;
    }
    /**
     * @return the next
     */
    public NTiempos getBack() {
        return back;
    }

    /**
     * @param next the next to set
     */
    public void setBack(NTiempos back) {
        this.back = next;
    }
    
}
