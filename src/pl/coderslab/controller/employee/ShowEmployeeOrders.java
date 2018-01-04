package pl.coderslab.controller.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrdersDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Orders;
import pl.coderslab.model.Status;

@WebServlet("/ShowEmployeeOrders")
public class ShowEmployeeOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] colName = { "Id zlecenie", "Data przyjęcie", "Przewidywana data naprawy", "Status" };
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Employee tempEmp = EmployeeDao.loadById(id);
		List<Orders> empOrders = OrdersDao.loadAllByEmployeeId(id);
		List<Status> statusOrders = new ArrayList<>();
		
		for (int i = 0; i < empOrders.size(); i++) {
			statusOrders.add(StatusDao.loadById(empOrders.get(i).getStatusId()));
		}

		request.setAttribute("colName", colName);	
		request.setAttribute("status", statusOrders);
		request.setAttribute("employee", tempEmp);
		request.setAttribute("ordersList", empOrders);

		request.getServletContext().getRequestDispatcher("/VIEW/Employee/showEmployeeOrders.jsp").forward(request,
				response);
	}

}
