package sn.groupeisi.controller;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import sn.groupeisi.repositiry.Icandidat;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Logout")
public class LogOut extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Invalidating the session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirecting to the login page
        request.getRequestDispatcher("index.jsp").forward(request, response);

	

}}
