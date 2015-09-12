<%-- 
    Document   : index
    Created on : 02-sep-2015, 21:32:11
    Author     : byron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=utf-8">
        <%@include file = "WEB-INF/jspf/jscss.jspf" %>
        <title>PROYECTO1 EDD</title>
    </head>
    <body>
        
        <%@include file="WEB-INF/jspf/top.jspf" %>
        <%! String resp;%>
        
        
        
        <%--     --%>
        
        <div class="divformindex">
            
            <form id="formloguin" name="loguin" action="Index" method="post">
                <div class="form-group">
                    <label for="inputEmail">Email</label>
                    <input type="text" class="form-control"  placeholder="ID" name="id">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Contraseña</label>
                    <input type="password" class="form-control" placeholder="Contraseña" name="pass">
                </div>
                
                <div>
                    <select name="tipo">
                        <option value="SUPER">SUPER</option>
                        <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                        <option value="CHOFER">CHOFER</option>
                        <option value="GENERAL">GENERAL</option>
                        <option value="CLAVE">CLAVE</option>
                    </select>
                </div>
                <br>
                <%
                    
                    if(request.getAttribute("RESPUESTA")==null)
                        resp = "";
                    else
                       resp = (String)request.getAttribute("RESPUESTA");
                
                %>
                <label for="inputEmail"><%=resp%></label>
                <br>
                <br>
                <button type="submit" class="btn btn-primary">Entrar</button>
            </form>
            
        </div>
        
        
        
        <%@include file="WEB-INF/jspf/bottom.jspf" %>
        
   

    <%-- end web service invocation --%><hr/>
    </body>
</html>
