/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArbolAdmin;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author byron
 */
public class AdminTree {
    
    public ABBE raiz;
    boolean cambio = false;
        public AdminTree()
        {
            this.raiz = null;
            this.agregar("HOLA","ADMIN");
            this.agregar("LULA","TATULA");
            
        }
        
        public String ModificarAdmin(String old,String email,String pass)
        {
            if(old.equals(email)||email.equals(""))
            {
                // no hay cambio
                ABBE modificado = search(old,this.raiz);
                if(modificado!=null)
                {
                    modificado.setPass(pass);
                    return "Modificado facil";
                }
                else
                    return "EN MODIFICAR NO SE ENCONTRO PARA MODIFICAR PASS";
                
            }
            else
            {
                //si hubo cambio de id
                this.Eliminar(old);
                this.agregar(email, pass);
                return "EN MODIFICAR DIFICIL";
                
            }
        }
        private ABBE search(String email,ABBE raiz)
        {
            if(raiz==null)
                return null;
            else
            {
                if (this.Comparador(email,raiz.getEmail()) < 0)
                    return search(email,raiz.getIz());
                else if (this.Comparador(email,raiz.getEmail()) > 0)
                    return search(email,raiz.getDer());
                else
                    return raiz;
            }
        }
        public String GetAdministradores(ABBE raiz)
        {
            StringBuilder cons = new StringBuilder();
            if(raiz!=null)
            {
                
                cons.append(GetAdministradores(raiz.getIz()));
                cons.append(raiz.getEmail()+","+raiz.getPass()+"]");
                cons.append(GetAdministradores(raiz.getDer()));
            }
            return cons.toString();
            
            
            
            
        }
        public String agregar(String email, String pass)
        {
            if(this.raiz==null)
            {
                raiz = new ABBE(email,pass,0);
                return "1,INGRESADO";
            }
            else  if (this.Comparador(email,this.raiz.getEmail()) < 0)//nick es menor que la raiz
            {
                //System.out.println("ENTRO QUE el ingresado es menor que la raiz");
                if(this.raiz.getIz()==null)
                {
                   this.raiz.setIz(new ABBE(email,pass,0));
                   this.raiz.getIz().setPadre(this.raiz);
                   ABBE son = this.raiz.getIz();
                   this.raiz.setFe(this.Altura(this.raiz.getDer())-this.Altura(this.raiz.getIz()));
                   //System.out.println("altura de " +this.raiz.getEmail() + ": "+this.raiz.getFe());
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
                  String res = this.raiz.getIz().agregar(email,pass);
                  ABBE son = this.raiz.getIz();
                  this.raiz.setFe(this.raiz.Altura(this.raiz.getDer())-this.raiz.Altura(this.raiz.getIz()));
                  //System.out.println("altura de " +this.raiz.getEmail() + ": "+this.raiz.getFe());
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
            else if (this.raiz.Comparador(email,this.raiz.getEmail()) > 0)
            {
                //System.out.println("ENTRO QUE el ingresado es mayor que la raiz");
                if(this.raiz.getDer()==null)
                {
                   this.raiz.setDer(new ABBE(email,pass,0));
                   this.raiz.getDer().setPadre(this.raiz);
                   ABBE son = this.raiz.getDer();
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
                  String res = this.raiz.getDer().agregar(email,pass);
                  ABBE son = this.raiz.getDer();
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
                 return "0,EL USUARIO YA ESTA REPETIDO";
            }
           
        }
        
        public int Comparador(String comparado, String comparador)
        {
             //System.out.println("COMPARADO: "+comparado+",,,, COMPARADOR: "+comparador);
             int resp = -10;
             try
             {
                 int COMPARADO = Integer.valueOf(comparado);
                 int COMPARADOR = Integer.valueOf(comparador);
                 if(COMPARADOR>COMPARADO)//raiz es mayor que entrada
                 {
                     //System.out.println("RAIZ ES MAYOR QUE ENTRADA");
                     return -1;
                 }
                     
                 else if(COMPARADOR<COMPARADO)
                 {
                     //System.out.println("RAIZ ES MENOR QUE ENTRADA");
                     return 1;
                 }
                 else
                 {
                     //System.out.println("SON IGUALES");
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
        
    public String BuscarParaLogin(String email,String pass,ABBE raiz)
    {
        System.out.println("BuscarParaLogin: id="+email+" pass= "+pass);
        if(raiz==null)
            return "0,ERROR NO EXISTE";
        else
        {
            if (this.Comparador(email,raiz.getEmail()) < 0)
                return BuscarParaLogin(email,pass,raiz.getIz());
            else if (this.Comparador(email,raiz.getEmail()) > 0)
                return BuscarParaLogin(email,pass,raiz.getDer());
            else
            {
                if(pass.equals(raiz.getPass()))
                {
                    return "1,"+email;
                }
                else
                    return "0,ERROR DE IDENTIFICACION";
                
            }
                
            
            
        }
            
        
    }
        void RotacionII(ABBE n, ABBE n1)
    {
        System.out.println("ROTACION II");
        System.out.println("n= "+n.getEmail()+",, n1= "+n1.getEmail());
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
            if(Comparador(n.getPadre().getEmail(),n.getEmail())>0)
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
    
    void RotacionDD(ABBE n, ABBE n1)
    {
        System.out.println("ROTACION DD DEL ARBOL");
        System.out.println("n= "+n.getEmail()+",, n1= "+n1.getEmail());
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
            if(Comparador(n.getPadre().getEmail(),n.getEmail())<0)
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
    
    void RotacionID(ABBE n, ABBE n1)
        {
            
            System.out.println("ROTACION ID DEL ARBOL n= "+n.getEmail()+"n1= "+n1.getEmail());
            ABBE n2 = n1.getDer();
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
                if(Comparador(n.getPadre().getEmail(),n.getEmail())<0)
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

        void RotacionDI(ABBE n, ABBE n1)
        {
            System.out.println("ROTACION DI DEL ARBOL");
            System.out.println("n= "+n.getEmail()+",, n1= "+n1.getEmail());
            ABBE n2 = n1.getIz();
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
                if(Comparador(n.getPadre().getEmail(),n.getEmail())<0)
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

         

          public void Graficar(ABBE raiz)
          {
              System.out.println("EN GRAFICAR ARBOL ADMINS");
              StringBuilder colector = new StringBuilder();
              colector.append("digraph{\n");
              colector.append("node[shape=record]\n");
              if(raiz!=null)
              {
                colector.append(raiz.ToString() + "[label = \" <f0> | <f1> " + raiz.getEmail() + " | <f2>\"];\n");
                colector.append(raiz.Grafic(raiz).toString()+"\n");
              }
              
              colector.append("}\n");

            FileWriter fichero = null;
            PrintWriter pw = null;
            
            try
            {
                fichero = new FileWriter("C:\\Users\\byron\\Documents\\NetBeansProjects\\Proyecto1s22015_201222626\\SERVIDOR\\build\\web\\resources\\avladmin.dot");
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
                    System.out.println(e2.getMessage());
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
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", "C:\\Users\\byron\\Documents\\NetBeansProjects\\Proyecto1s22015_201222626\\SERVIDOR\\build\\web\\resources\\avladmin.png", "C:\\Users\\byron\\Documents\\NetBeansProjects\\Proyecto1s22015_201222626\\SERVIDOR\\build\\web\\resources\\avladmin.dot" );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { System.out.println(e.getMessage()); }
        }


          }
          public StringBuilder Grafic(ABBE raIZ)
          {
              StringBuilder rr = new StringBuilder();

              if (raIZ.getIz() != null)
                  rr.append(raIZ.getIz().ToString() + "[label = \" <f0> | <f1> " + raIZ.getIz().getEmail() + " | <f2>\"];\n");
              if (raIZ.getDer() != null)
                  rr.append(raIZ.getDer().ToString() + "[label = \" <f0> | <f1> " + raIZ.getDer().getEmail() + " | <f2>\"];\n");
              

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
          int Altura(ABBE rai)
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
       
        public void VerificarAlturas(ABBE raiz)
        {
            if(raiz!=null)
            {
                int alt = this.Altura(raiz.getDer())-this.Altura(raiz.getIz());
                System.out.println("LA ALTURA DE "+raiz.getEmail()+" ES IGUAL A "+alt);
                VerificarAlturas(raiz.getIz());
                VerificarAlturas(raiz.getDer());
            }
        }
        private void SearchForEliminarion(ABBE raiz,ABBE raizabajo)
        {
            
            System.out.println("EN SEARCHFORELIMINATION CON raiz= "+raiz.getEmail()+" y raiziz="+raizabajo.getEmail());
            if(raizabajo.getDer()==null)
            {
                raiz.setEmail(raizabajo.getEmail());
                raiz.setPass(raizabajo.getPass());
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
               ABBE son = raizabajo.getDer();
               if (raiz.getFe() ==-2)
               {
                   if(son.getFe()==-1)
                           RotacionII(raiz,son);
                       else
                           RotacionID(raiz,son);
                   } 
            }
            
            
        }
      
        private ABBE MenorDeLosMayores(ABBE raiz)
        {
            ABBE aux = raiz.getDer();
            while(aux.getIz()!=null)
            {
                aux = aux.getIz();
            }
            System.out.println("LA NUEVA RAIZ ES menor de los mayores :"+aux.getEmail());
            return aux;
        }
        public void Eliminar(String email)
        {
            EliminarR(email,this.raiz);
        }
        public void EliminarR(String email,ABBE raiz )
        {
            if(raiz==null)
            {
                System.out.println("NO SE ENCONTRO LO QUE SE QUIERE BORRAR");
            }
            else if (this.Comparador(email,raiz.getEmail()) == 0)
            {
                
                // se verifica que caso es.
                if(raiz.getDer()==null && raiz.getIz()==null)
                {
                    System.out.println("ENTRO A ELIMINAR UNA HOJA");
                    //ES UNA HOJA SOLO SE ELIMINA
                    if(raiz.getPadre()==null)
                    {
                        System.out.println("ENTRO A ELIMINAR LA MERA RAIZ");
                        this.raiz = null;
                    }
                    else
                    {
                        if(Comparador(raiz.getEmail(),raiz.getPadre().getEmail()) < 0)//raiz es menor que su padre
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
                            ABBE son = raiz.getDer();
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
                            ABBE son = raiz.getIz();
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
            else  if (this.Comparador(email,raiz.getEmail()) < 0)//nick es menor que la raiz
            {
                System.out.println("EN ELIMINAR ENTRO QUE el ingresado es menor que la raiz");
                EliminarR(email, raiz.getIz());
                System.out.println("DE REGRESO A EN ELIMINAR ENTRO QUE el ingresado es menor que la raiz");
                ABBE son = raiz.getIz();
                raiz.setFe(Altura(raiz.getDer())-Altura(raiz.getIz()));
                System.out.println("altura de " +raiz.getEmail() + ": "+raiz.getFe());
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
            else if (Comparador(email,raiz.getEmail()) > 0)
            {
                System.out.println("ENTRO QUE el ingresado es mayor que la raiz");
                
                  EliminarR(email, raiz.getDer());
                  System.out.println("DE REGRESO A EN ELIMINAR EENTRO QUE el ingresado es mayor que la raiz");
                  ABBE son = raiz.getDer();
                  raiz.setFe(Altura(raiz.getDer())-Altura(raiz.getIz()));
                  System.out.println("altura de " +raiz.getEmail() + ": "+raiz.getFe());
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
