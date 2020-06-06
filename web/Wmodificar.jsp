<%-- 
    Document   : editar
    Created on : 06-03-2020, 10:35:58 PM
    Author     : Guido
--%>
<%//Walmer Esteban
//Karla Vannesa%>
<%@page import="modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
     <body>
         <% 
           
           String id = (String)request.getAttribute("pdui");
           Persona person = new Persona();
           Persona p=(Persona)person.list(id);
           
         %>
         
        <div class="container">
            <div  class="col-lg-6" >
        <h1 class="" >Editar persona</h1>
        <form action="wActualizar.do" method="POST" >
            <input type="hidden" value="<%= p.getDui() %>" name="txtDui" />
            Apellidos: <input class="form-control" type="text" name="txtApellidos" value="<%= p.getApellidos() %>" required /><br>
            Nombres: <input class="form-control" type="text" name="txtNombres" value="<%= p.getNombres() %>"  required /><br>
            <input class="btn btn-success" type="submit" value="Actualizar registro" />
            
        </form>
            
        </div>
        </div>
    </body>
</html>
