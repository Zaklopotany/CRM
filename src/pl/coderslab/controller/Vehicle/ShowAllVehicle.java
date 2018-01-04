package pl.coderslab.controller.Vehicle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

@WebServlet("/ShowAllVehicle")
public class ShowAllVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vehicle> vehicleList = VehicleDao.loadAll();
		String[] colName = {"Id pojazdu","Marka","Model","Id klienta","",""};
		
		request.setAttribute("vehicleList", vehicleList);
		request.setAttribute("names", colName);
		
		request.getServletContext().getRequestDispatcher("/VIEW/Vehicle/showAllVehicles.jsp").forward(request, response);
	}

}
