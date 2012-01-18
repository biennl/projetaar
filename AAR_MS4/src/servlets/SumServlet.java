package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Calcul;

/**
 * Servlet implementation class SumServlet
 */
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<Double> numbers = new ArrayList<Double>();

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("number");

		if (number != null && !number.isEmpty()) {

			double value = Double.parseDouble(number);

			numbers.add(value);
			index = numbers.size();
		}

		response.encodeURL("");
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("pages/addition.jsp?id=\"1\"");
		// request.getContextPath();
		// request

		HttpSession session = request.getSession();
		session.setAttribute("numbers", listToString(session, numbers));
		session.setAttribute("resultat", Calcul.sommeDeList(numbers));
		dispatcher.forward(request, response);
		// } else {
		// response.sendRedirect("Sum");
		// }
	}

	public String listToString(HttpSession session, ArrayList<Double> list) {

		String res = (String) session.getAttribute("numbers");
		res = "&nbsp;&nbsp;&nbsp;";
		res += list.get(0);
		for (int i = 1; i < list.size(); i++) {
			res += "<br/>+ " + list.get(i).toString();
		}

		return res;
	}

}
