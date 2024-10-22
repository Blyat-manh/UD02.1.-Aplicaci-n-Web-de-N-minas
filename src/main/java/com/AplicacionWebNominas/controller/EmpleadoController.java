package com.AplicacionWebNominas.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AplicacionWebNominas.dao.EmpleadoDAO;
import com.AplicacionWebNominas.model.Empleado;

/**
 * Servlet implementation class EmpleadoController
 */
@WebServlet(description = "Administra peticiones para la tabla empleados", urlPatterns = { "/empresa" })
public class EmpleadoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if (opcion.equals("listar")) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            List<Empleado> lista = new ArrayList<>();
            try {
                lista = empleadoDAO.obtenerEmpleado();
                for( Empleado e : lista) {
                	System.out.println(e);
                }
                request.setAttribute("lista", lista);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Error al obtener la lista de empleados.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            }
            System.out.println("Usted ha presionado la opción listar");
        } else if (opcion.equals("salario")) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            List<Empleado> lista = new ArrayList<>();
            try {
                lista = empleadoDAO.obtenerEmpleado();
                for( Empleado e : lista) {
                	System.out.println(e);
                }
                request.setAttribute("lista", lista);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Error al obtener la lista de empleados.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            }
            System.out.println("Usted ha presionado la opción listar");
        } 
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement doPost logic if needed
    }
    
   
}