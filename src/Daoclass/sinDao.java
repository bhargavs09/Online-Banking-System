package Daoclass;
import java.sql.*;
import beanclass.logclass;
import beanclass.si;
import myinterface.Myinterface;
import DBconnection.DBcon;
public class sinDao implements Myinterface{
    
	@Override
    public String insert(si s) {	
    	Connection con;
    	String t;
    	//long rand = 0;
    	con=DBcon.connect();
    	//int n=10;
    	//rand = (long) (Math.floor(Math.random() * (9*Math.pow(10,n))) + Math.pow(10,n));

        try {
			PreparedStatement pst = con.prepareStatement("insert into accountdetails values(?,?,?,?,?,?,?,default)");
		
			pst.setString(1,s.getFullname());
			pst.setString(2,s.getUsername());
			pst.setString(3,s.getPassword());
			pst.setString(4,s.getMailid());
			pst.setString(5,s.getNumber());
			pst.setString(6,s.getAddress());
			pst.setInt(7,s.getAccno());
			//pst.setString(8,9);
			
			pst.executeUpdate();
			
			t= "Data Entered";
			
		    
		    
        } catch (SQLException e) {
			e.printStackTrace();
			return "Data Not Entered";
		}
		return t;
        
        //return null;
    }
    @Override
	public boolean check(logclass e) {
		// TODO Auto-generated method stub
		Connection con;
		//String status = null;
		ResultSet rs ; 
		boolean p = false;
		con=DBcon.connect();
		 try {
			 PreparedStatement pst = con.prepareStatement("select username,password from accountdetails where username='"+e.getUsername()+"' and password='"+e.getPassword()+"'");
			 
			 rs= pst.executeQuery();
			 
			 p = rs.next();
			 System.out.println(p);
			 //if(p > 0) {
				 //status = "SUCCESS";
			 //}	 
		 } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				//return "Please check your account details";
			}
		return p;
	}
	 
}
