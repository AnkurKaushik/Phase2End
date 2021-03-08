

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dashboard
 */
public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboard() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		out.println("<html><body style = 'background-color: cyan'>");
		out.println("<div style=\"text-align:center\">");
		out.println("<h1>Dashboard</h1>");
		
		Connection conn;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
			Statement st=conn.createStatement();
			st.executeUpdate("use phase2");
			ResultSet rs = st.executeQuery("select * from users where username='"+username+"' and pw='"+password+"'" );
			if(rs.next())
			{
				out.println("<html><head></head><body onload=\"alert('You have successfully logged in!')\"></body></html>");
				out.println("<h2>Welcome "+username+"</h2>");
				out.println("<br> <br>Click <a href=\"http://localhost:8080/CredVerify/\">here</a> to logout.");
			}
			else
			{
				out.println("<br>Error: username or password does not match records");
				out.println("<br> <br>Click <a href=\"login\">here</a> to try to login again.");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		out.println("</div>");
		out.println("</body></html>");
	}

}
