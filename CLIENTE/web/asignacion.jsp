<%-- 
    Document   : asignacion
    Created on : 17-sep-2015, 20:17:06
    Author     : byron
--%>

<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "WEB-INF/jspf/jscss.jspf" %>
        <script type="text/javascript" src="codigo.js"></script>
        <title>PROYECTO1 EDD</title>
        
    </head>
    <body>
        <div>
            <div class="header">
                ASIGNACION DE BUSES
       
            </div>
            
             <div class="content">
        
                
        <div class="divmenu">
        <div class="btn-group" role="group" aria-label="...">
            <% request.setAttribute("nombre",request.getAttribute("RESPUESTA"));
               //request.setAttribute("tip","1");
            %>
            <a href="Admin?tip=ADMIN" class="btn btn-default" role = "button">Administradores</a>
            <a href="Admin?tip=GENERAL" class="btn btn-default" role = "button">Est. Generales</a>
            <a href="Admin?tip=CLAVE" class="btn btn-default" role = "button">Est. Clave</a>
            <a href="Admin?tip=BUS" class="btn btn-default" role = "button">Buses</a>
            <a href="Admin?tip=RUTA" class="btn btn-default" role = "button">Rutas</a>
            <a href="Admin?tip=GRAFICA" class="btn btn-default" role = "button">Graficas</a>
            <a href="Admin?tip=ASIGNACION" class="btn btn-default" role = "button">ASIGNACION</a>
        </div>
        </div>    
            <form action="UploadServlet" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>
        
      <%@include file="WEB-INF/jspf/bottom.jspf" %>
    </body>
</html>
