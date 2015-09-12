<%-- 
    Document   : admineditar
    Created on : 07-sep-2015, 19:05:16
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
                ADMIN EDITAR
       
        </div>
    <div class="content">
        
                
        <div class="divmenu">
        <div class="btn-group" role="group" aria-label="...">
            <% request.setAttribute("nombre",request.getAttribute("RESPUESTA"));
               //request.setAttribute("tip","1");
            %>
            <a href="Admin?tip=1" class="btn btn-default" role = "button">Administradores</a>
            <a href="Admin?tip=2" class="btn btn-default" role = "button">Est. Generales</a>
            <a href="Admin?tip=3" class="btn btn-default" role = "button">Est. Clave</a>
            <a href="Admin?tip=4" class="btn btn-default" role = "button">Buses</a>
            <a href="Admin?tip=5" class="btn btn-default" role = "button">Rutas</a>
            
        </div>
        </div>    
            <div>
                
                <form id="formcrearadmin" name="crearadmin" action="Admin?tip=crear" method="post">
                <div class="form-group">
                    <label for="inputEmail">Email</label>
                    <input type="text" class="form-control"  placeholder="ID" name="email">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Contraseña</label>
                    <input type="text" class="form-control" placeholder="Contraseña" name="pass">
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

