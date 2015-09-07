/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArbolChoferes;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author byron
 */
public class LTiempos {
    
    private  NTiempos primero, ultimo;
    private int elementos;
    public LTiempos()
    {
        this.primero= this.ultimo = null;
        
    }
    private boolean Vacia()
    {
        return this.getPrimero()==null;
    }
   
    public void Add(String entrada, String salida)
    {
        if(Vacia())
        {
            
            this.setElementos(this.getElementos() + 1);
            this.setPrimero(new NTiempos(entrada,salida));
            this.setUltimo(this.getPrimero());
            
        }
        else
        {
            this.setElementos(this.getElementos()+1);
            getUltimo().setNext(new NTiempos(entrada,salida));
            getUltimo().getNext().setBack(getUltimo());
            this.setUltimo(getUltimo().getNext());  
            
        
        }//else
        
        //System.out.println("DESPUES DE AGREGAR: "+this.elementos);
            
    }
    

    
    public void Graficar()
    {
        //System.out.println("EN GRAFICAR DE LA LISTA");
        StringBuilder constructor  = new StringBuilder();
        constructor.append("digraph g{ \n");
        constructor.append("node [shape = record ];\n");
        //----encabezado de usuarios
        NTiempos aux = this.getPrimero();
        while(aux!=null)
        {
            constructor.append(aux.ToStringEncabezado()+"\n");
            aux = aux.getNext();
        }
        //-- ralaciones entre usuarios
        NTiempos aux2 = this.getPrimero();
        while(aux2!=null)
        {
            if(aux2.getNext()!=null)
                constructor.append(aux2.ToString()+":f2 -> "+aux2.getNext().ToString()+":f0 ;\n");
            if(aux2.getBack()!=null)
                constructor.append(aux2.ToString()+":f0 -> "+aux2.getBack().ToString()+":f2 ;\n");
            aux2 = aux2.getNext();
        }
       
        //-- se grafica los string en cada usuario
        
        
        
        constructor.append("\n }");
        
        
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\byron\\Desktop\\GraficasAVLS\\LTiempos.dot");
            pw = new PrintWriter(fichero);
 
            
                pw.println(constructor.toString());
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
           
           //....GENERACION CON DOT
           try
		{       
			ProcessBuilder pbuilder;
		    
			/*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
			 */
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", "C:\\Users\\byron\\Desktop\\GraficasAVLS\\LTiempos.png", "C:\\Users\\byron\\Desktop\\GraficasAVLS\\LTiempos.dot" );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
        }
        
        
        
    }

    /**
     * @return the primero
     */
    public NTiempos getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NTiempos primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NTiempos getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NTiempos ultimo) {
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
