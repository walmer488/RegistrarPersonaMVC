
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : mostrartodo
    Created on : 06-02-2020, 12:04:14 AM
    Author     : Guido
--%>
<%//Walmer Esteban
//Karla Vannesa%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   ç
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>

        <h1>Todos los registros</h1>
        <br>
        <a class="btn btn-success" href="index.jsp">Volver al formulario....</a>
        <hr>
        <c:forEach var="listatotal" items="${sessionScope.personas}">
            Dui:  ${listatotal.dui}<br>
            Apellidos: ${listatotal.apellidos}<br>
            Nombres:${listatotal.nombres}<br>
            <br>
            <a class="btn btn-warning" href="editar.do?dui=${listatotal.dui}">Editar</a>
             <a class = "btn  btn-danger" href="weliminar.do?dui=${listatotal.dui}">Eliminar Registro</a>
            <hr>
            
        </c:forEach>
 
</html>
