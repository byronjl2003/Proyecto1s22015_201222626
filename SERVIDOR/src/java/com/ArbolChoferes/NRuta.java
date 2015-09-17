/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArbolChoferes;

import com.Estaciones.ABBEesta;

/**
 *
 * @author byron
 */
public class NRuta {
    
    private String nombre;
    //private String id;
    private LEstaciones estaciones;
    private NRuta next,back;
    
    public NRuta(String nombre,String esta)
    {
        this.nombre = nombre;
        //this.id = id;
        estaciones = new LEstaciones();
        String[] vector1 = esta.split(";");
        for(int i=0;i<vector1.length;i++)
        {
            String[] vector2 = vector1[i].split(",");
            estaciones.Add(vector2[0],Integer.parseInt(vector2[1]));
        }
        
    }
    public String getRuta()
    {
        return  this.getNombre()+":["+this.estaciones.getEstaciones()+"]";
        
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    

    /**
     * @return the estaciones
     */
    
   
    public LEstaciones getEstaciones() {
        return estaciones;
    }

    /**
     * @param estaciones the estaciones to set
     */
    public void setEstaciones(LEstaciones estaciones) {
        this.estaciones = estaciones;
    }

    /**
     * @return the next
     */
    public NRuta getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NRuta next) {
        this.next = next;
    }

    /**
     * @return the back
     */
    public NRuta getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(NRuta back) {
        this.back = back;
    }
    
    
    
    
    
    
    
    
    
    
    
    private class LEstaciones
    {
        private  NEstacion primero, ultimo;
        private int elementos;
        public LEstaciones()
        {
            this.primero= this.ultimo = null;
        
        }
        private boolean Vacia()
        {
            return this.getPrimero()==null;
        }
        public String getEstaciones()
        {
            String resp = "";
            NEstacion aux = this.primero;
            while(aux!=null)
            {
                if(aux.getNext()==null)
                    resp = resp+aux.getIdestacion();
                else
                    resp = resp+aux.getIdestacion()+",";
                aux = aux.getNext();
            }
            
            return resp;
        }
        public void Add(String id, int tipo)
        {
            if(Vacia())
            {
            
                this.setElementos(this.getElementos() + 1);
                this.setPrimero(new NEstacion(id,tipo));
                this.setUltimo(this.getPrimero());
            
        }
        else
        {
            this.setElementos(this.getElementos()+1);
            getUltimo().setNext(new NEstacion(id,tipo));
            getUltimo().getNext().setBack(getUltimo());
            this.setUltimo(getUltimo().getNext());  
            
        
        }//else
        
        //System.out.println("DESPUES DE AGREGAR: "+this.elementos);
            
    }

        /**
         * @return the primero
         */
        public NEstacion getPrimero() {
            return primero;
        }

        /**
         * @param primero the primero to set
         */
        public void setPrimero(NEstacion primero) {
            this.primero = primero;
        }

        /**
         * @return the ultimo
         */
        public NEstacion getUltimo() {
            return ultimo;
        }

        /**
         * @param ultimo the ultimo to set
         */
        public void setUltimo(NEstacion ultimo) {
            this.ultimo = ultimo;
        }

        /**
         * @return the elementos
         */
        public int getElementos() {
            return elementos;
        }

        /**
         * @param elementos the elementos to set
         */
        public void setElementos(int elementos) {
            this.elementos = elementos;
        }
    

    
    
    }
    
    private class NEstacion
    {
        private String  idestacion;
        private int tipo;
        private NEstacion next,back;
        
        public NEstacion(String id,int tipo)
        {
            this.tipo = tipo;
            this.idestacion = id;
            this.next = this.back = null;
        }

        /**
         * @return the idestacion
         */
        public String getIdestacion() {
            return idestacion;
        }

        /**
         * @param idestacion the idestacion to set
         */
        public void setIdestacion(String idestacion) {
            this.idestacion = idestacion;
        }

        /**
         * @return the tipo
         */
        public int getTipo() {
            return tipo;
        }

        /**
         * @param tipo the tipo to set
         */
        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        /**
         * @return the next
         */
        public NEstacion getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(NEstacion next) {
            this.next = next;
        }

        /**
         * @return the back
         */
        public NEstacion getBack() {
            return back;
        }

        /**
         * @param back the back to set
         */
        public void setBack(NEstacion back) {
            this.back = back;
        }
        
    }
            
            
    
    
}
