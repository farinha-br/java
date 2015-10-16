import java.io.IOException;  
import java.io.InputStream;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
 
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.Statement;  
import java.util.ArrayList;  
import java.util.List;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import com.Connect;  
  
public class UpdDB extends HttpServlet { 
   
		private static Connection connection = null;  
     
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
             try { 
				
				  int rid = Integer.parseInt(request.getParameter("id")); 
				  connection = Connect.getConnection();
				  
				  PreparedStatement st = connection.prepareStatement("select * from test where id=?");  
				  st.setInt(1, rid);
                  ResultSet rs = st.executeQuery();  
				  List<People> folks = new ArrayList<People>();
				  
				  rs.next();
				  int id = rs.getInt("id");  
				  String name = rs.getString("name");  
				  String place = rs.getString("place");  
						
				  rs.close();
				  st.close();

			      request.setAttribute("id", id); 
				  request.setAttribute("name", name); 
				  request.setAttribute("place", place); 
				  
			      request.getRequestDispatcher("/update.jsp").forward(request, response); 

              } catch (SQLException e) {  
                  e.printStackTrace();  
            } catch (IOException e) {
                e.printStackTrace();
			}finally{
				try{	
					connection.close();
					} catch(Exception ex) { }
			}  
    }  
}  
