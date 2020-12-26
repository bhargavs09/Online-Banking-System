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
 * Servlet implementation class transfer
 */
@WebServlet("/transfer")
public class transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transfer() {
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
		int am,ma;
		String bal = null;
		String ba = null;
		ResultSet rs1,rs2;
		if((request.getParameter("anumber1") != null && !request.getParameter("anumber1").trim().isEmpty()) && (request.getParameter("anumber2") != null && !request.getParameter("anumber2").trim().isEmpty()) && (request.getParameter("amount")!=null && !request.getParameter("amount").trim().isEmpty())) {
		int num1 = Integer.parseInt(request.getParameter("anumber1"));
		int num2 = Integer.parseInt(request.getParameter("anumber2"));
		int amt = Integer.parseInt(request.getParameter("amount"));
		Connection con=DBcon.connect();
		try {
			PreparedStatement ps1 = con.prepareStatement("select balance from balance where accno='"+num2+"'");
			rs1 = ps1.executeQuery();
			while(rs1.next()) {
				bal = rs1.getString("balance");
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
			PreparedStatement ps2 = con.prepareStatement("select balance from balance where accno='"+num1+"'");
			rs2 = ps2.executeQuery();
			while(rs2.next()) {
				ba = rs2.getString("balance");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(ba == null) {
			 ma =  0;
		}
		else {
			 ma =  Integer.parseInt(ba) - amt -1;
		}
		try {
			PreparedStatement ps3 = con.prepareStatement("update balance set balance='"+am+"' where accno='"+num2+"'");
			ps3.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			response.getWriter().print("Amount Transaction Failed1");
		}
		try {
			PreparedStatement ps4 = con.prepareStatement("update balance set balance='"+ma+"' where accno='"+num1+"'");
			ps4.executeUpdate();
			response.setContentType("text/html");
			response.getWriter().print("Transaction Successful");
			response.getWriter().print("<body style='background-image:url(bp.jpg);font-size:x-large;margin-top:140px;text-align:center;'>");
			response.getWriter().print("<br><br><button onclick='window.location.href='welcome.html''>HOME </button>" );
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			response.getWriter().print("Amount Transaction Failed2");
		}
		}
		else {
			response.sendRedirect("welcome.html");
		}
	}

}
