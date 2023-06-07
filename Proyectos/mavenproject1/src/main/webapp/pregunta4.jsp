<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pregunta</title>
    </head>
    <body>
        <h1>Con que funcionalidades te identificas?</h1>
        <form action="Resultado" method="POST">
            <c:forEach items="${requestScope.funcionalidades}" var="opcion">
                <input type="radio" name="funcion" value="${opcion}" id="${opcion}" required="true"/>
                <label for="${opcion}">${opcion}</label>
                <br/>
                <br/>
            </c:forEach>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
