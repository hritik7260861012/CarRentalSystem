package com.carrental.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.carrental.db.DBConnection;

@WebServlet("/bookCar")
public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	PrintWriter out=resp.getWriter();

        int carId = Integer.parseInt(req.getParameter("carId"));
        String bookDate = req.getParameter("bookDate");
        String returnDate = req.getParameter("returnDate");

        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO bookings(user_id,car_id,booking_date,return_date) VALUES(?,?,?,?)"
            );
            ps.setInt(1, userId);
            ps.setInt(2, carId);
            ps.setString(3, bookDate);
            ps.setString(4, returnDate);

            ps.executeUpdate();
            resp.setContentType("text/html");
			out.print("<h3 style='color:green'>car is booked</h3>");
            resp.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
