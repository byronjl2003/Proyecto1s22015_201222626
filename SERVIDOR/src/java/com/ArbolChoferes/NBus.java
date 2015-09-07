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
public class NBus {
    
    private int _NumBus;
    private NBus back,next;
    private int _personas;
    
    public NBus(int num)
    {
        this._NumBus = num;
        this._personas=0;
        this.back = this.next = null;
    }
    
    public String ToStringEncabezado()
    {
        return "Nodo"+getNumBus()+"[label=\"<f0>|<f1>#BUS: "+this.getNumBus()+"|<f2>\"];";
    }
    
    public String ToString()
    {
        return "Nodo"+this.getNumBus();
    }

    /**
     * @return the _NumBus
     */
    public int getNumBus() {
        return _NumBus;
    }

    /**
     * @param _NumBus the _NumBus to set
     */
    public void setNumBus(int _NumBus) {
        this._NumBus = _NumBus;
    }

    /**
     * @return the back
     */
    public NBus getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(NBus back) {
        this.back = back;
    }

    /**
     * @return the next
     */
    public NBus getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NBus next) {
        this.next = next;
    }

    /**
     * @return the _personas
     */
    public int getPersonas() {
        return _personas;
    }

    /**
     * @param _personas the _personas to set
     */
    public void setPersonas(int _personas) {
        this._personas = _personas;
    }
    
    
    
}
