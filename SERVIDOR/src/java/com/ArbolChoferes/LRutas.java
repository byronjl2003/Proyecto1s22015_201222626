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
        return null;
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
    

 /*
    public void Graficar()
    {
        System.out.println("EN GRAFICAR DE LA LISTA");
        StringBuilder constructor  = new StringBuilder();
        constructor.append("digraph g{ \n");
        constructor.append("node [shape = record ];\n");
        encabezado de usuarios
        NFecha aux = this.getPrimero();
        while(aux!=null)
        {
            constructor.append(aux.ToStringEncabezado()+"\n");
            aux = aux.getNext();
        }
        ralaciones entre usuarios
        NFecha aux2 = this.getPrimero();
        while(aux2!=null)
        {
            if(aux2.getNext()!=null)
                constructor.append(aux2.ToString()+":f2 -> "+aux2.getNext().ToString()+":f0 ;\n");
            if(aux2.getBack()!=null)
                constructor.append(aux2.ToString()+":f0 -> "+aux2.getBack().ToString()+":f2 ;\n");
            aux2 = aux2.getNext();
        }
       
         se grafica los string en cada usuario
        
        
        
        constructor.append("\n }");
        
        
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\byron\\Desktop\\GraficasAVLS\\LFechas.dot");
            pw = new PrintWriter(fichero);
 
            
                pw.println(constructor.toString());
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
            Nuevamente aprovechamos el finally para 
            asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
          
           try
		{       
			ProcessBuilder pbuilder;
		    
			
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", "C:\\Users\\byron\\Desktop\\GraficasAVLS\\LFechas.png", "C:\\Users\\byron\\Desktop\\GraficasAVLS\\LFechas.dot" );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
        }
        
        
        
    }*/

    
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
