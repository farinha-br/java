package com;

import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/HelloCDI")
public class HelloCDI extends HttpServlet {

    @Inject
    ListCDI listCDI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		List<String> list = new ArrayList<String>();
		String str = req.getParameter("str");
        list = listCDI.listNames(str);

		req.setAttribute("list", list); 
		req.getRequestDispatcher("result.jsp").forward(req, resp); 
        
    }

}
