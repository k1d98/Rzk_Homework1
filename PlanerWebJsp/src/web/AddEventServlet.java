package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import rzk.AccountBeanRemote;
import rzk.PlannerBeanRemote;

/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlannerBeanRemote bean = (PlannerBeanRemote) request.getSession().getAttribute("bean");
		//da li ovo treba svaki put da se radi?
		if (bean == null) {
			try {
				InitialContext ic = new InitialContext();
				bean = (PlannerBeanRemote) ic
						.lookup("ejb:PlanerEAR/PlanerEJB/PlannerBean!rzk.PlannerBeanRemote?stateful");

				request.getSession().setAttribute("bean", bean);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("eventTypes", bean.getTypes());
		
		
		request.getRequestDispatcher("addEvent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlannerBeanRemote bean = (PlannerBeanRemote) request.getSession().getAttribute("bean");
		String description = request.getParameter("description");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String date = request.getParameter("datum");
		String fromDateS = request.getParameter("fromDate");
		String toDateS = request.getParameter("toDate");
		int eventType = Integer.valueOf(request.getParameter("eventType"));
		
		Date fromDate, toDate;
		try {
			fromDate = df.parse(date+" "+fromDateS);
			toDate = df.parse(date+" "+toDateS);
			boolean rez = bean.createEvent(description, fromDate, toDate, eventType);
			if(rez) {
				request.getRequestDispatcher("listEvents.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(fromDateS+" "+date);
			request.getRequestDispatcher("listEvents.jsp").forward(request, response);
		}
		
		
	}

}
