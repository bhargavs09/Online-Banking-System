package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBconnection.DBcon;

/**
 * Servlet implementation class adds
 */

@WebServlet("/adds")
public class adds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adds() {
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
		Connection con=DBcon.connect();
		
		if(request.getParameter("anum")!=null && !request.getParameter("anum").trim().isEmpty()) {
		int nu = Integer.parseInt(request.getParameter("anum"));
		String pro = null;
		try {
			
			response.setContentType("text/html");
			PreparedStatement ps = con.prepareStatement("select balance from balance where accno='"+nu+"'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 pro = rs.getString("balance");
			}
			//response.getWriter().print("var a=pro";);
			//String Message="The account  '"+request.getParameter("anum")+"' balance is :" + pro;
			//response.getWriter().print("<html><body>");
			//response.getWriter().print("<script type=\"text/javascript\">alert(" + mom + ");</script>");
			//response.getWriter().print("</body></html>");
			response.getWriter().print("The account  '"+request.getParameter("anum")+"' balance is :" + pro);
			response.getWriter().print("<body style='background-image:url(bp.jpg);font-size:x-large;margin-top:140px;text-align:center;'>");
			response.getWriter().print("<br><br><button onclick='window.location.href='welcome.html''>HOME </button>" );
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		else {
			response.sendRedirect("welcome.html");
		}
	}

}
