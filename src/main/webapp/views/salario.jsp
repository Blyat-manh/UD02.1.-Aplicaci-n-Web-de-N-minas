<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Salario Empleado</title>
</head>
<body>
    <h2>Buscar Empleado por DNI</h2>
    <form action="empresa" method="post">
    <input type="hidden" name="opcion" value="buscar" />
    <label for="dni">DNI:</label>
    <input type="text" id="dni" name="dni" required>
    <input type="submit" value="Buscar">
</form>
    <a href="/Empresa">Volver</a>
</body>
</html>
