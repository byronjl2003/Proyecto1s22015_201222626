/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicios;

import com.ArbolAdmin.AdminTree;
import com.ArbolChoferes.ChoferesTree;
import com.ArbolChoferes.LBuses;
import com.ArbolChoferes.LRutas;
import com.Estaciones.ClavesTree;
import com.Estaciones.GeneralesTree;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author byron
 */
@WebService(serviceName = "SERVICIO")

public class SERVICIO {
    
    //ESTE ES EL MERO SERVICIO PARA EL PRO1 DE EDD
    
    AdminTree administradores = new AdminTree();
    ClavesTree EstacionesClaves = new ClavesTree();
    GeneralesTree EstacionesGenerales = new GeneralesTree();
    ChoferesTree choferes = new ChoferesTree();
    LBuses buses = new LBuses();
    LRutas rutas = new LRutas();
    
    
    
    /*
    public SERVICIO()
    {
        this.administradores = new AdminTree();
        this.EstacionesClaves = new ClavesTree();
        this.EstacionesGenerales = new GeneralesTree();
        buses = new LBuses();
        rutas = new LRutas();
        
    }
    */
    
    

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TraerImagen")
    public byte[] TraerImagen(@WebParam(name = "tipoimg") String tipoimg) {
        //TODO write your implementation code here:
           
        byte[] data;
        try
        {
            File f = new File("C:\\Users\\byron\\Desktop\\maquina.jpg");
            data = new byte[(int)f.length()];
            Path archivo = Paths.get("C:\\Users\\byron\\Desktop\\maquina.jpg");
            data = Files.readAllBytes(archivo);
            
        } catch (Exception ex) {
            Logger.getLogger(SERVICIO.class.getName()).log(Level.SEVERE, null, ex);
            data = null;
        }
        return data;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Loguin")
    public String Loguin(@WebParam(name = "tipo") String tipo, @WebParam(name = "id") String id, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(tipo.equals("ADMINISTRADOR"))
        {
            return this.administradores.BuscarParaLogin(id, pass,this.administradores.raiz);
            //return"HOLA";
        }
        else if(tipo.equals("CLAVE"))
        {
            return this.EstacionesClaves.BuscarParaLogin(id, pass,this.EstacionesClaves.raiz);
        }
        else if(tipo.equals("GENERAL"))
        {
            return this.EstacionesClaves.BuscarParaLogin(id, pass,this.EstacionesClaves.raiz);
        }
        else if(tipo.equals("CHOFER"))
        {
            return this.choferes.BuscarParaLogin(id, pass,this.choferes.raiz);
        }
        else
        {
            return "0,ERROR FATAL";
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddClave")
    public String AddClave(@WebParam(name = "id") String id, @WebParam(name = "pass") String pass, @WebParam(name = "nombre") String nombre) {
        return this.EstacionesClaves.agregar(id, pass, nombre,2);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddGeneral")
    public String AddGeneral(@WebParam(name = "id") String id, @WebParam(name = "pass") String pass, @WebParam(name = "nombre") String nombre) {
        return this.EstacionesGenerales.agregar(id, pass, nombre,1);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddAdmins")
    public String AddAdmins(@WebParam(name = "email") String email, @WebParam(name = "pass") String pass) {
        return this.administradores.agregar(email, pass);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddChofer")
    public String AddChofer(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "id") String id, @WebParam(name = "pass") String pass) {
        return this.choferes.agregar(id, pass, nombre, apellido);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddBus")
    public String AddBus(@WebParam(name = "numbus") String numbus) {
        return this.buses.Add(Integer.valueOf(numbus));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddRuta")
    public String AddRuta(@WebParam(name = "nombre") String nombre, @WebParam(name = "esta") String esta) {
        
        return this.rutas.Add(nombre, esta);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TraerAdmins")
    public String TraerAdmins() {
        //TODO write your implementation code here:
        return this.administradores.GetAdministradores(this.administradores.raiz);
        //return "DESDE SERVIDOR/TraerAdmins";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getImage")
    public byte[] getImage(@WebParam(name = "codigo") String codigo) throws FileNotFoundException  {
         //wsContext.getMessageContext().put(com.sun.xml.ws.developer.JAXWSProperties.MTOM_THRESHOLOD_VALUE,0);
        // TODO implement operation 
        //TODO write your implementation code here:
       File file = new File("C:\\Users\\byron\\Desktop\\pantallaso.png");
 
        FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
 
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum); 
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            //Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        byte[] bytes = bos.toByteArray();
        return bytes;
    }


}
