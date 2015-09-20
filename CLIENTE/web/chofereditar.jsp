<%-- 
    Document   : chofereditar
    Created on : 20-sep-2015, 14:41:40
    Author     : byron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file = "WEB-INF/jspf/jscss.jspf" %>
        <% String answer;%>
        <title>PROYECTO1 EDD</title>
    </head>
    <body>
        <% String nombre;%>
        
        
        
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
        </div>    
            <div>
                
                <form id="formeditarclave" name="editarclave" action="Admin?tip=editarclave&old=<%=request.getAttribute("id")%>" method="post">
                <div class="form-group">
                    <label for="inputEmail">ID:</label>
                    <input type="text" class="form-control"  placeholder="<%=request.getAttribute("id")%>" name="id">
                </div>
                <div class="form-group">
                    <label for="inputPassword">PASS:</label>
                    <input type="text" class="form-control" placeholder="<%=request.getAttribute("pass")%>" name="pass">
                </div>
                <div class="form-group">
                    <label for="inputPassword">NOMBRE:</label>
                    <input type="text" class="form-control" placeholder="<%=request.getAttribute("nombre")%>" name="nombre">
                </div>
                <div class="form-group">
                    <label for="inputPassword">APELLIDO:</label>
                    <input type="text" class="form-control" placeholder="<%=request.getAttribute("apellido")%>" name="nombre">
                </div>
                
                
                <br>
                <%
                    
                    if(request.getAttribute("RESP")==null)
                        answer = "";
                    else
                       answer = (String)request.getAttribute("RESP");
                
                %>
                <label for="inputEmail"><%=answer%></label>
                <br>
                <br>
                <button type="submit" class="btn btn-primary">Crear</button>
            </form>
                
                
            </div>
        <br>
        
        <%@include file="WEB-INF/jspf/bottom.jspf" %>
        
   

    <%-- end web service invocation --%><hr/>
    </body>
</html>
