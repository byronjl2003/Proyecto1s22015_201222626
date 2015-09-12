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

/**
 *
 * @author byron
 */
public class Admin extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/SERVIDOR/SERVICIO.wsdl")
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
            if(parametro.equals("1"))
            {
                 String pagina = "/adminver.jsp";
                 String admins = this.traerAdmins();
                 request.setAttribute("admins",admins);
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
            }
            else  if(parametro.equals("2"))
            {
                String idd = request.getParameter("id");
                String pagina = "/admineditar.jsp";
                String admins = this.traerAdmins();
                request.setAttribute("id",idd);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else  if(parametro.equals("3"))
            {
                //eliminar
            }
            else  if(parametro.equals("4"))
            {
                 String pagina = "/admincrear.jsp";
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
            }
            else if(parametro.equals("imagenes"))
            {
                String pagina = "/graficas.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                dispatcher.forward(request, response);
            }
            else if(parametro.equals("imagenes2"))
            {
                byte[] bytes = this.getImage("hola");
                response.reset();
                response.setContentType("image/jpeg");
                response.getOutputStream().write(bytes);
                response.getOutputStream().flush();
                response.getOutputStream().close();
                
                /*
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                Iterator<?> readers = ImageIO.getImageReadersByFormatName("png");
                //ImageIO is a class containing static methods for locating ImageReaders
                //and ImageWriters, and performing simple encoding and decoding. 
                ImageReader reader = (ImageReader) readers.next();
                Object source = bis;
                ImageInputStream iis = ImageIO.createImageInputStream(source);
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();
                Image image = reader.read(0, param);
                //got an image file
                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
                //bufferedImage is the RenderedImage to be written
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.drawImage(image, null, null);
                String ruruta = this.getServletContext().getRealPath("servlet")+"imagen.png";
                File imageFile = new File("ruruta");
                ImageIO.write(bufferedImage, "jpg", imageFile);
                //System.out.println(imageFile.getPath());
                String pagina = "/graficas.jsp";
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
                 dispatcher.forward(request, response);
                 */
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

    private String traerAdmins() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.traerAdmins();
    }

    private String addAdmins(java.lang.String email, java.lang.String pass) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.addAdmins(email, pass);
    }

    private byte[] getImage(java.lang.String codigo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.servicios.SERVICIO port = service.getSERVICIOPort();
        return port.getImage(codigo);
    }
    
    
    
}
