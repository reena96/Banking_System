import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class OpenAccount extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con=null;
		Statement st=null;
		
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","system");  // database:bank
				st=con.createStatement();
				
				//individual/joint,account_type,pname,dob,gender,email,mobile,current_address,username,password,confirm_password,agree
				
				String individual_joint = request.getParameter("individual_joint");
				String account_type = request.getParameter("account_type");
				String pname=request.getParameter("pname");
				String dob = request.getParameter("dob");
				String gender = request.getParameter("gender");
				String email = request.getParameter("email");
				int mobile = Integer.parseInt(request.getParameter("mobile"));
				String current_address = request.getParameter("current_address");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String confirm_password = request.getParameter("confirm_password");
				
				
				// Table name: open_account    Database name: bank 
				String str="insert into account values('"+individual_joint+"','"+account_type+"','"+pname+"','"+dob+"','"+gender+"','"+email+"',"+mobile+",'"+current_address+"','"+username+"','"+password+"','"+confirm_password+"')";

				int i=st.executeUpdate(str);
				
				if(i>0)
					{
						out.println("<h2><center>"+"You have registered with Bank of Hyderabad succesfully.<a href='home.jsp'>Now,proceed to login</a></center></h2>");
					}


				st.close();
				con.close();
			}
			catch(SQLException se){
                se.printStackTrace();
		    }
		    catch(Exception e){       
                e.printStackTrace();
            }
			finally{
                    try{
					     if(st!=null)
					     st.close();
				       }catch(SQLException se2){
                          se2.printStackTrace();
		               }
					   
                    try{
                    if(con!=null)
                     con.close();
                       }catch(SQLException se3){
                          se3.printStackTrace();
                       }   
                  } 
   
   }
} 


