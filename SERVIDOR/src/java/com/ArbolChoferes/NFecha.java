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
public class NFecha {
    
    private String fecha;
    private NFecha next,back;
    LInfo linformacion;
    
    public NFecha(String Fecha)
    {
        this.fecha = fecha;
        this.next = this.back = null;
        linformacion = new LInfo();
    }
    
    public String ToStringEncabezado()
    {
        return "NFecha"+fecha+"[label=\"<f0>|<f1>#BUS: "+this.fecha+"|<f2>\"];";
    }
    
    public String ToString()
    {
        return "NFecha"+this.fecha;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the next
     */
    public NFecha getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NFecha next) {
        this.next = next;
    }

    /**
     * @return the back
     */
    public NFecha getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(NFecha back) {
        this.back = back;
    }
    
    
}
