package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Usuario;

/**
 * Servlet implementation class CrearUsuarioControlador
 */
@WebServlet("/CrearUsuarioControlador")
public class CrearUsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuarioControlador() {
    	usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url, cedula, nombres, apellidos, correo;
		Usuario us;
		boolean flag=false;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if(request.getParameter("nombre").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("apellido").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("cedula").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("correo").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(flag==false) {
			
			nombres = request.getParameter("nombre");
			apellidos = request.getParameter("apellido");
			cedula = request.getParameter("cedula");
			correo = request.getParameter("correo");	
						
			try {
				
				us = new Usuario(cedula, nombres, apellidos, correo);
				usuarioDAO.create(us);
				
				url = "/UlloaBermeoIvan-Examen/JSP/ingresar_telefono.jsp";
				httpResponse.sendRedirect(url);
				
			} catch (Exception e) {
				request.setAttribute("mensaje", "(!) Ha ocurrido un ERROR INTERNO");
				url="/JSP/ingresar_usuario.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			
		} else {
			
			url="/JSP/ingresar_usuario.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}
		
		
	}

}
