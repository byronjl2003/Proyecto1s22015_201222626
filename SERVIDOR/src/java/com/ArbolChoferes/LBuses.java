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
public class LBuses {
    
    private  NBus primero, ultimo;
    private int buses;
    private int elementos;
    public LBuses()
    {
        this.buses = 0;
        this.primero= this.ultimo = null;
        
    }
    private boolean Vacia()
    {
        return this.getPrimero()==null;
    }
    
    public NBus buscar(int num)
    {
        NBus resp = this.primero;
        while(resp!=null)
        {
            if(resp.getNumBus()==num)
                break;
            else
                resp = resp.getNext();
        }
        return resp;
    }
    
    
   
    public String Add(int num)
    {
        
        NBus bus = buscar(num);
        if(bus!=null)
        {
            return "0, BUSREPETIDO"; 
        }
        else
        {
            if(Vacia())
            {
            
                this.setElementos(this.getElementos() + 1);
                this.primero = new NBus(num);
                this.ultimo = this.primero;
            
            }
            else
            {
                this.setElementos(this.getElementos()+1);
                getUltimo().setNext(new NBus(num));
                getUltimo().getNext().setBack(getUltimo());
                this.setUltimo(getUltimo().getNext());  
            
        
            }
            return "1,RUTA INGRESADA CORRECTAMENTE";
        }
        
        //else
        
        //System.out.println("DESPUES DE AGREGAR: "+this.elementos);
            
    }
    
    
   
   
   
   
  
   
   public void EliminarDeLista(int  numbus)
   {
       NBus aux = this.primero;
       while(aux!=null)
       {
           if(aux.getNumBus()==numbus)
               break;
           else
               aux = aux.getNext();
       }
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
    
   
    




    
    
    
    
    public void Graficar()
    {
        System.out.println("EN GRAFICAR DE LA LISTA");
        StringBuilder constructor  = new StringBuilder();
        constructor.append("digraph g{ \n");
        constructor.append("node [shape = record ];\n");
        //----encabezado de usuarios
        NBus aux = this.primero;
        while(aux!=null)
        {
            constructor.append(aux.ToStringEncabezado()+"\n");
            aux = aux.getNext();
        }
        //-- ralaciones entre usuarios
        NBus aux2 = this.primero;
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
            fichero = new FileWriter("C:\\Users\\byron\\Desktop\\GraficasAVLS\\LBuses.dot");
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
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", "C:\\Users\\byron\\Desktop\\GraficasAVLS\\LBuses.png", "C:\\Users\\byron\\Desktop\\GraficasAVLS\\LBuses.dot" );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
        }
        
        
        
    }
    
    

  
    public NBus getPrimero() {
        return primero;
    }

  
    public void setPrimero(NBus primero) {
        this.primero = primero;
    }


    public NBus getUltimo() {
        return ultimo;
    }

  
    public void setUltimo(NBus ultimo) {
        this.ultimo = ultimo;
    }

  
    public int getElementos() {
        return this.elementos;
    }

  
    public void setElementos(int elementos) {
        this.elementos = elementos;
    }


    
}
