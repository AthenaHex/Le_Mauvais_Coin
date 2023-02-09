package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Announcement;
import services.LeMauvaisCoinServices;


@WebServlet("/controllerpersonalspace")
public class ControllerPersonalSpace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LeMauvaisCoinServices service;

    public ControllerPersonalSpace() {
        super();
        service = new LeMauvaisCoinServices();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("PersonalSpaceView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String email = request.getParameter("txtEmail");
			String password = request.getParameter("txtPassword");
			if(service.IsCustomerInfoValid(email, password)) {
				HttpSession session = request.getSession();
				String pseudonyme = service.getCustomerPseudonymeByEmail(email);
				session.setAttribute("pseudonyme",pseudonyme);
				session.setAttribute("email",email);
				//Récupère toutes les annonces lié au Client(customer) à l'adresse mail(email) dans une liste : 
				ArrayList<Announcement> listAnnoncementConnectedCustomer = (ArrayList<Announcement>) service.getAllAnnoucementByIdCustomer(service.getCustomerIdByEmail(email) );
				session.setAttribute("listAnnoncementConnectedCustomer", listAnnoncementConnectedCustomer );
				request.getRequestDispatcher("PersonalSpaceView.jsp").forward(request, response);
				//request.getRequestDispatcher("controllerpersonalspace").forward(request, response);
			}else {
				request.getRequestDispatcher("AnnouncementView.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
