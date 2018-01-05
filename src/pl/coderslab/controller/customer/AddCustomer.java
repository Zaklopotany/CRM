package pl.coderslab.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		Customer tempCustomer = new Customer();
		
		if (idString != null) {
			int id = Integer.parseInt(idString);
			tempCustomer =CustomerDao.loadById(id);
		}
		
		request.setAttribute("customer", tempCustomer);
		request.getServletContext().getRequestDispatcher("/VIEW/Customer/addCustomer.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		Customer tempCustomer = new Customer();
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String bdDate = request.getParameter("bdDate");
		
		if ( idString != null) {
			int id = Integer.parseInt(idString);
			tempCustomer = CustomerDao.loadById(id);
		}
		
		tempCustomer.setFirstname(firstname).setSurname(surname).setBdDate(bdDate);
		
		CustomerDao.saveToDb(tempCustomer);
		
		response.sendRedirect(request.getContextPath() + "/ShowAllCustomer");
	}

}
