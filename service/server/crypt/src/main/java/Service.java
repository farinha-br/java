import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Service extends HttpServlet {  

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	      				throws ServletException, IOException {

    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();


	try {
		
		Decryption krypt = new Decryption();

	    String cmd = request.getParameter("cmd");
		String decryptedText = krypt.decrypt(cmd, "thepswd");
		
		// process request
		String resend = "Your bank balance is: " + "2 750,00 EUR";

		Encryption enkrypt = new Encryption();
        String encryptedText = enkrypt.encrypt(resend, "thepswd");
		out.println(encryptedText);
	}
    catch (Exception e) {
	   	e.printStackTrace();
		}
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    		doGet(request, response);
  }

}

