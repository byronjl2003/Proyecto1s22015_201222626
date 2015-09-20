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
public class LRutas {
    
    private  NRuta primero, ultimo;
    private int elementos;
    public LRutas()
    {
        this.primero= this.ultimo = null;
        
    }
    
    public String ModificarRutas(String old,String nombre,String esta)
    {
        NRuta ruta = Buscar(old);
        ruta = new NRuta(nombre,esta);
        return "SE MODIFICO LA RUTA";        
    }
    
    
    public String GetRutas()
    {
        StringBuilder cons = new StringBuilder();
        NRuta aux = this.primero;
        while(aux!=null)
        {
            cons.append(aux.getRuta()+";");
            aux = aux.getNext();
        }
        return cons.toString();
            
            
            
            
    }
    private boolean Vacia()
    {
        return this.getPrimero()==null;
    }
    
    public NRuta Buscar(String nombre)
    {
        NRuta resp = this.primero;
        while(resp!=null)
        {
            if(nombre.equals(resp.getNombre()))
                break;
            else
            resp = resp.getNext();
        }
        return resp;
    }
   
    public String Add(String nombre,String esta)
    {
        NRuta nodo = Buscar(nombre);
        if(nodo!=null)
        {
           return "0,RUTA REPETIDO"; 
        }
        else
        {
            if(Vacia())
            {
            
                this.setElementos(this.getElementos() + 1);
                this.setPrimero(new NRuta(nombre,esta));
                this.setUltimo(this.getPrimero());
            
            }
            else
            {
                
                this.setElementos(this.getElementos()+1);
                getUltimo().setNext(new NRuta(nombre,esta));
                getUltimo().getNext().setBack(getUltimo());
                this.setUltimo(getUltimo().getNext());  
            
        
            }
            return "1,RUTA INGRESADA CORRECTAMENTE";
        }
        
            
    }
    public void EliminarDeLista(String  nombre)
   {
       NRuta aux = this.primero;
       while(aux!=null)
       {
           if(aux.getNombre().equals(nombre))
               break;
           else
               aux = aux.getNext();
       }
       if(aux!=null)
       {
           if(aux==this.primero)
           {
               if(this.primero.getNext()!=null)
                   this.primero.getNext().setBack(null);
               this.primero = this.primero.getNext();
               this.setElementos(this.getElementos()-1);
           
       }
       else if(aux==this.ultimo)
       {
           this.ultimo = this.ultimo.getBack();
           this.ultimo.setNext(null);
           this.setElementos(this.getElementos()-1);
       }
       else
       {
           aux.getBack().setNext(aux.getNext());
           aux.getNext().setBack(aux.getBack());
           this.setElementos(this.getElementos()-1);
       }
           
       }
       
       
   }
    



    
    public NRuta getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NRuta primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NRuta getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NRuta ultimo) {
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
