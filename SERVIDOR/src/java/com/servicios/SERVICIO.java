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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author byron
 */
@WebService(serviceName = "SERVICIO")
public class SERVICIO {
    
    //ESTE ES EL MERO SERVICIO PARA EL PRO1 DE EDD
    
    AdminTree administradores;
    ClavesTree EstacionesClaves;
    GeneralesTree EstacionesGenerales;
    ChoferesTree choferes;
    LBuses buses;
    LRutas rutas;
    
    
    public SERVICIO()
    {
        this.administradores = new AdminTree();
        this.EstacionesClaves = new ClavesTree();
        this.EstacionesGenerales = new GeneralesTree();
        buses = new LBuses();
        rutas = new LRutas();
        this.administradores.agregar("ADMIN@ADMIN","ADMIN");
    }
    
    

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


}
