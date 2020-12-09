package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidad.Telefono;

/**
 * Servlet implementation class ListarUsuarioControlador
 */
@WebServlet("/ListarUsuarioControlador")
public class ListarUsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarUsuarioControlador() {
    	telDAO = DAOFactory.getFactory().getTelefonoDAO();
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
		
		String dir, url;
		Telefono t;
		boolean flag;
		
		List<Telefono> telefonos = new ArrayList<Telefono>();		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if (request.getParameter("buscar") != null) {
						
			if(request.getParameter("id").isEmpty()) {
				
				url = "/JSP/listar_usuario.jsp";
				request.setAttribute("mensaje", "(!) Llene todos los campos");
				getServletContext().getRequestDispatcher(url).forward(request, response);
			} else {
				
				url = "/UlloaBermeoIvan-Examen/BuscarUsuarioControlador";
				httpResponse.sendRedirect(url+"?id="+request.getParameter("id"));
			}
			
		} else if (request.getParameter("listar") != null) {
			try {
				
				telefonos = telDAO.find();
				
				request.setAttribute("lista", telefonos);
				url = "/JSP/listar_usuario.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			} catch (Exception e) {
				System.out.println("ERROR>> "+e.getMessage());
			}
		}
		
		
		
	}

}
