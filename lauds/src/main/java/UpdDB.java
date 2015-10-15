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
				
				  int id = Integer.parseInt(request.getParameter("id")); 
				  connection = Connect.getConnection();
				  
				  PreparedStatement st = connection.prepareStatement("select * from test where id=?");  
				  st.setInt(1, id);
                  ResultSet rs = st.executeQuery();  
				  List<People> folks = new ArrayList<People>();
				  
				  while (rs.next()) { 
						People people = new People();
						people.setId(rs.getInt("id"));  
						people.setName(rs.getString("name"));  
						people.setPlace(rs.getString("place"));  
						folks.add(people);
				  }

				  rs.close();
				  st.close();

			      request.setAttribute("folks", folks); 
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
