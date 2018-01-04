package pl.coderslab.controller.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Employee tempEmployee = new Employee();
		
		if (id != null) {
			int idInt = Integer.parseInt(id);
			tempEmployee = EmployeeDao.loadById(idInt);
			request.setAttribute("employee", tempEmployee);
		}
		
		request.getServletContext().getRequestDispatcher("/VIEW/Employee/modifyEmployee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		if (!request.getParameter("id").equals("")) {
			id = Integer.parseInt(request.getParameter("id"));			
		}
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String note = request.getParameter("note");
		Double manHour = Double.parseDouble(request.getParameter("manHour"));
 
		
		Employee tempEmp = new Employee();
		tempEmp.setAddress(address).setFirstname(firstname).setSurname(surname).setId(id).setManHour(manHour);
		tempEmp.setNote(note).setPhoneNumber(phoneNumber);
		EmployeeDao.saveToDb(tempEmp);
		if (id == 0) {
			response.sendRedirect(request.getContextPath() + "/ShowAllEmployee");					
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowEmployeeDetails?id="+id);		

		}
		
	}

}
