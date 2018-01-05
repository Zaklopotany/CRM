package pl.coderslab.controller.Vehicle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		Vehicle tempVehicle = new Vehicle();
		if (idString != null) {
			int id = Integer.parseInt(idString);
			tempVehicle = VehicleDao.loadById(id);
		}
		request.setAttribute("vehicle", tempVehicle);
		request.getServletContext().getRequestDispatcher("/VIEW/Vehicle/addVehicle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		Vehicle tempVehicle = new Vehicle();
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String productionYear = request.getParameter("productionYear");
		String regNumber = request.getParameter("registrationNumber");
		String nextRevDate = request.getParameter("nextRevDate");
		String customerId = request.getParameter("customerId");
		try {
			tempVehicle.setClientId(Integer.parseInt(customerId));
			} catch (Exception e) {
				
			}
		
		if (!idString.equals("0")) {
			int id = Integer.parseInt(idString);
			tempVehicle = VehicleDao.loadById(id);
		}

		tempVehicle.setBrand(brand).setModel(model).setNextReviewDate(nextRevDate).setProductionYear(productionYear)
				.setRegistrationNumber(regNumber);
		
		VehicleDao.saveToDb(tempVehicle);
		
		response.sendRedirect(request.getContextPath() + "/ShowAllVehicle");

	}

}
