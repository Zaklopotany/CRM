package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.model.Employee;

public class EmployeeDao {

	public static List<Employee> loadAll() {
		String sql = "Select * from Employee;";
		List<Employee> employeeList = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			Statement stat = con.createStatement();
			try (ResultSet rs = stat.executeQuery(sql)) {
				while (rs.next()) {
					Employee tempEmpl = new Employee();
					tempEmpl.setId(rs.getInt("id"));
					tempEmpl.setFirstname(rs.getString("firstname"));
					tempEmpl.setSurname(rs.getString("surname"));
					tempEmpl.setAddress(rs.getString("address"));
					tempEmpl.setPhoneNumber(rs.getString("phone_number"));
					tempEmpl.setNote(rs.getString("note"));
					tempEmpl.setManHour(rs.getDouble("man_hour"));					
					employeeList.add(tempEmpl);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public static List<Employee> loadAllBySpec(String spec, String value) {
		String sql = "Select * from Employee" + "where ? like '?%' " + "COLLATE utf8_general_ci;";
		List<Employee> employeeList = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setString(1, spec);
			prepStat.setString(2, value);
			try (ResultSet rs = prepStat.executeQuery()) {
				while (rs.next()) {
					Employee tempEmpl = new Employee();
					tempEmpl.setId(rs.getInt("id"));
					tempEmpl.setFirstname(rs.getString("firstname"));
					tempEmpl.setSurname(rs.getString("surname"));
					tempEmpl.setAddress(rs.getString("address"));
					tempEmpl.setPhoneNumber(rs.getString("phone_number"));
					tempEmpl.setNote(rs.getString("note"));
					tempEmpl.setManHour(rs.getDouble("man_hour"));					
					employeeList.add(tempEmpl);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public static Employee loadById(int id) {
		String sql = "Select * from Employee where id = ?;";
		Employee tempEmpl = new Employee();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, id);
			try (ResultSet rs = prepStat.executeQuery()) {
				while (rs.next()) {
					tempEmpl.setId(rs.getInt("id"));
					tempEmpl.setFirstname(rs.getString("firstname"));
					tempEmpl.setSurname(rs.getString("surname"));
					tempEmpl.setAddress(rs.getString("address"));
					tempEmpl.setPhoneNumber(rs.getString("phone_number"));
					tempEmpl.setNote(rs.getString("note"));
					tempEmpl.setManHour(rs.getDouble("man_hour"));					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempEmpl;
	}

	public static void saveToDb(Employee employee) {
		int id = employee.getId();
		try (Connection con = DbUtil.getConn()) {
			if (id == 0) {
				String sql = "insert into Employee "
						+ "(firstname,surname,address,phone_number,note,man_hour) "
						+ "values (?,?,?,?,?,?);";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setString(1, employee.getFirstname());
				prepStat.setString(2, employee.getSurname());
				prepStat.setString(3, employee.getAddress());
				prepStat.setString(4, employee.getPhoneNumber());
				prepStat.setString(5, employee.getNote());
				prepStat.setDouble(6, employee.getManHour());

				prepStat.executeUpdate();
			} else {
				String sql = "update Employee set "
						+ "firstname = ?, surname = ?, address = ?, phone_number = ?,"
						+ "note =?, man_hour = ? where id=?";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setString(1, employee.getFirstname());
				prepStat.setString(2, employee.getSurname());
				prepStat.setString(3, employee.getAddress());
				prepStat.setString(4, employee.getPhoneNumber());
				prepStat.setString(5, employee.getNote());
				prepStat.setDouble(6, employee.getManHour());
				prepStat.setInt(7, employee.getId());
				
				prepStat.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Employee employee) {
		String sql = "delete from Employee where id = ?;";
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, employee.getId());

			prepStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
