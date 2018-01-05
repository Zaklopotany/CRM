package pl.coderslab.controller.Vehicle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

@WebServlet("/DeleteVehicle")
public class DeleteVehicle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Vehicle tempVehicle = VehicleDao.loadById(id);
		VehicleDao.delete(tempVehicle);
		
		response.sendRedirect(request.getContextPath() + "/ShowAllVehicle");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
