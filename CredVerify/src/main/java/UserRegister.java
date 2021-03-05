

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();

		out.println("<html><body style = 'background-color: cyan'>");
		out.println("<div style=\"text-align:center\">");
		out.println("<h1>User Registration</h1>");
		out.println("<form action=\"registration\" method=\"post\">\n <br>"
				+ "    Username: <input type=\"text\" class=\"form-control\" id=\"username\" placeholder=\"User Name\" name=\"usernamereg\" required>\n <br> <br>"
				+ "    Password: <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Password\" name=\"passwordreg\" required>\n <br> <br>"
				+ "   <button type=\"submit\">Register</button>\n"
				+ "</form>");
		out.println("</div>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
