package pl.coderslab.controller.orders;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.OrdersDao;
import pl.coderslab.model.Orders;
@WebServlet("/showOrdersActive")
public class showOrdersActive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Orders> listOrders = OrdersDao.loadAllByStatus(3);		
		
		request.setAttribute("orders", listOrders);
		request.getServletContext().getRequestDispatcher("/VIEW/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
