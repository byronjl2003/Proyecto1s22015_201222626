<%-- 
    Document   : busver
    Created on : 20-sep-2015, 8:22:10
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
                BUSES
       
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
            <a href="Admin?tip=BUSCREAR" class="btn btn-default" role = "button">Nuevo</a>
        <br>
        <br>
        <table class="table table-striped">
      <thead>
        <tr>
          
          <th>ID BUS</th>
          <th>PERSONAS</th>
          <th></th>
          
        </tr>
      </thead>
      <tbody>
          <%String params =  (String)request.getAttribute("buses");
          if(params.equals(""))
          {
              
          }
          else
          {
              String[] bu = params.split("]");
                for(int i=0;i<bu.length;i++)
                {
                    String[] buses = bu[i].split(",");
                
          
          
          %>
          <%     
                
                
          %>
        <tr>
          
          <td> <%=buses[0]%></td>
          <td> <%=buses[1]%></td>
          <td>
              <a href="Admin?tip=BUSELIMINAR&id=<%=buses[i]%>" class="btn btn-default" role = "button">Eliminar</a>
          </td>
          <% }
             }
          %>
      </tbody>
    </table>
        
        
        
        
        
        
        
        <%@include file="WEB-INF/jspf/bottom.jspf" %>
        
   

    <%-- end web service invocation --%><hr/>
    </body>
</html>

