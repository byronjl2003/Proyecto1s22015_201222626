/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArbolAdmin;

/**
 *
 * @author byron
 */
public class ABBE {
    
     
        private String _Pass;
        private String _Email;
        private ABBE iz, der, padre;
        private int _fe;
        

        public ABBE(String email,String pass, int ffe)
        {
            this._Email = email;
            
            this._Pass = pass;
            
            this.iz = this.der = null;
            this._fe = ffe;
        }
        
         


    public String getPass() {
        return _Pass;
    }


    public void setPass(String _Pass) {
        this._Pass = _Pass;
    }

    public String getEmail() {
        return _Email;
    }

    public void setEmail(String _Email) {
        this._Email = _Email;
    }

    public ABBE getIz() {
        return iz;
    }

    public void setIz(ABBE iz) {
        this.iz = iz;
    }

 
    public ABBE getDer() {
        return der;
    }

    public void setDer(ABBE der) {
        this.der = der;
    }

    public ABBE getPadre() {
        return padre;
    }


    public void setPadre(ABBE padre) {
        this.padre = padre;
    }

    public int getFe() {
        return _fe;
    }

    public void setFe(int _fe) {
        this._fe = _fe;
    }
    
    void RotacionII(ABBE n, ABBE n1)
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
        if(Comparador(n.getPadre().getEmail(),n.getEmail())<0)
            {
                n.getPadre().setDer(n1);
            }
            else
                n.getPadre().setIz(n1);
        n1.setPadre(n.getPadre());
        n.setPadre(n1);
        n=n1;
    }
    
    void RotacionDD(ABBE n, ABBE n1)
    {
        //System.out.println("ROTACION DD");
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
        if(Comparador(n.getPadre().getEmail(),n.getEmail())<0)
        {
          n.getPadre().setDer(n1);
        }
        else
            n.getPadre().setIz(n1);
        n1.setPadre(n.getPadre());
        n.setPadre(n1);
        n=n1;
    }
    
    void RotacionID(ABBE n, ABBE n1)
        {
            //System.out.println("ROTACION ID  n= "+n.getEmail()+"n1= "+n1.getEmail());
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
            
            if(Comparador(n.getPadre().getEmail(),n.getEmail())<0)
            {
                n.getPadre().setDer(n2);
            }
            else
                n.getPadre().setIz(n2);
            n2.setPadre(n.getPadre());
            n1.setPadre(n2);
            n.setPadre(n2);
            n=n2;

        }

        void RotacionDI(ABBE n, ABBE n1)
        {
            //System.out.println("ROTACION DI");
            //System.out.println("n= "+n.getEmail()+",, n1= "+n1.getEmail());
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
                n.setFe(1);
                n1.setFe(0);
                n2.setFe(0);
                
            }
                
           
            
            if(Comparador(n.getPadre().getEmail(),n.getEmail())<0)
            {
                n.getPadre().setDer(n2);
            }
            else
                n.getPadre().setIz(n2);
            n2.setPadre(n.getPadre());
            n1.setPadre(n2);
            n.setPadre(n2);
            n = n2;
        }
        
        public StringBuilder Grafic(ABBE raIZ)
        {
            //System.out.println("SE VA A GRAFICAR:: "+raIZ._Email);
            StringBuilder rr = new StringBuilder();

            if (raIZ.getIz() != null)
                rr.append(raIZ.getIz().ToString() + "[label = \" <f0> | <f1> " + raIZ.getIz().getEmail() + " | <f2>\"];\n");
            if (raIZ.getDer() != null)
                rr.append(raIZ.getDer().ToString() + "[label = \" <f0> | <f1> " + raIZ.getDer().getEmail() + " | <f2>\"];\n");


            if (raIZ.getIz() != null)
                rr.append(raIZ.ToString() + ":f0 -> " + raIZ.getIz().ToString() + ":f1;\n");

            if (raIZ.getDer() != null)
                rr.append(raIZ.ToString() + ":f2 -> " + raIZ.getDer().ToString() + ":f1;\n");

            if (raIZ.getIz() != null)
                rr.append(raIZ.getIz().Grafic(raIZ.getIz()).toString());
            if (raIZ.getDer() != null)
                rr.append(raIZ.getDer().Grafic(raIZ.getDer()).toString());

            return rr;
        }
        
        public String ToString()
        {
            return "Admin_" + this._Email;
        }
        
        public ABBE buscar(String email)
        {
            ABBE aux = this;
            Boolean encontrado = false;
            while (aux != null && encontrado == false)
            {
                if (this.Comparador(aux.getEmail(),email) == 0)
                {
                    encontrado = true;
                }

                else if (this.Comparador(aux.getEmail(),email) < 0)//aux es menor que la raiz
                {
                    aux = aux.getDer();
                }
                else
                {
                    aux = aux.getIz();
                }
            }
            return aux;

        }
        
        public String agregar(String email, String pass)
        {
            if (this.Comparador(email,this.getEmail()) < 0)//nick es menor que la raiz
            {
                //System.out.println("ENTRO QUE el ingresado es menor que la raiz,OTRO");
                if(this.getIz()==null)
                {
                   this.setIz(new ABBE(email,pass,0));
                   this.getIz().setPadre(this);
                   ABBE son = this.getIz();
                   this.setFe(this.Altura(this.getDer())-this.Altura(this.getIz()));
                   //System.out.println("altura de " +this.getEmail() + ": "+this.getFe());
                   if (this.getFe() ==-2)
                   {
                       if(son.getFe()==-1)
                           this.RotacionII(this,son);
                       else
                           this.RotacionID(this,son);
                   }
                   return "1,INGRESADO";
                }
                else
                {
                  String res = this.getIz().agregar(email,pass);
                  //System.out.println("DE REGRESO A ENTRO QUE el ingresado es menor que la raiz,OTRO");
                  ABBE son = this.getIz();
                  this.setFe(this.Altura(this.getDer())-this.Altura(this.getIz()));
                  //System.out.println("altura de " +this.getEmail() + ": "+this.getFe());
                   if (this.getFe() ==-2)
                   {
                       if(son.getFe()==-1)
                           this.RotacionII(this,son);
                       else
                           this.RotacionID(this,son);
                   }
                   return res;
                   
                  
                
                }
                    
            }
            else if (this.Comparador(email,this.getEmail()) > 0)
            {
                //System.out.println("ENTRO QUE el ingresado es mayor que la raiz,OTRO");
                if(this.getDer()==null)
                {
                   this.setDer(new ABBE(email,pass,0));
                   this.getDer().setPadre(this);
                   ABBE son = this.getDer();
                   this.setFe(this.Altura(this.getDer())-this.Altura(this.getIz()));
                   //System.out.println("altura de " +this.getEmail() + ": "+this.getFe());
                   if (this.getFe() ==2)
                   {
                       if(son.getFe()==1)
                           this.RotacionDD(this,son);
                       else
                           this.RotacionDI(this,son);
                   }
                   return "1,INGRESADO";
                }
                else
                {
                  String res =this.getDer().agregar(email,pass);
                  //System.out.println("DE REGRESO A ENTRO QUE el ingresado es mayor que la raiz,OTRO");
                  ABBE son = this.getDer();
                  this.setFe(this.Altura(this.getDer())-this.Altura(this.getIz()));
                  //System.out.println("altura de " +this.getEmail() + ": "+this.getFe());
                   if (this.getFe() ==2)
                   {
                       if(son.getFe()==1)
                           this.RotacionDD(this,son);
                       else
                           this.RotacionDI(this,son);
                   }
                   return res;
                  
                
                }
                
               
                
                    
                    
            }
            else
            {
                return "0,EL ADMIN YA ESTA REPETIDO";
            }
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
             /*
             int resp = -10;
             for(int i = 0;i<comparado.length();i++)
             {
                 if(comparador.length()-1>=i)
                 {
                     if(comparado.charAt(i)<comparador.charAt(i))
                    {
                        System.out.println("ES MENOR EL INGRESADO");
                        resp= -1;
                    }
                    else if(comparado.charAt(i)>comparador.charAt(i))
                    {
                        System.out.println("ES MAYOR EL INGRESADO");
                        resp = 1;
                    }
                     
                 }
                 
                     
                 
             }
             if(comparador.length()==comparado.length())
             {
                 System.out.println("ESTA RETORNANDO RESP");
                 return resp;
             }
                 
             else if(comparador.length()>comparado.length())
             {
                 System.out.println("ESTA RETORNANDO -1");
                 return -1;
             }
                 
             else if(comparador.length()<comparado.length())
             {
                 System.out.println("ESTA RETORNANDO 1");
                 return 1;
             }
             else
             {
                 System.out.println("ESTA RETORNANDO 0");
                 return 0;
             }
             
             */
            // return 0;
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
        
        
        private ABBE MayorDeLosMenores(ABBE raiz)
        {
            ABBE aux = raiz.iz;
            while(aux.getDer()!=null)
            {
                aux = aux.getDer();
            }
            System.out.println("LA NUEVA RAIZ ES  mayor de los menores:"+aux.getEmail());
            return aux;
        }
        private ABBE MenorDeLosMayores(ABBE raiz)
        {
            ABBE aux = raiz.der;
            while(aux.getIz()!=null)
            {
                aux = aux.getIz();
            }
            System.out.println("LA NUEVA RAIZ ES menor de los mayores :"+aux.getEmail());
            return aux;
        }
        
       

        
        
        
    
    
    
    


    
    
         
         
       
    
}
