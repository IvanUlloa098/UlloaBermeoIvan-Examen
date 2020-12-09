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
 * Servlet implementation class BuscarUsuarioControlador
 */
@WebServlet("/BuscarUsuarioControlador")
public class BuscarUsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuarioControlador() {
    	telDAO = DAOFactory.getFactory().getTelefonoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url, parametro;
		Telefono t;
		
		List<Telefono> telefonos = new ArrayList<Telefono>();
		parametro = request.getParameter("id").toString();
		
		try {
			telefonos = telDAO.find_ced(parametro);
			
			if (telefonos.isEmpty()) {
				telefonos = telDAO.find_telefono(parametro);
			}
			
			request.setAttribute("lista", telefonos);
			url = "/JSP/listar_usuario.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		} catch (Exception e) {
			System.out.println("ERROR>> "+e.getMessage());
			request.setAttribute("mensaje", "(!) Ha ocurrido un ERROR INTERNO");
			url = "/JSP/listar_usuario.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
