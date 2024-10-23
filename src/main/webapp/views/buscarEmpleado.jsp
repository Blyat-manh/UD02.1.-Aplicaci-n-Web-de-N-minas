<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Empleado</title>
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
</body>
</html>
