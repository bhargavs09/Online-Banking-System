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
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
		if((request.getParameter("anumber") != null && !request.getParameter("anumber").trim().isEmpty()) && (request.getParameter("amount")!=null && !request.getParameter("amount").trim().isEmpty())) {
		int num = Integer.parseInt(request.getParameter("anumber"));
		int amt =  Integer.parseInt(request.getParameter("amount"));
		ResultSet rs  ;
		int am;
		String bal = null;
		try {
			PreparedStatement ps = con.prepareStatement("select balance from balance where accno='"+num+"'");
			rs = ps.executeQuery();
			while(rs.next()) {
				bal = rs.getString("balance");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(bal == null) {
			 am = amt + 0;
		}
		else {
			 am = amt + Integer.parseInt(bal);
		}
		try {
			PreparedStatement pst = con.prepareStatement("update balance set balance='"+am+"' where accno='"+num+"'");
			
			
			pst.executeUpdate();
			response.setContentType("text/html");
			//String Message="Transaction Succesful";
			//response.getWriter().print("<html>");
			//response.getWriter().print("<script type=\"text/javascript\">alert(" + Message + ");</script>");
			//response.getWriter().print("</html>");
			response.getWriter().print("Transaction Successful");
			response.getWriter().print("<body style='background-image:url(bp.jpg);font-size:x-large;margin-top:140px;text-align:center;'>");
			response.getWriter().print("<br><br><button onclick='window.location.href='welcome.html''>HOME </button>" );
			//response.sendRedirect("welcome.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().print("Amount Transaction Failed");
		}
	}
		
			else {
				response.sendRedirect("welcome.html");
			}
		
	}
}
