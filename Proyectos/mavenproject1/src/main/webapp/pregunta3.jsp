<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pregunta</title>
        <link rel="stylesheet" href="resources/css/estilos.css" />
    </head>
    <body>
        <h1>Con que enfoque te identificas?</h1>
        <form action="Pregunta4" method="POST">
            <c:forEach items="${requestScope.enfoques}" var="opcion">
                <input type="radio" name="enfoque" value="${opcion}" id="${opcion}" required="true"/>
                <label for="${opcion}">${opcion}</label>
                <br/>
                <br/>
            </c:forEach>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
