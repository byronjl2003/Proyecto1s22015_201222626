<%-- 
    Document   : generaleditar
    Created on : 16-sep-2015, 16:58:35
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
            <% request.setAttribute("nombre",request.getAttribute("RESPUESTA"));
               //request.setAttribute("tip","1");
            %>
            <a href="Admin?tip=ADMIN" class="btn btn-default" role = "button">Administradores</a>
            <a href="Admin?tip=GENERAL" class="btn btn-default" role = "button">Est. Generales</a>
            <a href="Admin?tip=CLAVE" class="btn btn-default" role = "button">Est. Clave</a>
            <a href="Admin?tip=BUS" class="btn btn-default" role = "button">Buses</a>
            <a href="Admin?tip=RUTA" class="btn btn-default" role = "button">Rutas</a>
            <a href="Admin?tip=GRAFICA" class="btn btn-default" role = "button">Graficas</a>
            
        </div>
        </div>    
            <div>
                
                <form id="formcrearadmin" name="crearadmin" action="Admin?tip=crear" method="post">
                <div class="form-group">
                    <label for="inputEmail">EMAIL:</label>
                    <input type="text" class="form-control"  placeholder="<%=request.getAttribute("id")%>" name="email">
                </div>
                <div class="form-group">
                    <label for="inputPassword">PASS:</label>
                    <input type="text" class="form-control" placeholder="<%=request.getAttribute("pass")%>" name="pass">
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


