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
import com.AplicacionWebNominas.model.Nomina;

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
            String dni = request.getParameter("dni");
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();

            try {
                Empleado empleado = empleadoDAO.obtenerEmpleado(dni); 
                Nomina nomina = new Nomina();
                int salario = (empleado != null) ? nomina.sueldo(empleado) : 0;

                request.setAttribute("empleado", empleado);
                request.setAttribute("salario", salario);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/salario.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Error al obtener el empleado.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if (opcion.equals("editar")) {
            String dni = request.getParameter("dni");
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();

            try {
                Empleado empleado = empleadoDAO.obtenerEmpleado(dni);
                request.setAttribute("empleado", empleado);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editarEmpleado.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Error al obtener el empleado.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            }
            }
        }
                
        	  
    
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String dni = request.getParameter("dni");
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = new ArrayList<>();

        try {
            empleados = empleadoDAO.buscarEmpleadosPorDNI(dni); 
            
            request.setAttribute("empleados", empleados);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/procesarBusqueda.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error al obtener los empleados.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    }