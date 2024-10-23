<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.AplicacionWebNominas.model.Empleado"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultados de Búsqueda</title>
</head>
<body>
    <h1>Resultados de Búsqueda</h1>
    <%
        List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
        if (empleados != null && !empleados.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>DNI</th>
                <th>Sexo</th>
                <th>Categoría</th>
                <th>Años en la empresa</th>
            </tr>
            <%
            for (Empleado empleado : empleados) {
            %>
            <tr>
                <td><%= empleado.getNombre() %></td>
                <td><%= empleado.getDni() %></td>
                <td><%= empleado.getSexo() %></td>
                <td><%= empleado.getCategoria() %></td>
                <td><%= empleado.getAnyos() %></td>
            </tr>
            <%
            }
            %>
        </table>
    <%
        } else {
    %>
        <h3>No se encontraron empleados que coincidan con la búsqueda.</h3>
    <%
        }
    %>
    <a href="/Empresa">Volver</a>
</body>
</html>
