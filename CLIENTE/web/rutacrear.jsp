<%-- 
    Document   : rutacrear
    Created on : 20-sep-2015, 9:57:47
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
       
        
        
        
        <div>
            <div class="header">
                CREAR RUTAS
       
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
                
                <form id="formcrearruta" name="crearruta" action="Admin?tip=crearruta" method="post">
                <div class="form-group">
                    <label for="inputID">NOMBRE</label>
                    <input type="text" class="form-control"  placeholder="NOMBRE" name="nombre">
                </div>
                
                    
                    <select multiple class="form-control" name="selectclaves">
                        <% 
                            String claves =  (String)request.getAttribute("claves");
                            if(claves.equals(""))
                            {
              
                            }
                            else
                            {
                                String[] admins = claves.split("]");
                                for(int i=0;i<admins.length;i++)
                                {
                                    String[]info = admins[i].split(",");
                        
                        %>
                        <option><%=info[0]%>,<%=info[2]%></option>
                        <% }
                           }
                        %>
  
                </select>
                        
                        <select multiple class="form-control" name="selectgenerales">
                        <% 
                            String gens =  (String)request.getAttribute("generales");
                            if(gens.equals(""))
                            {
              
                            }
                            else
                            {
                                String[] admins = gens.split("]");
                                for(int i=0;i<admins.length;i++)
                                {
                                    String[]info = admins[i].split(",");
                        
                        %>
                        <option><%=info[0]%>,<%=info[2]%></option>
                        <% }
                           }
                        %>
  
                </select>
                    
                
                
                    
                    
                    
                    
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



