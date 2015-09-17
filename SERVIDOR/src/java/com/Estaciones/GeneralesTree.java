/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Estaciones;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author byron
 */
public class GeneralesTree {
    //GENERALES TIPO 1
    public ABBEesta raiz;
    boolean cambio = false;
        public GeneralesTree()
        {
            this.raiz = null;
            
        }
        
        public String ModificarGenerales(String old,String id,String pass,String nombre)
        {
            if(old.equals(id)||id.equals(""))
            {
                // no hay cambio
                ABBEesta modificado = search(old,this.raiz);
                if(modificado!=null)
                {
                    modificado.setPass(pass);
                    modificado.setNombre(nombre);
                    return "Modificado facil";
                }
                else
                    return "EN MODIFICAR NO SE ENCONTRO PARA MODIFICAR PASS";
                
            }
            else
            {
                //si hubo cambio de id
                this.Eliminar(old);
                this.agregar(id, pass,nombre,1);
                return "EN MODIFICAR DIFICIL";
                
            }
        }
        private ABBEesta search(String id,ABBEesta raiz)
        {
            if(raiz==null)
                return null;
            else
            {
                if (this.Comparador(id,raiz.getID()) < 0)
                    return search(id,raiz.getIz());
                else if (this.Comparador(id,raiz.getID()) > 0)
                    return search(id,raiz.getDer());
                else
                    return raiz;
            }
        }
        
        public String GetGenerales(ABBEesta raiz)
        {
            StringBuilder cons = new StringBuilder();
            if(raiz!=null)
            {
                
                cons.append(GetGenerales(raiz.getIz()));
                cons.append(raiz.getID()+","+raiz.getPass()+","+raiz.getNombre()+"]");
                cons.append(GetGenerales(raiz.getDer()));
            }
            return cons.toString();
            
            
            
            
        }
    
    public String BuscarParaLogin(String id,String pass,ABBEesta raiz)
        {
            if(raiz==null)
                return "0,ERROR NO EXISTE";
            else
            {
                if (this.Comparador(id,raiz.getID()) < 0)
                    return BuscarParaLogin(id,pass,raiz.getIz());
                else if (this.Comparador(id,raiz.getID()) < 0)
                    return BuscarParaLogin(id,pass,raiz.getDer());
                else
                {
                    if(pass.equals(raiz.getPass()))
                    {
                        return "1,"+raiz.getNombre();
                    }
                    else
                        return "0,ERROR DE IDENTIFICACION";
                
                }
                
            
            
            }
            
        
        }    
    
        public String agregar(String id, String pass,String nombre,int tipo)
        {
            if(this.raiz==null)
            {
                raiz = new ABBEesta(id,pass,nombre,0,tipo);
                return "1,INGRESADO";
            }
            else  if (this.Comparador(id,this.raiz.getID()) < 0)//nick es menor que la raiz
            {
                //System.out.println("ENTRO QUE el ingresado es menor que la raiz");
                if(this.raiz.getIz()==null)
                {
                   this.raiz.setIz(new ABBEesta(id,pass,nombre,0,tipo));
                   this.raiz.getIz().setPadre(this.raiz);
                   ABBEesta son = this.raiz.getIz();
                   this.raiz.setFe(this.Altura(this.raiz.getDer())-this.Altura(this.raiz.getIz()));
                   //System.out.println("altura de " +this.raiz.getID() + ": "+this.raiz.getFe());
                   if (this.raiz.getFe() ==-2)
                   {
                       if(son.getFe()==-1)
                           this.RotacionII(this.raiz,son);
                       else
                           this.RotacionID(this.raiz,son);
                   }
                   return "1,INGRESADO";
                }
                else
                {
                  String res = this.raiz.getIz().agregar(id,pass,nombre,tipo);
                  ABBEesta son = this.raiz.getIz();
                  this.raiz.setFe(this.raiz.Altura(this.raiz.getDer())-this.raiz.Altura(this.raiz.getIz()));
                 // System.out.println("altura de " +this.raiz.getID() + ": "+this.raiz.getFe());
                   if (this.raiz.getFe() ==-2)
                   {
                       if(son.getFe()==-1)
                           this.RotacionII(this.raiz,son);
                       else
                           this.RotacionID(this.raiz,son);
                   } 
                   return res;
                  
                
                }
                    
            }
            else if (this.raiz.Comparador(id,this.raiz.getID()) > 0)
            {
                //System.out.println("ENTRO QUE el ingresado es mayor que la raiz");
                if(this.raiz.getDer()==null)
                {
                   this.raiz.setDer(new ABBEesta(id,pass,nombre,0,tipo));
                   this.raiz.getDer().setPadre(this.raiz);
                   ABBEesta son = this.raiz.getDer();
                   this.raiz.setFe(this.raiz.Altura(this.raiz.getDer())-this.raiz.Altura(this.raiz .getIz()));
                   //System.out.println("altura de " +this.raiz.getEmail() + ": "+this.raiz.getFe());
                   if (this.raiz.getFe() ==2)
                   {
                       if(son.getFe()==1)
                           this.RotacionDD(this.raiz,son);
                       else
                           this.RotacionDI(this.raiz,son);
                   }
                   return "1,INGRESADO";
                }
                else
                {
                  String res = this.raiz.getDer().agregar(id,pass,nombre,tipo);
                  ABBEesta son = this.raiz.getDer();
                  this.raiz.setFe(this.Altura(this.raiz.getDer())-this.Altura(this.raiz.getIz()));
                  //System.out.println("altura de " +this.raiz.getEmail() + ": "+this.raiz.getFe());
                   if (this.raiz.getFe() ==2)
                   {
                       if(son.getFe()==1)
                           this.RotacionDD(this.raiz,son);
                       else
                           this.RotacionDI(this.raiz,son);
                   }
                   return res;
                  
                
                }
                
               
                
                    
                    
            }
            else
            {
                return "0,La estacion general ya existe";
            }
            //System.out.println("-------------------------------------------");
        }
        
        public int Comparador(String comparado, String comparador)
        {
             System.out.println("COMPARADO: "+comparado+",,,, COMPARADOR: "+comparador);
             int resp = -10;
             try
             {
                 int COMPARADO = Integer.valueOf(comparado);
                 int COMPARADOR = Integer.valueOf(comparador);
                 if(COMPARADOR>COMPARADO)//raiz es mayor que entrada
                 {
                     System.out.println("RAIZ ES MAYOR QUE ENTRADA");
                     return -1;
                 }
                     
                 else if(COMPARADOR<COMPARADO)
                 {
                     System.out.println("RAIZ ES MENOR QUE ENTRADA");
                     return 1;
                 }
                 else
                 {
                     System.out.println("SON IGUALES");
                     return 0;
                 }
                     
             }
             catch(Exception ex)
             {
                 //ex.printStackTrace();
                 if(comparador.compareTo(comparado)<0)
                 {
                     return 1;
                 }
                 else if(comparador.compareTo(comparado)>0)
                 {
                     return -1;
                 }
                 else
                 {
                     return 0;
                 }
             }
             finally
             {
                 
             }
                      }
        
        
        void RotacionII(ABBEesta n, ABBEesta n1)
    {
        //System.out.println("ROTACION II");
        //System.out.println("n= "+n.getEmail()+",, n1= "+n1.getEmail());
        n.setIz(n1.getDer());
        n1.setDer(n);
        if (n1.getFe() == -1)
        {
            n.setFe(0);
            n1.setFe(0);;
        }
        else
        {
            n.setFe(-1);
            n1.setFe(1);
        }
        if(n.getPadre()!=null)
        {
            if(Comparador(n.getPadre().getID(),n.getID())>0)
            {
                n.getPadre().setDer(n1);
            }
            else
                n.getPadre().setIz(n1);
        }
        
        n1.setPadre(n.getPadre());
        n.setPadre(n1);
        if(this.raiz==n)
            this.raiz = n1;
        else
            n = n1;
    }
    
    void RotacionDD(ABBEesta n, ABBEesta n1)
    {
        //System.out.println("ROTACION DD DEL ARBOL");
        //System.out.println("n= "+n.getEmail()+",, n1= "+n1.getEmail());
        n.setDer(n1.getIz());
        n1.setIz(n);
        if (n1.getFe() == 1)
        {
            n.setFe(0);
            n1.setFe(0);
        }
        else
        {
            n.setFe(1);
            n1.setFe(-1);
        }
        if(n.getPadre()!=null)
        {
            if(Comparador(n.getPadre().getID(),n.getID())<0)
            {
                n.getPadre().setDer(n1);
            }
            else
                n.getPadre().setIz(n1);
        }
        
        n1.setPadre(n.getPadre());
        n.setPadre(n1);
        if(n==this.raiz)
            this.raiz = n1;
        else
            n = n1;
    }
    
    void RotacionID(ABBEesta n, ABBEesta n1)
        {
            
            //System.out.println("ROTACION ID DEL ARBOL n= "+n.getID()+"n1= "+n1.getEmail());
            ABBEesta n2 = n1.getDer();
            n.setIz(n2.getDer());
            n2.setDer(n);
            n1.setDer(n2.getIz());
            n2.setIz(n1);
            if (n2.getFe() == 1)
            {
                n1.setFe(-1);
                n.setFe(0);
                n2.setFe(0);
            }
                
            else if (n2.getFe() == 0)
            {
                n1.setFe(0);
                n.setFe(0);
                n2.setFe(0);
            }
            else
            {
                n1.setFe(1);
                n.setFe(0);
                n2.setFe(0);
            }
            
            if(n.getPadre()!=null)
            {
                if(Comparador(n.getPadre().getID(),n.getID())<0)
                {
                    n.getPadre().setDer(n2);
                }
                else
                    n.getPadre().setIz(n2);
            }
            n2.setPadre(n.getPadre());
            n1.setPadre(n2);
            n.setPadre(n2);
            if(n==this.raiz)
                this.raiz = n2;
            else
                n = n2;
            
            

        }

        void RotacionDI(ABBEesta n, ABBEesta n1)
        {
            //System.out.println("ROTACION DI DEL ARBOL");
            //System.out.println("n= "+n.getEmail()+",, n1= "+n1.getEmail());
            ABBEesta n2 = n1.getIz();
            n.setDer(n2.getIz());
            n2.setIz(n);
            n1.setIz(n2.getDer());
            n2.setDer(n1);

            if (n2.getFe() == 1)
            {
                n.setFe(-1);
                n1.setFe(0);
                n2.setFe(0);
            }
                
            else if(n2.getFe()==0)
            {
                n1.setFe(0);
                n.setFe(0);
                n2.setFe(0);
            }
                
            else
            {
                
                n1.setFe(1);
                n.setFe(0);
                n2.setFe(0);
            }
            
            if(n.getPadre()!=null)
            {
                if(Comparador(n.getPadre().getID(),n.getID())<0)
                {
                    n.getPadre().setDer(n2);
                }
                else
                    n.getPadre().setIz(n2);
            }
            
            
            n2.setPadre(n.getPadre());
            n1.setPadre(n2);
            n.setPadre(n2);
            if(n==this.raiz)
                this.raiz = n2;
            else
                n = n2;
        }

         

          public void Graficar(ABBEesta raiz)
          {
              StringBuilder colector = new StringBuilder();
              colector.append("digraph{\n");
              colector.append("node[shape=record]\n");
              if(raiz!=null)
              {
                colector.append(raiz.ToString() + "[label = \" <f0> | <f1> " + raiz.getID() + " | <f2>\"];\n");
                colector.append(raiz.Grafic(raiz).toString()+"\n");
              }
              
              colector.append("}\n");

            FileWriter fichero = null;
            PrintWriter pw = null;
            
            try
            {
                fichero = new FileWriter("C:\\Users\\byron\\Documents\\NetBeansProjects\\Proyecto1s22015_201222626\\SERVIDOR\\build\\web\\resources\\avlgenerales.dot");
                pw = new PrintWriter(fichero);
 
            
                pw.println(colector.toString());
 
            } catch (Exception e)
            {
                e.printStackTrace();
            } 
            finally
            {
                try
                {
                    if (null != fichero)
                        fichero.close();
                }
                catch (Exception e2)
                {
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
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", "C:\\Users\\byron\\Documents\\NetBeansProjects\\Proyecto1s22015_201222626\\SERVIDOR\\build\\web\\resources\\avlgenerales.png", "C:\\Users\\byron\\Documents\\NetBeansProjects\\Proyecto1s22015_201222626\\SERVIDOR\\build\\web\\resources\\avlgenerales.dot" );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
        }


          }
          public StringBuilder Grafic(ABBEesta raIZ)
          {
              StringBuilder rr = new StringBuilder();

              if (raIZ.getIz() != null)
                  rr.append(raIZ.getIz().ToString() + "[label = \" <f0> | <f1> " + raIZ.getIz().getID() + " | <f2>\"];\n");
              if (raIZ.getDer() != null)
                  rr.append(raIZ.getDer().ToString() + "[label = \" <f0> | <f1> " + raIZ.getDer().getID() + " | <f2>\"];\n");
              

              if (raIZ.getIz() != null)
                  rr.append(raIZ.ToString() + ":f0 -> " + raIZ.getIz().ToString() + ":f1\n");
              
              if (raIZ.getDer() != null)
                  rr.append(raIZ.ToString() + ":f2 -> " + raIZ.getDer().ToString() + ":f1\n");

              if (raIZ.getIz() != null)
                  rr.append(raIZ.getIz().Grafic(raIZ.getIz()).toString()+"\n");
              if (raIZ.getDer() != null)
                  rr.append(raIZ.getDer().Grafic(raIZ.getDer()).toString()+"\n");

              return rr;
          }
          int Altura(ABBEesta rai)
          {
            if(rai==null)
                return 0;
            else
            {
                int hi = Altura(rai.getIz());
                int hd = Altura(rai.getDer());
                if(hi>hd)
                    return hi+1;
                else
                    return hd+1;
            }
            
        }
       
        public void VerificarAlturas(ABBEesta raiz)
        {
            if(raiz!=null)
            {
                int alt = this.Altura(raiz.getDer())-this.Altura(raiz.getIz());
                //System.out.println("LA ALTURA DE "+raiz.getEmail()+" ES IGUAL A "+alt);
                VerificarAlturas(raiz.getIz());
                VerificarAlturas(raiz.getDer());
            }
        }
        private void SearchForEliminarion(ABBEesta raiz,ABBEesta raizabajo)
        {
            
            //System.out.println("EN SEARCHFORELIMINATION CON raiz= "+raiz.getEmail()+" y raiziz="+raizabajo.getEmail());
            if(raizabajo.getDer()==null)
            {
                raiz.setID(raizabajo.getID());
                raiz.setPass(raizabajo.getPass());
                raiz.setNombre(raizabajo.getNombre());
                raiz.setPersonas(raizabajo.getPersonas());
                cambio = true;
            }
            else
            {
               this.SearchForEliminarion(raiz, raizabajo.getDer());
               if(cambio)
               {
                   cambio=false;
                   raizabajo.setDer(raizabajo.getDer().getIz());
                   
               }
               raizabajo.setFe(Altura(raizabajo.getDer())-Altura(raizabajo.getIz()));
               ABBEesta son = raizabajo.getDer();
               if (raiz.getFe() ==-2)
               {
                   if(son.getFe()==-1)
                           RotacionII(raiz,son);
                       else
                           RotacionID(raiz,son);
                   } 
            }
            
            
        }
      
        private ABBEesta MenorDeLosMayores(ABBEesta raiz)
        {
            ABBEesta aux = raiz.getDer();
            while(aux.getIz()!=null)
            {
                aux = aux.getIz();
            }
            //System.out.println("LA NUEVA RAIZ ES menor de los mayores :"+aux.getEmail());
            return aux;
        }
        public void Eliminar(String id)
        {
            EliminarR(id,this.raiz);
        }
        public void EliminarR(String id,ABBEesta raiz )
        {
            if(raiz==null)
            {
                //System.out.println("NO SE ENCONTRO LO QUE SE QUIERE BORRAR");
            }
            else if (this.Comparador(id,raiz.getID()) == 0)
            {
                
                // se verifica que caso es.
                if(raiz.getDer()==null && raiz.getIz()==null)
                {
                    //System.out.println("ENTRO A ELIMINAR UNA HOJA");
                    //ES UNA HOJA SOLO SE ELIMINA
                    if(raiz.getPadre()==null)
                    {
                        //System.out.println("ENTRO A ELIMINAR LA MERA RAIZ");
                        this.raiz = null;
                    }
                    else
                    {
                        if(Comparador(raiz.getID(),raiz.getPadre().getID()) < 0)//raiz es menor que su padre
                            raiz.getPadre().setIz(null);
                        else
                            raiz.getPadre().setDer(null);
                    }
                    
                        
                    
                        
                }
                else
                {
                    if(raiz.getDer()==null)
                    {
                        System.out.println("ENTRO A ELIMINAR NODO CON DERECHO NULO");
                        if(raiz == this.raiz)
                            this.raiz = this.raiz.getIz();
                        else
                            raiz = raiz.getIz();
                    }
                    else if(this.raiz.getIz()==null)
                    {
                        System.out.println("ENTRO A ELIMINAR NODO CON IZQUIERDO NULO NULO");
                        if(raiz==this.raiz)
                            this.raiz = this.raiz.getDer();
                        else
                            raiz = raiz.getDer();
                    }
                    else
                    {
                        this.SearchForEliminarion(raiz, raiz.getIz());
                        System.out.println("DE REGRESO A EliminarR");
                       if(cambio)
                       {
                           raiz.setIz(raiz.getIz().getIz());
                           cambio=false;
                       }
                        
                        
                    }
                    
                    raiz.setFe(Altura(raiz.getDer())-Altura(raiz.getIz()));
                        if(raiz.getFe()==2)
                        {
                            ABBEesta son = raiz.getDer();
                            if(son.getFe()==-1||son.getFe()==0)
                            {
                                RotacionDI(raiz,raiz.getDer());
                            }
                            else
                            {
                                RotacionDD(raiz,raiz.getDer());
                            }
                        }
                        else if(raiz.getFe()==-2)
                        {
                            ABBEesta son = raiz.getIz();
                            if(raiz.getIz().getFe()==1|| raiz.getIz().getFe()==0)
                            {
                                RotacionID(raiz,raiz.getIz());
                            }
                            else
                            {
                                RotacionII(raiz,raiz.getIz());
                            }
                        }
                }
                
                
                
                
            }
            else  if (this.Comparador(id,raiz.getID()) < 0)//nick es menor que la raiz
            {
                //System.out.println("EN ELIMINAR ENTRO QUE el ingresado es menor que la raiz");
                EliminarR(id, raiz.getIz());
                //System.out.println("DE REGRESO A EN ELIMINAR ENTRO QUE el ingresado es menor que la raiz");
                ABBEesta son = raiz.getIz();
                raiz.setFe(Altura(raiz.getDer())-Altura(raiz.getIz()));
                //System.out.println("altura de " +raiz.getEmail() + ": "+raiz.getFe());
                   if (raiz.getFe() ==-2)
                   {
                       if(son.getFe()==-1 || son.getFe()==0)
                           RotacionII(raiz,son);
                       else
                           RotacionID(raiz,son);
                   }
                   else if (raiz.getFe() ==2)
                   {
                       System.out.println(".."+raiz.getDer().getFe()+"..");
                       if(raiz.getDer().getFe()==1 ||raiz.getDer().getFe()==0)
                           this.RotacionDD(raiz,raiz.getDer());
                       else
                           this.RotacionDI(raiz,raiz.getDer());
                   
                  
                
                   }
                  
                
                
                    
            }
            else if (Comparador(id,raiz.getID()) > 0)
            {
               // System.out.println("ENTRO QUE el ingresado es mayor que la raiz");
                
                  EliminarR(id, raiz.getDer());
                  //System.out.println("DE REGRESO A EN ELIMINAR EENTRO QUE el ingresado es mayor que la raiz");
                  ABBEesta son = raiz.getDer();
                  raiz.setFe(Altura(raiz.getDer())-Altura(raiz.getIz()));
                  //System.out.println("altura de " +raiz.getEmail() + ": "+raiz.getFe());
                   if (raiz.getFe() ==2)
                   {
                       if(son.getFe()==1)
                           this.RotacionDD(raiz,son);
                       else
                           this.RotacionDI(raiz,son);
                   
                  
                
                   }
                   else if (raiz.getFe() ==-2)
                   {
                       if(raiz.getIz().getFe()==-1 || raiz.getIz().getFe()==0)
                           RotacionII(raiz,raiz.getIz());
                       else
                           RotacionID(raiz,raiz.getIz());
                   } 
                
               
                
                    
                    
            }
            
            System.out.println("-------------------------------------------");
        
        }
          
          

    
}
