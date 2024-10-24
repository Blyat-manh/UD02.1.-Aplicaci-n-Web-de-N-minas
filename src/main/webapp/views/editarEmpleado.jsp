<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Empleado</title>
    <style type="text/css">
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

        h1 {
            color: cadetblue;
            margin: 20px 0;
            font-size: 2.5em;
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

        a {
            color: cadetblue;
            text-decoration: none;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <h1>Editar Empleado</h1>
    <form action="empresa" method="post">
        <input type="hidden" name="opcion" value="actualizar">
        <input type="hidden" name="dni" value="${empleado.dni}">

        <table style="margin: 0 auto;">
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombre" value="${empleado.nombre}" required></td>
            </tr>
            <tr>
                <td>Sexo:</td>
                <td><input type="text" name="sexo" value="${empleado.sexo}" required></td>
            </tr>
            <tr>
                <td>Categoría:</td>
                <td><input type="number" name="categoria" value="${empleado.categoria}" required></td>
            </tr>
            <tr>
                <td>Años:</td>
                <td><input type="number" name="anyos" value="${empleado.anyos}" required></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Actualizar">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
