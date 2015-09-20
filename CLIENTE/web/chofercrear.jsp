<%-- 
    Document   : chofercrear
    Created on : 20-sep-2015, 14:41:15
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
                CREAR CHOFER
       
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
                
                <form id="formcrearadmin" name="crearchofer" action="Admin?tip=crearchofer" method="post">
                <div class="form-group">
                    <label for="inputID">ID</label>
                    <input type="text" class="form-control"  placeholder="ID" name="id">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Contraseña</label>
                    <input type="text" class="form-control" placeholder="Contraseña" name="pass">
                </div>
                <div class="form-group">
                    <label for="inputNombre">Nombre</label>
                    <input type="text" class="form-control" placeholder="Nombre" name="nombre">
                </div>
                    <div class="form-group">
                    <label for="inputNombre">Apellido</label>
                    <input type="text" class="form-control" placeholder="Apellido" name="apellido">
                </div>
                
                
                <br>
                <%
                    
                    if(request.getAttribute("RESP")==null)
                        answer = "";
                    else
                       answer = (String)request.getAttribute("RESP");
                
                %>
                <label for="resp"><%=answer%></label>
                <br>
                <br>
                <button type="submit" class="btn btn-primary">Crear</button>
            </form>
                
                
            </div>
        <br>
        
        <%@include file="WEB-INF/jspf/bottom.jspf" %>
     
   

    

    </body>
    
</html>



