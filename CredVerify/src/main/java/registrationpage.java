

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
 * Servlet implementation class registrationpage
 */
public class registrationpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationpage() {
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
		
		PrintWriter out = response.getWriter();

		out.println("<html><body style = 'background-color: cyan'>");
		out.println("<div style=\"text-align:center\">");
		out.println("<h1>Registration Page</h1>");
		
		String username = request.getParameter("usernamereg");
		String password = request.getParameter("passwordreg");
		if(!username.equals("") && !password.equals("")) 
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			//@todo make the below stuff actually add to the table 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
			Statement st=conn.createStatement();
			
				if(!inTable(st,username)) 
				{
					response.getWriter().println("Successfully created new account with username " + username);
					st.executeUpdate("use phase2");
					int i=st.executeUpdate("insert into phase2.users(username,pw)values('"+username+"','"+password+"')");
					out.println("<br> <br>Click <a href=\"login\">here</a> to login to your account.");
				}
				else
				{
					out.println("Error: username already exists <br><br>");
					out.println("Click <a href=\"register\">here</a> to return to the registration page");
					return;
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
				e.printStackTrace();
			}
		}
		else
		{
			out.println("Error: Username or password cannot be empty");
		}
		out.println("</div>");
		out.println("</body></html>");
	}
	
	public boolean inTable(Statement st, String username)
	{
		try 
		{
			st.executeUpdate("use phase2");
			ResultSet rs = st.executeQuery("select * from users where username='"+username+"'");
			return(rs.next());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
