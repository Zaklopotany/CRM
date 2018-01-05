package pl.coderslab.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;
@WebServlet("/ShowAllCustomer")
public class ShowAllCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customerList = new ArrayList<>();
		customerList = CustomerDao.loadAll();
		String[] colName= {"Id klienta","Imię","Nazwisko","Data urodzenia","","",""};
		
		request.setAttribute("colName", colName);
		request.setAttribute("customerList", customerList);
		
		request.getServletContext().getRequestDispatcher("/VIEW/Customer/showAllCustomer.jsp").forward(request, response);
	}

}
