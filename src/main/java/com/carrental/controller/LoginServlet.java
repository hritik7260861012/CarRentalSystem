package com.carrental.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.carrental.db.DBConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	PrintWriter out=resp.getWriter();
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );
            ps.setString(1, email);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("userId", rs.getInt("id"));
                session.setAttribute("role", rs.getString("role"));
                resp.sendRedirect("dashboard.jsp");
            } else {
            	resp.setContentType("text/html");
 			   out.print("<h3 style='color:red'>Incorrect Emaid and password </h3>");
 			  RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			   rd.include(req, resp);
            }

        } catch (Exception e) {
        	 resp.setContentType("text/html");
  		   out.print("<h3>Exception:"+e.getMessage()+"</h3>");
  		   
  		   RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
  		   rd.include(req, resp);
  		   
        }
    }
}
