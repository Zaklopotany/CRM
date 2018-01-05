package pl.coderslab.controller.orders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.OrdersDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.model.Orders;
import pl.coderslab.model.Status;

@WebServlet("/ShowAllOrders")
public class ShowAllOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		List<Status> statusList = StatusDao.loadAll();
		
		request.setAttribute("status", statusList);
		
		request.getServletContext().getRequestDispatcher("/VIEW/Orders/showAllOrders.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show = request.getParameter("showByStatus");
		String[] colName = {"Id naprawy","Szaczowana data rozpoczęcia","Data rozpoczęcia","Status","Id pracownika",""};
		List<Orders> orderList = new ArrayList<>();
		List<Status> statusList = StatusDao.loadAll();
		if (show != null) {
			int id = Integer.parseInt(show);
			orderList = OrdersDao.loadAllByStatus(id); 
		} else {
			orderList = OrdersDao.loadAll();
		}
		request.setAttribute("status", statusList);
		request.setAttribute("orders", orderList);
		request.setAttribute("colName", colName);
		request.getServletContext().getRequestDispatcher("/VIEW/Orders/showAllOrders.jsp").forward(request, response);
	}
}
