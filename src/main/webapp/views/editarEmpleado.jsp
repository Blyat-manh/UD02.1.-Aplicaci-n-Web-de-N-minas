<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Empleado</title>
</head>
<body>
    <h1>Editar Empleado</h1>
    <form action="empresa" method="post">
    <input type="hidden" name="opcion" value="actualizar">
    <input type="hidden" name="dni" value="${empleado.dni}">

    Nombre: <input type="text" name="nombre" value="${empleado.nombre}"><br>
    Sexo: <input type="text" name="sexo" value="${empleado.sexo}"><br>
    Categoría: <input type="number" name="categoria" value="${empleado.categoria}"><br>
    Años: <input type="number" name="anyos" value="${empleado.anyos}"><br>

    <input type="submit" value="Guardar Cambios">
</form>

</body>
</html>
