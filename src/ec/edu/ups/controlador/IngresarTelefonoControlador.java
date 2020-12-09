package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Telefono;
import ec.edu.ups.entidad.TipoTelefono;
import ec.edu.ups.entidad.Usuario;

/**
 * Servlet implementation class IngresarTelefonoControlador
 */
@WebServlet("/IngresarTelefonoControlador")
public class IngresarTelefonoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telDAO;
	private TipoTelefonoDAO tipDAO;
	private UsuarioDAO usuDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarTelefonoControlador() {
    	telDAO = DAOFactory.getFactory().getTelefonoDAO();
    	tipDAO = DAOFactory.getFactory().getTipoTelefonoDAO();
    	usuDAO = DAOFactory.getFactory().getUsuarioDAO();
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
		
		String url, numero, operadora;
		TipoTelefono tt;
		Usuario us;
		Telefono tl;
		int tipo, usID;
		boolean flag=false;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = request.getSession(true);
		
		if(request.getParameter("numero").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("operadora").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if(request.getParameter("tipo").isEmpty()) {
			request.setAttribute("mensaje", "(!) Llene todos los campos");
			flag = true;
		}
		
		if (flag == false) {
			numero = request.getParameter("numero");
			tipo = Integer.valueOf(request.getParameter("tipo").toString());
			operadora = request.getParameter("operadora");
			usID = Integer.valueOf(session.getAttribute("id").toString());
			
			try {
				tt = tipDAO.read(tipo);
				us = usuDAO.read(usID);
				tl = new Telefono(numero, operadora, us, tt);
				
				telDAO.create(tl);
				
				request.setAttribute("mensaje", "Telefono ingresado exitosamente");
				url = "/JSP/ingresar_telefono.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				request.setAttribute("mensaje", "(!) Ha ocurrido un ERROR INTERNO");
				url="/JSP/ingresar_telefono.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			
		} else {
			url="/JSP/ingresar_telefono.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}
		
	}

}
