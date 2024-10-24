package com.AplicacionWebNominas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AplicacionWebNominas.conexion.Conexion;
import com.AplicacionWebNominas.model.Empleado;
import com.AplicacionWebNominas.model.Nomina;


public class EmpleadoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	
	
		public List<Empleado> obtenerEmpleado() throws SQLException {
			ResultSet resultSet = null;
			List<Empleado> listaEmpleados = new ArrayList<>();

			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();

			try {
				sql = "SELECT * FROM empleado";
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Empleado e = new Empleado();
					e.setNombre(resultSet.getString("nombre"));
					e.setDni(resultSet.getString("dni"));
					e.setSexo(resultSet.getString("sexo").charAt(0));
					e.setCategoria(resultSet.getInt("categoria"));
					e.setAnyos(resultSet.getInt("anyos"));
					
					listaEmpleados.add(e);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return listaEmpleados;
		}
	
		public Empleado obtenerEmpleado(String dni) throws SQLException {
		    ResultSet resultSet = null;
		    Empleado e = null;

		    String sql = "SELECT * FROM empleado WHERE dni = ?";
		    connection = obtenerConexion();
		    statement = connection.prepareStatement(sql);
		    statement.setString(1, dni);

		    resultSet = statement.executeQuery();

		    if (resultSet.next()) {
		        e = new Empleado();
		        e.setNombre(resultSet.getString("nombre"));
		        e.setDni(resultSet.getString("dni"));
		        e.setSexo(resultSet.getString("sexo").charAt(0));
		        e.setCategoria(resultSet.getInt("categoria"));
		        e.setAnyos(resultSet.getInt("anyos"));
		    }

		    return e; 
		}
		public List<Empleado> buscarEmpleadosPorDNI(String dni) throws SQLException {
		    List<Empleado> listaEmpleados = new ArrayList<>();
		    String sql = "SELECT * FROM empleado WHERE dni LIKE ?";
		    connection = obtenerConexion();
		    statement = connection.prepareStatement(sql);
		    statement.setString(1, "%" + dni + "%"); // Busca por coincidencias parciales

		    ResultSet resultSet = statement.executeQuery();
		    while (resultSet.next()) {
		        Empleado e = new Empleado();
		        e.setNombre(resultSet.getString("nombre"));
		        e.setDni(resultSet.getString("dni"));
		        e.setSexo(resultSet.getString("sexo").charAt(0));
		        e.setCategoria(resultSet.getInt("categoria"));
		        e.setAnyos(resultSet.getInt("anyos"));
		        listaEmpleados.add(e);
		    }

		    return listaEmpleados;
		}
		public List<Empleado> buscarEmpleadosPorCriterios(String criterio) throws SQLException {
		    List<Empleado> listaEmpleados = new ArrayList<>();
		    StringBuilder sql = new StringBuilder("SELECT * FROM empleado WHERE ");

		    sql.append("(dni LIKE ? OR ");
		    sql.append("nombre LIKE ? OR ");
		    sql.append("sexo LIKE ? OR ");
		    sql.append("categoria LIKE ? OR ");
		    sql.append("anyos LIKE ?)");

		    connection = obtenerConexion();
		    statement = connection.prepareStatement(sql.toString());

		    String searchParam = "%" + criterio + "%";
		    for (int i = 1; i <= 5; i++) {
		        statement.setString(i, searchParam);
		    }

		    ResultSet resultSet = statement.executeQuery();
		    while (resultSet.next()) {
		        Empleado e = new Empleado();
		        e.setNombre(resultSet.getString("nombre"));
		        e.setDni(resultSet.getString("dni"));
		        e.setSexo(resultSet.getString("sexo").charAt(0));
		        e.setCategoria(resultSet.getInt("categoria"));
		        e.setAnyos(resultSet.getInt("anyos"));
		        listaEmpleados.add(e);
		    }

		    return listaEmpleados;
		}

		public boolean actualizarEmpleado(Empleado empleado) throws SQLException {
		    String sql = null;
		    boolean estadoOperacion = false;
		    Connection connection = obtenerConexion();
		    PreparedStatement statement = null;

		    try {
		        connection.setAutoCommit(false);
		        sql = "UPDATE empleados SET nombre=?, sexo=?, categoria=?, anyos=? WHERE dni=?";
		        statement = connection.prepareStatement(sql);

		        statement.setString(1, empleado.getNombre());
		        statement.setString(2, String.valueOf(empleado.getSexo())); // Asumiendo que sexo es char
		        statement.setInt(3, empleado.getCategoria());
		        statement.setInt(4, empleado.getAnyos());
		        statement.setString(5, empleado.getDni());

		        estadoOperacion = statement.executeUpdate() > 0;

		        connection.commit();
		    } catch (SQLException e) {
		        if (connection != null) {
		            connection.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (statement != null) {
		            statement.close();
		        }
		        connection.close();
		    }

		    return estadoOperacion;
		}


	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
