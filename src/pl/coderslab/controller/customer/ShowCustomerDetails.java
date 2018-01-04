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
import pl.coderslab.dao.OrdersDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Orders;
import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;
@WebServlet("/ShowCustomerDetails")
public class ShowCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer tempCustomer = CustomerDao.loadById(id);
		List<Orders> customerOrders = OrdersDao.loadAllByCustomerId(id);
		List<Vehicle> customerVehicles = VehicleDao.loadAllbyClientId(id);
		List<Status> statusList = new ArrayList<>();
		
		for(int i =0; i<customerOrders.size(); i++) {
			statusList.add(StatusDao.loadById(customerOrders.get(i).getStatusId()));
		}
		
		String[] colNamesOrders = {"Id zlecenia","Data przyjęcia","Status","Id pojazdu","",""};
		String[] colNamesVehicles = {"Id Pojazdu","Marka","Numer rejestracyjny","",""};
		
		request.setAttribute("status", statusList);
		request.setAttribute("colNamesOrders", colNamesOrders);
		request.setAttribute("colNamesVehicles", colNamesVehicles);
		request.setAttribute("customerOrders", customerOrders);
		request.setAttribute("customerVehicles", customerVehicles);
		request.setAttribute("customer", tempCustomer);
		
		request.getServletContext().getRequestDispatcher("/VIEW/Customer/showCustomerDetails.jsp").forward(request, response);
		
	}

}
