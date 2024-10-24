<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Empleado</title>
    <style>
    
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    color: #333;
    text-align: center;
}

nav {
    background-color: #3498db;
    padding: 10px 0;
    margin-bottom: 20px;
}

nav a {
    color: white;
    text-decoration: none;
    margin: 0 15px;
    font-weight: bold;
}

h1 {
    color: cadetblue;
    margin: 20px 0;
    font-size: 2.5em;
}

.table-container {
    display: flex;
    justify-content: center;
    margin: 20px 0;
}

table {
    border-collapse: collapse;
    width: 100%;
    max-width: 800px;
    margin: 0 auto;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
    background-color: white;
}

table th, table td {
    padding: 15px;
    text-align: left;
}

table th {
    background-color: rgb(95, 158, 160);
    color: white;
    font-size: 1.2em;
}

table tr:nth-child(even) {
    background-color: #f2f2f2;
}

table tr:hover {
    background-color: #d1ecf1;
}

table td {
    border-bottom: 1px solid #ddd;
}

a {
    color: cadetblue;
    text-decoration: none;
    font-size: 20px;
    margin-top: 50px;
}

a.pagination {
    display: inline-block;
    margin: 20px 0;
    padding: 10px 20px;
    border: 2px solid #3498db;
    border-radius: 5px;
    background-color: white;
    color: #3498db;
    font-size: 18px;
    transition: background-color 0.3s, color 0.3s;
}

a.pagination:hover {
    background-color: #3498db;
    color: white;
    cursor: pointer;
}
  
    </style>
</head>
<body>
    <h1>Buscar Empleado</h1>
    <form action="empresa" method="post">
        <input type="text" name="criterio" placeholder="Buscar por DNI, Nombre o Categoría" required />
        <input type="hidden" name="opcion" value="ebuscar" />
        <input type="submit" value="Buscar" />
    </form>

    <c:if test="${not empty empleados}">
        <h2>Resultados de la Búsqueda</h2>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>DNI</th>
                <th>Sexo</th>
                <th>Categoría</th>
                <th>Años</th>
                <th>Acciones</th>
            </tr>
            <c:forEach var="empleado" items="${empleados}">
                <tr>
                    <td><c:out value="${empleado.nombre}"/></td>
                    <td><c:out value="${empleado.dni}"/></td>
                    <td><c:out value="${empleado.sexo}"/></td>
                    <td><c:out value="${empleado.categoria}"/></td>
                    <td><c:out value="${empleado.anyos}"/></td>
                    <td>
                        <form action="empresa" method="post">
                            <input type="hidden" name="opcion" value="editar">
                            <input type="hidden" name="dni" value="${empleado.dni}">
                            <input type="submit" value="Editar">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    
    <c:if test="${empty empleados}">
        <p>No se encontraron empleados.</p>
    </c:if>
    <a href="/Empresa">Volver</a>
</body>
</html>
