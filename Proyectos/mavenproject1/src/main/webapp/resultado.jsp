<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado</h1>
        <p>Tu usuario ha sido guardado con éxito, tu ID es: ${requestScope.usuario.idUsuario}</p> <br />
        <h2>Red social encontrada</h2>
        <h3>${requestScope.redSocial.nombre}</h3>
        <p>${requestScope.redSocial.descripcion}</p>
    </body>
</html>
