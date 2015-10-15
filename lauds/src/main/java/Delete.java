import java.io.IOException;  
import java.io.InputStream;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.util.Properties;  

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
  
public class Delete extends HttpServlet { 
   
		private static Connection connection = null;  
     
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

					doPost(request, response);
		}  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

			try { 	
				
				connection = Connect.getConnection();
				
				int id = Integer.parseInt(request.getParameter("id")); 
				
				PreparedStatement st = connection.prepareStatement("delete from test where id=?");   
              
				st.setInt(1, id);  	
				st.executeUpdate();  
				
				st.close();
				response.sendRedirect("list");
    
            } catch (SQLException e) {  
				e.printStackTrace();  
    	    } finally {
				try { 
					connection.close(); 
					} catch(Exception ex) { }
		}  
    }  
}  
