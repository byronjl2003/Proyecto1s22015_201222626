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
public class NInfo {
    
    private NInfo next,back;
    private int bus;
    private String ruta;
    private String horaini,horafinal;
    private String id;
    public LTiempos ltiempos;
    public NInfo(int numbus,String nomruta,String hini, String hfinal,String fecha,int id)
    {
        this.next = this.back = null;
        this.bus = numbus;
        this.ruta = nomruta;
        this.horaini = hini;
        this.horafinal = hfinal;
        this.id = fecha+id;
        ltiempos = new LTiempos();
        
        
        
    }
    public String ToStringEncabezado()
    {
        return "NInfo"+id+"[label=\"<f0>|<f1>#BUS: "+bus+"\\Ruta: "+ruta+"\\Hinicio: "+horaini+"\\Hfinal: "+horafinal+"|<f2>\"];";
    }
    
    public String ToString()
    {
        return "NInfo"+this.id;
    }

    /**
     * @return the next
     */
    public NInfo getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NInfo next) {
        this.next = next;
    }

    /**
     * @return the back
     */
    public NInfo getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(NInfo back) {
        this.back = back;
    }

    /**
     * @return the bus
     */
    public int getBus() {
        return bus;
    }

    /**
     * @param bus the bus to set
     */
    public void setBus(int bus) {
        this.bus = bus;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the horaini
     */
    public String getHoraini() {
        return horaini;
    }

    /**
     * @param horaini the horaini to set
     */
    public void setHoraini(String horaini) {
        this.horaini = horaini;
    }

    /**
     * @return the horafinal
     */
    public String getHorafinal() {
        return horafinal;
    }

    /**
     * @param horafinal the horafinal to set
     */
    public void setHorafinal(String horafinal) {
        this.horafinal = horafinal;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
}
