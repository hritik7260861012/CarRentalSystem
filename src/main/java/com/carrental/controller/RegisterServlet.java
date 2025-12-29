package com.carrental.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.carrental.db.DBConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	PrintWriter out=resp.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)"
            );
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, "user");

           int cout=ps.executeUpdate();
            if (cout > 0) {
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'>registertion Sucess</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);

			} else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>registertion faild</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
