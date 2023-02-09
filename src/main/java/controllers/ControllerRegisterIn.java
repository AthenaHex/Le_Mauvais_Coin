package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Customer;
import services.LeMauvaisCoinServices;

@WebServlet("/controllerregisterin")
public class ControllerRegisterIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LeMauvaisCoinServices service;
	

    public ControllerRegisterIn() {
    	super();
    	service = new LeMauvaisCoinServices();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("RegisterInView.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudonyme = request.getParameter("txtPseudonyme");
		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		String passwordConfirmation = request.getParameter("txtPasswordConfirmation");
		
		if(password.equals(passwordConfirmation) && password.length()<31 && pseudonyme.length()<26 && firstName.length()<31 && lastName.length()<31 && email.length()<31) {
			Customer cust = new Customer(-1, pseudonyme, firstName, lastName, email, password);
			try {
				service.addCustomer(cust);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setAttribute("pseudonyme",pseudonyme);
			session.setAttribute("email",email);
			
			request.getRequestDispatcher("controllerpersonalspace").forward(request, response);
		}else {
			request.getRequestDispatcher("RegisterInView.jsp").forward(request, response);
		}
		
		
	}

}
