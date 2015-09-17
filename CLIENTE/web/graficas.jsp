<%-- 
    Document   : graficas
    Created on : 10-sep-2015, 18:07:17
    Author     : byron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file = "WEB-INF/jspf/jscss.jspf" %>
        
        <title>PROYECTO1 EDD</title>
    </head>
    <body>
        
        
        
        
        <div>
            <div class="header">
                <%=request.getAttribute("id") %>
                <br>
                 EDITAR
       
        </div>
    <div class="content">
        
                
        <div class="divmenu">
        <div class="btn-group" role="group" aria-label="...">
           
            <a href="Admin?tip=ADMIN" class="btn btn-default" role = "button">Administradores</a>
            <a href="Admin?tip=GENERAL" class="btn btn-default" role = "button">Est. Generales</a>
            <a href="Admin?tip=CLAVE" class="btn btn-default" role = "button">Est. Clave</a>
            <a href="Admin?tip=BUS" class="btn btn-default" role = "button">Buses</a>
            <a href="Admin?tip=RUTA" class="btn btn-default" role = "button">Rutas</a>
            <a href="Admin?tip=GRAFICA" class="btn btn-default" role = "button">Graficas</a>
            
        </div>
        <br>
        <br>
        <br>
        <div class="btn-group" role="group" aria-label="...">
            <a href="Admin?tip=GADMINS" class="btn btn-default" role = "button">AVL.Administradores</a>
            <a href="Admin?tip=GGENERALES" class="btn btn-default" role = "button">AVL.Est. Generales</a>
            <a href="Admin?tip=GCLAVES" class="btn btn-default" role = "button">AVL.Est. Clave</a>
            <a href="Admin?tip=GCHOFERES" class="btn btn-default" role = "button">AVL. Choferes</a>
            <a href="Admin?tip=GBUSCHOFER" class="btn btn-default" role = "button">Bus de chofer</a>
            <a href="Admin?tip=GOTRA" class="btn btn-default" role = "button">Otra</a>
            
        </div>
            
        </div>    
        <%
                String path = (String)request.getAttribute("path");
                //if(path.equals(""))
                    
                
        %>
        <br>
        <%=path%>
        <IMG SRC="<%=path%>" ALT="GRAFICA">
        <%@include file="WEB-INF/jspf/bottom.jspf" %>
        
   

    <%-- end web service invocation --%><hr/>
    </body>
</html>

