<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Empleado</title>
</head>
<body>
    <h2>Buscar Empleado</h2>
    <form action="empresa" method="post">
    <input type="hidden" name="opcion" value="buscar">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" placeholder="Nombre parcial">
    <label for="dni">DNI:</label>
    <input type="text" id="dni" name="dni" placeholder="DNI parcial">
    <label for="categoria">Categoría:</label>
    <input type="text" id="categoria" name="categoria" placeholder="Categoría">
    <input type="submit" value="Buscar">
</form>

    <a href="/Empresa">Volver</a>
</body>
</html>
