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
	DAOCalcul dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SumServlet() {
		super();
		dao = new DAOCalcul();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		String str = request.getParameter("id");
		if (str != null) {
			int id = Integer.parseInt(str);
			dao.deleteHistory(id);
		}

		String strPerm = request.getParameter("idPerm");
		if (strPerm != null) {
			int id = Integer.parseInt(strPerm);
			dao.updatePermalien(id);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String number = request.getParameter("number");
		String lastID = request.getParameter("id");
		// System.out.println(request.getParameter("email"));
		int id = 0;
		if (number != null && !number.isEmpty()) {
			Calcul c = new Calcul();

			c.setNum2(Integer.parseInt(number));
			if (lastID != null) {
				c.setLastCalcul(Integer.parseInt(lastID));
				int num1 = dao.getLastSumById(Integer.parseInt(lastID));
				c.setNum1(num1);

			} else {
				c.setNum1(0);
				c.setLastCalcul(0);
			}
			id = dao.addCalcul(c);
		}
		response.sendRedirect(request.getContextPath() + "/addition.jsp?id="
				+ id);
	}
}
