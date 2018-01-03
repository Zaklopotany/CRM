package pl.coderslab.controller.orders;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.OrdersDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.model.Orders;
import pl.coderslab.model.Status;

@WebServlet("/showOrderDetails")
public class ShowOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		if (id != null) {
			
			int idInt = Integer.parseInt(id);
			Orders tempOrder = OrdersDao.loadById(idInt);
			Status tempSatus = StatusDao.loadById(tempOrder.getStatusId());
			double totalWorkCost = tempOrder.getManHour()*tempOrder.getWorkHour();
			double totalCost = totalWorkCost + tempOrder.getPartsPrice() + tempOrder.getCustomerCost();
			
			request.setAttribute("totalCost", totalCost);
			request.setAttribute("cost", totalWorkCost);
			request.setAttribute("status", tempSatus);
			request.setAttribute("order", tempOrder);
		}
		request.getServletContext().getRequestDispatcher("/VIEW/Repairs/orderDetails.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
