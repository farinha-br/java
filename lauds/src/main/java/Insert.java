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
  
public class Insert extends HttpServlet { 
   
		private static Connection connection = null;  
     
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

					doPost(request, response);
		}  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	
			try { 	
				connection = Connect.getConnection();
				  				
				String name = request.getParameter("name");
				String place = request.getParameter("place");
				
				PreparedStatement st = connection.prepareStatement("insert into test (name, place) values (?, ?)");   
              
				st.setString(1, name);  
				st.setString(2, place);  
				st.executeUpdate();  
				
				st.close();
				response.sendRedirect("list");
    
            } catch (SQLException e) {  
				e.printStackTrace();  
		    } finally {
				try{ connection.close(); } catch(Exception ex) { }
		}  

    }  
}  
