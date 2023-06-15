<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" href="resources/css/estilos.css" />
    </head>
    <body>
        <h1>Resultado</h1>
        <c:forEach items="#{requestScope.resultadoFinal}" var="resultado">
            <h2>${resultado.nombre}</h2>
            <img src=${resultado.ruta} alt=${resultado.ruta} width=auto height="400px">
            <p>${resultado.descripcion}</p>
            <p>Se ha guardado con exito tu recomendacion!!</p> <br/>
        </c:forEach>
    </body>
</html>
