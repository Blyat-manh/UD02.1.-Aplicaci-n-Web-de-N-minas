<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultados de Búsqueda</title>
</head>
<body>
    <h2>Resultados de Búsqueda</h2>
    <table>
        <tr>
            <th>Nombre</th>
            <th>DNI</th>
            <th>Acción</th>
        </tr>
        <c:forEach var="empleado" items="${empleados}">
            <tr>
                <td>${empleado.nombre}</td>
                <td>${empleado.dni}</td>
                <td>
                    <a href="empresa?opcion=editar&dni=${empleado.dni}">Modificar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/Empresa">Volver</a>
</body>
</html>
