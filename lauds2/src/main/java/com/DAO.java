package com;

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
  
public class DAO extends HttpServlet { 
   
		private static Connection connection = null;  
     
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
	    if (request.getParameter("action") != null)
		{
			 String action = request.getParameter("action");
			 
			 if (action.equals("list")) {
				doList(request, response);
			 } else if (action.equals("update")) {
				doUpdate(request, response);
			 } else doList(request, response);
			   
	    } else doList(request, response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	
	  
	    if (request.getParameter("action") != null)
		{
		 String action = request.getParameter("action");
			 
			 if (action.equals("list")) {
				doList(request, response);
			 } else if (action.equals("insert")) {
				doInsert(request, response);
			 } else if (action.equals("delete")) {
				doDelete(request, response);
			 } else if (action.equals("search")) {
				doSearch(request, response);
			 } else if (action.equals("save")) {
				doSave(request, response);				
			 } else doList(request, response);
			     
	    } else doList(request, response);
		}
		
		public void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
             try { 
				  connection = Connect.getConnection();
				  
				  PreparedStatement st = connection.prepareStatement("select * from test");  
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
			      request.getRequestDispatcher("/list.jsp").forward(request, response); 

				  } catch (SQLException e) {  
                  e.printStackTrace();  
            } catch (IOException e) {
                e.printStackTrace();
			} finally {
				try{	
					connection.close();
					}
					catch(Exception ex) { }
			}  
    }  
	
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
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
	
	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		try { 	
				connection = Connect.getConnection();
				  				
				String name = request.getParameter("name");
				String place = request.getParameter("place");
				
				PreparedStatement st = connection.prepareStatement("insert into test (name, place) values (?, ?)");   
              
				st.setString(1, name);  
				st.setString(2, place);  
				st.executeUpdate();  
				
				st.close();
				response.sendRedirect("dao?action=list");
    
            } catch (SQLException e) {  
				e.printStackTrace();  
		    } finally {
				try{ connection.close(); } catch(Exception ex) { }
		}  
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

			try { 	
				
				connection = Connect.getConnection();
				
				int id = Integer.parseInt(request.getParameter("id")); 
				
				PreparedStatement st = connection.prepareStatement("delete from test where id=?");   
              
				st.setInt(1, id);  	
				st.executeUpdate();  
				
				st.close();
				response.sendRedirect("dao?action=list");
    
            } catch (SQLException e) {  
				e.printStackTrace();  
    	    } finally {
				try { 
					connection.close(); 
					} catch(Exception ex) { }
		}  
    }  
	public void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	
			try { 	
				connection = Connect.getConnection();
				
				int id = Integer.parseInt(request.getParameter("id")); 
				String name = request.getParameter("name");
				String place = request.getParameter("place");
				
				PreparedStatement st = connection.prepareStatement("update test set name=?, place=? where id=?");   
              
				st.setString(1, name);  
				st.setString(2, place);  
				st.setInt(3, id);  	
				st.executeUpdate();  
				
				st.close();
				response.sendRedirect("dao?action=list");
    
        } catch (SQLException e) {  
            e.printStackTrace();  
			
		} finally {
				try{ connection.close(); } catch(Exception ex) { }
		}  

    }  
	public void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
             try { 
				
				  connection = Connect.getConnection();
				  String search_name = request.getParameter("search_name"); 
				  
				  PreparedStatement st = connection.prepareStatement("select * from test where name like ?");  
				  st.setString(1, "%"+ search_name + "%");
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
			      request.getRequestDispatcher("/list.jsp").forward(request, response); 

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
	
///	
}  
