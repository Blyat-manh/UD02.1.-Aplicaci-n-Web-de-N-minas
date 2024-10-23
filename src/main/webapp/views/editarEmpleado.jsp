<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
</head>
<body>
    <h2>Editar Empleado</h2>
    <form action="empresa" method="post">
    <input type="hidden" name="opcion" value="actualizar">
    <input type="hidden" name="dni" value="${empleado.dni}">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" value="${empleado.nombre}" required>
    <label for="sexo">Sexo:</label>
    <input type="text" id="sexo" name="sexo" value="${empleado.sexo}" required>
    <label for="categoria">Categoría:</label>
    <input type="text" id="categoria" name="categoria" value="${empleado.categoria}" required>
    <label for="anyos">Años en la Empresa:</label>
    <input type="text" id="anyos" name="anyos" value="${empleado.anyos}" required>
    <input type="submit" value="Guardar Cambios">
</form>

    <a href="/Empresa">Volver</a>
</body>
</html>
