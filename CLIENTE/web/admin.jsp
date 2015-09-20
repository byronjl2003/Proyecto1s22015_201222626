<%-- 
    Document   : index
    Created on : 02-sep-2015, 21:32:11
    Author     : byron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file = "WEB-INF/jspf/jscss.jspf" %>
        <title>PROYECTO1 EDD</title>
    </head>
    <body>
        <%! String nombre;%>
        
        
        
        <div>
            <div class="header">
                <%=request.getAttribute("RESPUESTA") %>
       
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
        <div class="divmenu">
            HOLIS.. SUPERADMIN
        </div>
        <br>
        
        <%@include file="WEB-INF/jspf/bottom.jspf" %>
        
   

    <%-- end web service invocation --%><hr/>
    </body>
</html>
