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
public class LFechas {
    
    private  NFecha primero, ultimo;
    private int elementos;
    public LFechas()
    {
        this.primero= this.ultimo = null;
        
    }
    private boolean Vacia()
    {
        return this.getPrimero()==null;
    }
   
    public void Add(String fec)
    {
        if(Vacia())
        {
            
            this.setElementos(this.getElementos() + 1);
            this.primero = new NFecha(fec);
            this.ultimo = this.primero;
            
        }
        else
        {
            this.setElementos(this.getElementos()+1);
            getUltimo().setNext(new NFecha(fec));
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
        NFecha aux = this.primero;
        while(aux!=null)
        {
            constructor.append(aux.ToStringEncabezado()+"\n");
            aux = aux.getNext();
        }
        //-- ralaciones entre usuarios
        NFecha aux2 = this.primero;
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
            fichero = new FileWriter("C:\\Users\\byron\\Desktop\\GraficasAVLS\\LFechas.dot");
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
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", "C:\\Users\\byron\\Desktop\\GraficasAVLS\\LFechas.png", "C:\\Users\\byron\\Desktop\\GraficasAVLS\\LFechas.dot" );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
        }
        
        
        
    }
    
    

  
    public NFecha getPrimero() {
        return primero;
    }

  
    public void setPrimero(NFecha primero) {
        this.primero = primero;
    }


    public NFecha getUltimo() {
        return ultimo;
    }

  
    public void setUltimo(NFecha ultimo) {
        this.ultimo = ultimo;
    }

  
    public int getElementos() {
        return this.elementos;
    }

  
    public void setElementos(int elementos) {
        this.elementos = elementos;
    }


    
}
