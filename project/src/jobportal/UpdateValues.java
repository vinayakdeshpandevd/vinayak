package jobportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateValues extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root",""); 
			java.sql.Statement st=con.createStatement();
			//response.setContentType("text/javascript");
			String firstname=request.getParameter("firstname");
			 String lastname=request.getParameter("lastname");
			 String mobile=request.getParameter("mobile");
			 String gender=request.getParameter("gender");
			 String birthday=request.getParameter("birthday");
			 String email=request.getParameter("email");
			 String qualification=request.getParameter("qualification");
			 String year=request.getParameter("year");
			 String technologies=request.getParameter("technologies");
			 String rollno=request.getParameter("rollno");
			 String company=request.getParameter("company");
			 String jobrole=request.getParameter("jobrole");
			 PreparedStatement ps=con.prepareStatement("update applied set firstname=?,lastname=?,mobile=?,gender=?,birthday=?,email=?,qualification=?,year=?,technologies=?,company=?,jobrole=? where rollno=? ");
			 ps.setString(1,firstname);
			 ps.setString(2,lastname);
			 ps.setString(3,mobile);
			 ps.setString(4,gender);
			 ps.setString(5,birthday);
			 ps.setString(6,email);
			 ps.setString(7,qualification);
			 ps.setString(8,year);
			 ps.setString(9,technologies);
			 ps.setString(10,company);
			 ps.setString(11,jobrole);
			 ps.setString(12,rollno);
			 PrintWriter out=response.getWriter();
			int i= ps.executeUpdate();
			if(i>0) {
				//out.println("<script type=\"text/javascript\">");
				 //  out.println("alert('Successfully Updated');");
				  // out.println("/script");
				HttpSession session=request.getSession();
				//session.
				 session.setAttribute("message","UPDATED SUCCESSFULLY");
				
				 session.setMaxInactiveInterval(1*60);
				RequestDispatcher rd=request.getRequestDispatcher("adminHome.jsp");
				 rd.forward(request, response);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

}
}
