<%-- 
    Document   : adminver
    Created on : 07-sep-2015, 19:03:37
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
        
        
        
        
        <div>
            <div class="header">
                <%=request.getAttribute("nombre") %>
       
            </div>
    <div class="content">
        
                
        <div class="divmenu">
        <div class="btn-group" role="group" aria-label="...">
            <a href="Admin?tip=1" class="btn btn-default" role = "button">Administradores</a>
            <a href="<%=request.getContextPath()%>/Index" class="btn btn-default" role = "button">Est. Generales</a>
            <a href="<%=request.getContextPath()%>/Index" class="btn btn-default" role = "button">Est. Clave</a>
            <a href="<%=request.getContextPath()%>/Index" class="btn btn-default" role = "button">Buses</a>
            <a href="<%=request.getContextPath()%>/Index" class="btn btn-default" role = "button">Rutas</a>
            
        </div>
            
        <br>
        <br>
        <br>
            <a href="Admin?tip=4" class="btn btn-default" role = "button">Nuevo</a>
        <br>
        <br>
        <table class="table table-striped">
      <thead>
        <tr>
          <th>#</th>
          <th>Email</th>
          <th>Password</th>
          <th></th>
          <th>
        </tr>
      </thead>
      <tbody>
          <%    String params = (String)request.getAttribute("admins");
                String[] admins = params.split("]");
                for(int i=0;i<admins.length;i++)
                {
                    String[]info = admins[i].split(",");
                
          %>
        <tr>
          <th scope="row"><%=i+1%></th>
          <td> <%=info[0]%> </td>
          <td><%=info[1]%></td>
          <td>
              <a href="Admin?tip=2&id=<%=info[0]%>" class="btn btn-default" role = "button">Editar</a>
              <a href="Admin?tip=3&id=<%=info[0]%>" class="btn btn-default" role = "button">Eliminar</a>
          </td>
          <% }%>
      </tbody>
    </table>
        
        
        
        
        
        
        
        <%@include file="WEB-INF/jspf/bottom.jspf" %>
        
   

    <%-- end web service invocation --%><hr/>
    </body>
</html>