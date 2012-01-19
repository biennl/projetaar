package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCalcul;
import domain.Calcul;

/**
 * Servlet implementation class SumServlet
 */
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<Double> numbers = new ArrayList<Double>();
	int value = 0;
	String idSession = "";

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

		String id = request.getParameter("id");
		response.sendRedirect(request.getContextPath() + "/addition.jsp?id="
				+ id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String number = request.getParameter("number");
		DAOCalcul dao = new DAOCalcul();
		int id = 0;
		if (!idSession.equals(request.getSession().getId())) {
			value = 0;
			idSession = request.getSession().getId();
		}
		if (number != null && !number.isEmpty()) {
			Calcul c = new Calcul();
			c.setNum1(value);
			c.setNum2(Integer.parseInt(number));
			value += Integer.parseInt(number);
			c.setIdSession(idSession);
			id = dao.addCalcul(c);
		}
		response.sendRedirect(request.getContextPath() + "/addition.jsp?id="
				+ id);
	}
}
