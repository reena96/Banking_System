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
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","system");
				st=con.createStatement();
				
				 // transaction_type  |  account_number  |  amount  |  pan_number  |  mobileno  
				
				String transaction_type = request.getParameter("transaction_type");
				String account_number = request.getParameter("account_number");
				float amount = Float.parseFloat(request.getParameter("amount"));
				int pan_number = Integer.parseInt(request.getParameter("pan_number""));
				int mobile = Integer.parseInt(request.getParameter("mobile"));
				
				

				String str="insert into register values('"+individual_joint+"','"+account_type+"','"+pname+"','"+dob+"','"+gender+"','"+email+"',"+mobile+",'"+current_address+"','"+username+"','"+password+"','"+confirm_password+"')";

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


