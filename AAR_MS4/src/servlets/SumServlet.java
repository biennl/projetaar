package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOCalcul;
import domain.Calcul;

/**
 * Servlet implementation class SumServlet
 */
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<Double> numbers = new ArrayList<Double>();
	int value = 0;
	int index = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SumServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath() + request.getServletPath()
				+ request.getPathInfo());
		request.setAttribute("id", 0);
		String url = (String) request.getAttribute("url");
		System.out.println(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("name");
		DAOCalcul dao = new DAOCalcul();
		int id = 0;
		if (number != null && !number.isEmpty()) {
			Calcul c = new Calcul();
			c.setNum1(value);
			c.setNum2(Integer.parseInt(number));
			value += Integer.parseInt(number);
			c.setIdSession(request.getSession().getId());
			id = dao.addCalcul(c);
		}
		response.sendRedirect(request.getContextPath() + "/addition.jsp?id="
				+ id);
		// RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		// System.out.println(url);
		// request.setAttribute("id", value);
		// dispatcher.include(request, response);
	}
}
