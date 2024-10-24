<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Empleados</title>
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
 <h1>Listar Empleados</h1>
 <table border="1">
  <tr>
   <th>Nombre</th>
   <th>DNI</th>
   <th>Sexo</th>
   <th>Categoria</th>
   <th>Años</th>

  </tr>
  <c:forEach var="e" items="${lista}">
  <tr>
  	<td><c:out value="${ e.nombre}"></c:out></td>
    <td><c:out value="${ e.dni}"></c:out></td>
    <td><c:out value="${ e.sexo}"></c:out></td>
    <td><c:out value="${ e.categoria}"></c:out></td>
    <td><c:out value="${ e.anyos}"></c:out></td>  
  </tr>
  </c:forEach>
 </table>
 <a href="/Empresa">Volver</a>
</body>
</html>
