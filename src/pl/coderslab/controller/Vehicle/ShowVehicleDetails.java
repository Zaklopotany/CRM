package pl.coderslab.controller.Vehicle;

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
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Orders;
import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;

@WebServlet("/ShowVehicleDetails")
public class ShowVehicleDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Vehicle tempVehicle = VehicleDao.loadById(id);
		List<Orders> orderList = OrdersDao.loadAllByVehicleId(id);
		List<Status> statusList = new ArrayList<Status>();
		for (int i = 0; i < orderList.size(); i ++) {
			statusList.add(StatusDao.loadById(orderList.get(i).getStatusId()));
		}
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("status", statusList);
		request.setAttribute("vehicle", tempVehicle);
		request.getServletContext().getRequestDispatcher("/VIEW/Vehicle/showVehicleDetails.jsp").forward(request, response);
		
	}

}
