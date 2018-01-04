package pl.coderslab.controller.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;
@WebServlet("/ShowEmployeeDetails")
public class ShowEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee tempEmployee = EmployeeDao.loadById(id);
		request.setAttribute("employee", tempEmployee);
		
		request.getServletContext().getRequestDispatcher("/VIEW/Employee/showEmployeeDetails.jsp").forward(request, response);
	}


}
