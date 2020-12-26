package servlets;
import Daoclass.sinDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beanclass.si;
import myinterface.Myinterface;
/**
 * Servlet implementation class sin
 */
@WebServlet("/sin")
public class sin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sin() {
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
		String fullname = request.getParameter("fullname");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String mailid = request.getParameter("mail");
	    String number =request.getParameter("number");
	    String address =request.getParameter("address");
	    //Random rm=new Random();
	    //int accno= rm.nextInt(100000);
	    //int n=10;
	    int rand = 0;
    	//rand = (int) (Math.floor(Math.random() * (9*Math.pow(10,n)) + Math.pow(10,n)));
    	rand = (int) (Math.floor( 100000000 + Math.random() * 900000000 ));
    	int accno =rand;
	    si sie=new si(fullname ,username ,password ,mailid,number,address,accno); 
	    
	    Myinterface dDao= new sinDao();
	    String p=dDao.insert(sie);
	    
	    response.getWriter().print(p);
	    
		//doGet(request, response);
	}

}
