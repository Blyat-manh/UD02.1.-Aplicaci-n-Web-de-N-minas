package com.AplicacionWebNominas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AplicacionWebNominas.conexion.Conexion;
import com.AplicacionWebNominas.model.Empleado;


public class EmpleadoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	
	// obtener lista de productos
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
	
		public Empleado obtenerSalario(int dni) throws SQLException {
			ResultSet resultSet = null;
			Empleado e = new Empleado();

			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();

			try {
				sql = "SELECT categoria, anyos FROM empleado WHERE dni =?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, dni);

				resultSet = statement.executeQuery();

				if (resultSet.next()) {
					
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			return e;
		}
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
