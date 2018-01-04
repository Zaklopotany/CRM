package pl.coderslab.controller.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

@WebServlet("/ShowAllEmployee")
public class ShowAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] colNames = {"Id Pracownika","Imie i nazwisko","Numer telefonu", "",""};		
		
		List<Employee> employeeList = EmployeeDao.loadAll();
		
		request.setAttribute("employeeList", employeeList);
		request.setAttribute("names", colNames);
		request.getServletContext().getRequestDispatcher("/VIEW/Employee/showAllEmployee.jsp").forward(request, response);
	}

	
}
