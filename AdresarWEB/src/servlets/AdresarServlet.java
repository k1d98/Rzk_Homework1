package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rzk.Adresar;

/**
 * Servlet implementation class AdresarServlet
 */
@WebServlet("/AdresarServlet")
public class AdresarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private Adresar adr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdresarServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String result = "";
		if(request.getParameter("ime") != null) {
			result = adr.vratiAdresu(request.getParameter("ime"));
		}
		request.setAttribute("result", result);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
