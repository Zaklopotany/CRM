package pl.coderslab.controller.orders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.OrdersDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.model.Orders;
import pl.coderslab.model.Status;

@WebServlet("/OrderModify")
public class OrderModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		List<Status> statusList = StatusDao.loadAll();
		Orders tempOrder = new Orders();
		Status tempStatus = StatusDao.loadById(1);
		
		if ( idString !=null) {
			int id = Integer.parseInt(idString);			
			tempOrder = OrdersDao.loadById(id);
			tempStatus = StatusDao.loadById(tempOrder.getStatusId());
		}

		request.setAttribute("tempStatus", tempStatus);
		request.setAttribute("status", statusList);
		request.setAttribute("order", tempOrder);
		request.getServletContext().getRequestDispatcher("/VIEW/Repairs/orderModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		String receiveDate = request.getParameter("receiveDate");
		String expRepiarDate = request.getParameter("expRepairDate");
		String beginRepairDate = request.getParameter("beginRepairDate");
		String employeeId = request.getParameter("employeeId");
		String problemDesc = request.getParameter("problemDesc");
		String repairDesc = request.getParameter("repairDesc");
		String status = request.getParameter("status");
		String carId = request.getParameter("carId");
		String customerPrice = request.getParameter("customerPrice");
		String partsPrice = request.getParameter("partsPrice");
		String workHour = request.getParameter("workHour");
		
		Orders tempOrder = new Orders();
		tempOrder.setId(id).setReceiveDate(receiveDate).setExpRepiarDate(expRepiarDate).setBeginRepair(beginRepairDate);
		tempOrder.setEmployeeId(Integer.parseInt(employeeId)).setProbDesc(problemDesc).setRepDesc(repairDesc);
		tempOrder.setStatusId(Integer.parseInt(status)).setCarId(Integer.parseInt(carId))
				.setCustomerCost(Double.parseDouble(customerPrice));
		tempOrder.setPartsPrice(Double.parseDouble(partsPrice)).setWorkHour(Double.parseDouble(workHour));

		OrdersDao.saveToDb(tempOrder);
		response.sendRedirect(request.getContextPath() + "/showOrderDetails?id="+id);		


	}
}
