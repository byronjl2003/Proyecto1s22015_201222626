/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.servicios.SERVICIO_Service;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
;


/**
 *
 * @author byron
 */
public class Admin extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.56.101_8080/SERVIDOR/SERVICIO.wsdl")
    private SERVICIO_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String para = request.getParameter("tip");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ADMIN </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ADMIN at " + request.getContextPath() +""+para+ "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //processRequest(request, response);
            String parametro = request.getParameter("tip");
            if(parametro.equals("ADMIN"))
            {
                 String pagina = "/adminver.jsp";
                 String admins = this.traerAdmins();
                 request.setAttribute("admins",admins);
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
            }
            else  if(parametro.equals("ADMINEDITAR"))
            {
                String idd = request.getParameter("id");
                String pass = request.getParameter("pass");
                String pagina = "/admineditar.jsp";
                request.setAttribute("id",idd);
                request.setAttribute("pass",pass);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("ADMINELIMINAR"))
            {
                String idd = request.getParameter("id");
                int resp = this.eliminar("ADMIN",idd);
                String pagina = "/adminver.jsp";
                String admins = this.traerAdmins();
                request.setAttribute("admins",admins);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("ADMINCREAR"))
            {
                 String pagina = "/admincrear.jsp";
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
            }
            
            else if(parametro.equals("GENERAL"))
            {
                String pagina = "/generalver.jsp";
                String admins = this.traerGenerales();
                request.setAttribute("generales",admins);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
                
            }
            else  if(parametro.equals("GENERALEDITAR"))
            {
                String idd = request.getParameter("id");
                String pass = request.getParameter("pass");
                String nombre = request.getParameter("nombre");
                String pagina = "/generaleditar.jsp";
                request.setAttribute("id",idd);
                request.setAttribute("pass",pass);
                request.setAttribute("nombre",nombre);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("GENERALELIMINAR"))
            {
                String idd = request.getParameter("id");
                int resp = this.eliminar("GENERAL",idd);
                String pagina = "/generalver.jsp";
                String generales = this.traerGenerales();
                request.setAttribute("generales",generales);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("GENERALCREAR"))
            {
                 String pagina = "/generalcrear.jsp";
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
            }
            else if(parametro.equals("CLAVE"))
            {
                String pagina = "/clavever.jsp";
                String claves = this.traerClaves();
                request.setAttribute("claves",claves);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("CLAVEEDITAR"))
            {
                String idd = request.getParameter("id");
                String pass = request.getParameter("pass");
                String nombre = request.getParameter("nombre");
                String pagina = "/claveeditar.jsp";
                request.setAttribute("id",idd);
                request.setAttribute("pass",pass);
                request.setAttribute("nombre",nombre);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("CLAVEELIMINAR"))
            {
                String idd = request.getParameter("id");
                int resp = this.eliminar("CLAVE",idd);
                String pagina = "/clavever.jsp";
                String claves = this.traerClaves();
                request.setAttribute("claves",claves);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("CLAVECREAR"))
            {
                 String pagina = "/clavecrear.jsp";
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
            }
            
            else if(parametro.equals("CHOFER"))
            {
                String pagina = "/choferever.jsp";
                String claves = this.traerChoferes();
                request.setAttribute("choferes",claves);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("CHOFEREDITAR"))
            {
                String idd = request.getParameter("id");
                String pass = request.getParameter("pass");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String pagina = "/chofereditar.jsp";
                request.setAttribute("id",idd);
                request.setAttribute("pass",pass);
                request.setAttribute("nombre",nombre);
                request.setAttribute("apellido",apellido);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("CLAVEELIMINAR"))
            {
                String idd = request.getParameter("id");
                int resp = this.eliminar("CHOFER",idd);
                String pagina = "/choferver.jsp";
                String claves = this.traerChoferes();
                request.setAttribute("choferes",claves);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("CHOFERCREAR"))
            {
                 String pagina = "/chofercrear.jsp";
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
            }
            else if(parametro.equals("RUTA"))
            {
                String pagina = "/rutaver.jsp";
                String claves = this.traerRutas();
                request.setAttribute("rutas",claves);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("RUTACREAR"))
            {
                 String pagina = "/rutacrear.jsp";
                 String claves = this.traerClaves();
                 String generales = this.traerGenerales();
                 request.setAttribute("claves",claves);
                 request.setAttribute("generales",generales);
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
            }
            else if(parametro.equals("BUS"))
            {
                String pagina = "/busver.jsp";
                String buses = this.traerBuses();
                request.setAttribute("buses",buses);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);  
            }
            else if(parametro.equals("BUSCREAR"))
            {
                String pagina = "/buscrear.jsp";
                //String buses = this.traerBuses();
                //request.setAttribute("buses",buses);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);  
            }
            else  if(parametro.equals("BUSEDITAR"))
            {
                String idd = request.getParameter("idbus");
                String pass = request.getParameter("personas");
                
                String pagina = "/buseditar.jsp";
                request.setAttribute("idbus",idd);
                request.setAttribute("personas",pass);
                
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("BUSELIMINAR"))
            {
                String idd = request.getParameter("idbus");
                int resp = this.eliminar("BUS",idd);
                String pagina = "/busver.jsp";
                String buses = this.traerBuses();
                request.setAttribute("buses",buses);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else if(parametro.equals("ASIGNACION"))
            {
                String pagina = "/asignacion.jsp";
                //request.setAttribute("path","");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else if(parametro.equals("GRAFICA"))
            {
                String pagina = "/graficas.jsp";
                request.setAttribute("path","");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else if(parametro.equals("GADMINS"))
            {
                String pagina = "/graficas.jsp";
                String path = this.graficar("ADMINS");
                request.setAttribute("path",path);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else if(parametro.equals("GGENERALES"))
            {
                String pagina = "/graficas.jsp";
                String path = this.graficar("GENERALES");
                request.setAttribute("path",path);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else if(parametro.equals("GCLAVES"))
            {
                String pagina = "/graficas.jsp";
                String path = this.graficar("CLAVES");
                request.setAttribute("path",path);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else if(parametro.equals("GCHOFERES"))
            {
                String pagina = "/graficas.jsp";
                String path = this.graficar("CHOFERES");
                request.setAttribute("path",path);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            
            
           }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String flag = request.getParameter("tip");
             if(flag.equals("crear"))
            {
                String EMAIL = request.getParameter("email");
                String PASS = request.getParameter("pass");
                String resp = this.addAdmins(EMAIL, PASS);
            
                String[] vec1 =  resp.split(",");
                if(vec1[0].equals("0"))
                {
                    String pagina = "/admincrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                else
                {
                    String pagina = "/admincrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                
            }
            else if(flag.equals("editar"))
            {
                String old = request.getParameter("old");
                
                String EMAIL = request.getParameter("email");
                String PASS = request.getParameter("pass");
                String resp = this.modificarAdmin(old,EMAIL, PASS);
                System.out.println(resp);
                String pagina = "/adminver.jsp";
                String admins = this.traerAdmins();
                request.setAttribute("admins",admins);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
                
                
            }
            else if(flag.equals("creargeneral"))
            {
                String ID = request.getParameter("id");
                String PASS = request.getParameter("pass");
                String NOMBRE = request.getParameter("nombre");
                String resp = this.addGeneral(ID, PASS, NOMBRE);
            
                String[] vec1 =  resp.split(",");
                if(vec1[0].equals("0"))
                {
                    String pagina = "/generalcrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                else
                {
                    String pagina = "/generalcrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                
            }
            else if(flag.equals("editargeneral"))
            {
                String old = (String)request.getParameter("old");
                
                String ID = request.getParameter("id");
                String PASS = request.getParameter("pass");
                String NOMBRE = request.getParameter("nombre");
                String resp = this.modificarGeneral(old,ID, PASS,NOMBRE);
                System.out.println(resp);
                String pagina = "/generalver.jsp";
                String admins = this.traerGenerales();
                request.setAttribute("generales",admins);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
                
                
            }
            else if(flag.equals("crearclave"))
            {
                String ID = request.getParameter("id");
                String PASS = request.getParameter("pass");
                String NOMBRE = request.getParameter("nombre");
                String resp = this.addClave(ID, PASS, NOMBRE);
            
                String[] vec1 =  resp.split(",");
                if(vec1[0].equals("0"))
                {
                    String pagina = "/clavecrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                else
                {
                    String pagina = "/clavecrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                
            }
            else if(flag.equals("editarclave"))
            {
                String old = (String)request.getParameter("old");
                
                String ID = request.getParameter("id");
                String PASS = request.getParameter("pass");
                String NOMBRE = request.getParameter("nombre");
                String resp = this.modificarClave(old,ID, PASS,NOMBRE);
                System.out.println(resp);
                String pagina = "/clavever.jsp";
                String admins = this.traerClaves();
                request.setAttribute("claves",admins);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
                
                
            }
            
            else if(flag.equals("crearbus"))
            {
                String ID = request.getParameter("idbus");
                String resp = this.addBus(ID);
            
                String[] vec1 =  resp.split(",");
                if(vec1[0].equals("0"))
                {
                    String pagina = "/buscrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                else
                {
                    String pagina = "/buscrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                
            }
            else if(flag.equals("editarbus"))
            {
                String old = (String)request.getParameter("old");
                
                String ID = request.getParameter("idbus");
                String PERSONAS = request.getParameter("personas");
                //String NOMBRE = request.getParameter("nombre");
                String resp = this.modificarBus(old,ID,PERSONAS);
                System.out.println(resp);
                String pagina = "/busver.jsp";
                String admins = this.traerBuses();
                request.setAttribute("buses",admins);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
                
                
            }
            
            else if(flag.equals("crearchofer"))
            {
                String ID = request.getParameter("id");
                String PASS = request.getParameter("pass");
                String NOMBRE = request.getParameter("nombre");
                String APELLIDO = request.getParameter("apellido");
                String resp = this.addChofer(ID,PASS,NOMBRE,APELLIDO);
            
                String[] vec1 =  resp.split(",");
                if(vec1[0].equals("0"))
                {
                    String pagina = "/buscrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                else
                {
                    String pagina = "/buscrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                
            }
            else if(flag.equals("editarchofer"))
            {
                String old = (String)request.getParameter("old");
                
                String ID = request.getParameter("id");
                String PASS = request.getParameter("pass");
                String NOMBRE = request.getParameter("nombre");
                String APELLIDO = request.getParameter("apellido");
                //String NOMBRE = request.getParameter("nombre");
                String resp = this.modificarChofer(old, ID, PASS,NOMBRE,APELLIDO);
                System.out.println(resp);
                String pagina = "/choferver.jsp";
                String admins = this.traerChoferes();
                request.setAttribute("choferes",admins);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
                
                
            }
            
            
            
            
            else if(flag.equals("crearruta"))
            {
                
                String NOMBRE = request.getParameter("nombre");
                String[] gens = request.getParameterValues("selectgenerales");
                String[] claves = request.getParameterValues("selectclaves");
                String esta = "";
                for(int i=0;i<gens.length;i++)
                {
                    esta = esta+gens[0]+",1;";
                }
                for(int i=0;i<claves.length;i++)
                {
                    esta = esta+claves[0]+",2;";
                }
                String resp = this.addRuta(NOMBRE, esta);
            
                String[] vec1 =  resp.split(",");
                if(vec1[0].equals("0"))
                {
                    String pagina = "/rutacrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                else
                {
                    String pagina = "/rutacrear.jsp";
                    request.setAttribute("RESP",vec1[1]);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                    dispatcher.forward(request, response);
                }
                
            }
            
            else if(flag.equals("ingreso"))
            {
                 String pagina = "/admin.jsp";
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            
            
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String addAdmins(java.lang.String email, java.lang.String pass) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.addAdmins(email, pass);
    }

    private String addBus(java.lang.String numbus) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.addBus(numbus);
    }

    private String addChofer(java.lang.String nombre, java.lang.String apellido, java.lang.String id, java.lang.String pass) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.addChofer(nombre, apellido, id, pass);
    }

    private String addClave(java.lang.String id, java.lang.String pass, java.lang.String nombre) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.addClave(id, pass, nombre);
    }

    private String addGeneral(java.lang.String id, java.lang.String pass, java.lang.String nombre) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.addGeneral(id, pass, nombre);
    }

    private String addRuta(java.lang.String nombre, java.lang.String esta) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.addRuta(nombre, esta);
    }

    private int asignacion(java.lang.String linea) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.asignacion(linea);
    }

    private int eliminar(java.lang.String tipo, java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.eliminar(tipo, id);
    }

    private String graficar(java.lang.String grafica) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.graficar(grafica);
    }

    private String loguin(java.lang.String tipo, java.lang.String id, java.lang.String pass) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.loguin(tipo, id, pass);
    }

    private String modificarAdmin(java.lang.String old, java.lang.String email, java.lang.String pass) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.modificarAdmin(old, email, pass);
    }

    private String modificarBus(java.lang.String old, java.lang.String idbus, java.lang.String personas) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.modificarBus(old, idbus, personas);
    }

    private String modificarClave(java.lang.String old, java.lang.String id, java.lang.String pass, java.lang.String nombre) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.modificarClave(old, id, pass, nombre);
    }

    private String modificarGeneral(java.lang.String old, java.lang.String id, java.lang.String pass, java.lang.String nombre) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.modificarGeneral(old, id, pass, nombre);
    }

    private String modificarRuta(java.lang.String old, java.lang.String nombre, java.lang.String esta) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.modificarRuta(old, nombre, esta);
    }

    private String traerAdmins() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.traerAdmins();
    }

    private String traerBuses() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.traerBuses();
    }

    private String traerChoferes() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.traerChoferes();
    }

    private String traerClaves() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.traerClaves();
    }

    private String traerGenerales() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.traerGenerales();
    }

    private String modificarChofer(java.lang.String old, java.lang.String id, java.lang.String pass, java.lang.String nombre, java.lang.String apellido) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.modificarChofer(old, id, pass, nombre, apellido);
    }

    private String traerRutas() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.traerRutas();
    }
    
    
    

    
}
