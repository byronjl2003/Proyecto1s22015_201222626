/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Estaciones;

/**
 *
 * @author byron
 */
public class ABBEesta {
      
    private String _ID;
    private String _Pass;
    private String _Nombre;
    private ABBEesta iz,der;
    private ABBEesta padre;
    private int _fe;
    private int _personas;
    private int tipo;

    
        
    
    
    /**
     * @return the _ID
     */
    
    public String getID() {
        return _ID;
    }

    /**
     * @param _ID the _ID to set
     */
    public void setID(String _ID) {
        this._ID = _ID;
    }

    /**
     * @return the _Pass
     */
    public String getPass() {
        return _Pass;
    }

    /**
     * @param _Pass the _Pass to set
     */
    public void setPass(String _Pass) {
        this._Pass = _Pass;
    }

    /**
     * @return the _Nombre
     */
    public String getNombre() {
        return _Nombre;
    }

    /**
     * @param _Nombre the _Nombre to set
     */
    public void setNombre(String _Nombre) {
        this._Nombre = _Nombre;
    }

    /**
     * @return the iz
     */
    public ABBEesta getIz() {
        return iz;
    }

    /**
     * @param iz the iz to set
     */
    public void setIz(ABBEesta iz) {
        this.iz = iz;
    }

    /**
     * @return the der
     */
    public ABBEesta getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(ABBEesta der) {
        this.der = der;
    }

    /**
     * @return the padre
     */
    public ABBEesta getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(ABBEesta padre) {
        this.padre = padre;
    }

    /**
     * @return the _fe
     */
    public int getFe() {
        return _fe;
    }

    /**
     * @param _fe the _fe to set
     */
    public void setFe(int _fe) {
        this._fe = _fe;
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
    public ABBEesta(String id, String pass, String nombre,int fe,int tipo)
    {
        this._ID = id;
        this._Pass = pass;
        this._Nombre = nombre;
        this._fe = fe;
        this.tipo = tipo;
        this.der = null;
        this.iz = null;
        this.padre = null;
    }
    void RotacionII(ABBEesta n, ABBEesta n1)
    {
        //System.out.println("ROTACION II");
        //System.out.println("n= "+n.getID()+",, n1= "+n1.getE());
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
        if(Comparador(n.getPadre().getID(),n.getID())<0)
            {
                n.getPadre().setDer(n1);
            }
            else
                n.getPadre().setIz(n1);
        n1.setPadre(n.getPadre());
        n.setPadre(n1);
        n=n1;
    }
    
    void RotacionDD(ABBEesta n, ABBEesta n1)
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
        if(Comparador(n.getPadre().getID(),n.getID())<0)
        {
          n.getPadre().setDer(n1);
        }
        else
            n.getPadre().setIz(n1);
        n1.setPadre(n.getPadre());
        n.setPadre(n1);
        n=n1;
    }
    
    void RotacionID(ABBEesta n, ABBEesta n1)
        {
            //System.out.println("ROTACION ID  n= "+n.getEmail()+"n1= "+n1.getEmail());
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
            
            if(Comparador(n.getPadre().getID(),n.getID())<0)
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

        void RotacionDI(ABBEesta n, ABBEesta n1)
        {
            //System.out.println("ROTACION DI");
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
                n.setFe(1);
                n1.setFe(0);
                n2.setFe(0);
                
            }
                
           
            
            if(Comparador(n.getPadre().getID(),n.getID())<0)
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
        
        public StringBuilder Grafic(ABBEesta raIZ)
        {
            //System.out.println("SE VA A GRAFICAR:: "+raIZ._Email);
            StringBuilder rr = new StringBuilder();

            if (raIZ.getIz() != null)
                rr.append(raIZ.getIz().ToString() + "[label = \" <f0> | <f1> " + raIZ.getIz().getID() + " | <f2>\"];\n");
            if (raIZ.getDer() != null)
                rr.append(raIZ.getDer().ToString() + "[label = \" <f0> | <f1> " + raIZ.getDer().getID() + " | <f2>\"];\n");


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
            return "Admin_" + this.getID();
        }
        
        public ABBEesta buscar(String id)
        {
            ABBEesta aux = this;
            Boolean encontrado = false;
            while (aux != null && encontrado == false)
            {
                if (this.Comparador(aux.getID(),id) == 0)
                {
                    encontrado = true;
                }

                else if (this.Comparador(aux.getID(),id) < 0)//aux es menor que la raiz
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
        
        public String agregar(String id, String pass,String nombre, int tipo)
        {
            if (this.Comparador(id,this.getID()) < 0)//nick es menor que la raiz
            {
                //System.out.println("ENTRO QUE el ingresado es menor que la raiz,OTRO");
                if(this.getIz()==null)
                {
                   this.setIz(new ABBEesta(id,pass,nombre,0,tipo));
                   this.getIz().setPadre(this);
                   ABBEesta son = this.getIz();
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
                  String res = this.getIz().agregar(id,pass,nombre,tipo);
                 // System.out.println("DE REGRESO A ENTRO QUE el ingresado es menor que la raiz,OTRO");
                  ABBEesta son = this.getIz();
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
            else if (this.Comparador(id,this.getID()) > 0)
            {
                //System.out.println("ENTRO QUE el ingresado es mayor que la raiz,OTRO");
                if(this.getDer()==null)
                {
                   this.setDer(new ABBEesta(id,pass,nombre,0,tipo));
                   this.getDer().setPadre(this);
                   ABBEesta son = this.getDer();
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
                  String res = this.getDer().agregar(id,pass,nombre,tipo);
                  //System.out.println("DE REGRESO A ENTRO QUE el ingresado es mayor que la raiz,OTRO");
                  ABBEesta son = this.getDer();
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
                return "0,El Chofer ya existe";
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
        
        
   
}