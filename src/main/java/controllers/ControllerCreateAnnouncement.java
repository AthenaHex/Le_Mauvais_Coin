package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Announcement;
import services.LeMauvaisCoinServices;


@WebServlet("/controllercreateannouncement")
public class ControllerCreateAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LeMauvaisCoinServices service;

    public ControllerCreateAnnouncement() {
        super();
        service = new LeMauvaisCoinServices();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.getRequestDispatcher("CreateAnnouncementView.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("txtTitle");
		Float price = Float.parseFloat(request.getParameter("txtPrice"));
		String type = request.getParameter("txtType");
		String description = request.getParameter("txtDescription");
		String email = session.getParameter("email");
		int idCustomer;
		try {
			// L'annonce est créée :
			idCustomer = service.getCustomerIdByEmail(email);
			Announcement ann = new Announcement(-1, title, price, type, description, idCustomer);
			service.addAnnouncement(ann);
			//màj de la liste
			List<Announcement> listAnnoncementConnectedCustomer = service.getAllAnnoucementByIdCustomer(service.getCustomerIdByEmail(email) );
			session.setAttribute("listAnnoncementConnectedCustomer", listAnnoncementConnectedCustomer );
			request.getRequestDispatcher("controllerpersonalspace").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
	
	
	
	
}
