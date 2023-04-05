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
import sn.groupeisi.entities.*;


@WebServlet("/Login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW_PATH = "/WEB-INF/views/candidatseneuleuk/";
	@EJB
	private Icandidat candidatdao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("connexion")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if (email.isEmpty() & password.isEmpty()) {
				request.setAttribute("error", "Invalide remplir les champs ");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				Candidat candidat = candidatdao.authenticatecandidat(email, password);
				if (candidat == null) {
					request.setAttribute("error", "candidat Invalide ");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					HttpSession session = request.getSession();
					String firstname=candidat.getFirstname();
					String lastname=candidat.getLastname();
					int id=candidat.getId();
					session.setAttribute("lastname", lastname);
					session.setAttribute("firstname", firstname);
					session.setAttribute("email", email);
					session.setAttribute("id",id);
					request.getRequestDispatcher(VIEW_PATH+"espacecandidat.jsp").forward(request, response);
				}

			}
			// fin if
		}
		// fin if
	}

}
