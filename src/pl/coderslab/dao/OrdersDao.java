package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Orders;

public class OrdersDao {
	
	public static List<Orders> loadAll() {
		String sql = "Select * from Orders;";
		List<Orders> ordersList = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			Statement stat = con.createStatement();
			try (ResultSet rs = stat.executeQuery(sql)) {
				while (rs.next()) {
					Orders tempOrder = new Orders();
					tempOrder.setId(rs.getInt("id"));
					tempOrder.setReceiveDate(rs.getDate("receive_date"));
					tempOrder.setExpRepiarDate(rs.getDate("expect_repair_date"));
					tempOrder.setBeginRepair(rs.getDate("repair_begin"));
					tempOrder.setEmployeeId(rs.getInt("employee_id"));
					tempOrder.setProbDesc(rs.getString("problem_description"));
					tempOrder.setRepDesc(rs.getString("repair_description"));
					tempOrder.setStatusId(rs.getInt("status_id"));
					tempOrder.setCarId(rs.getInt("car_id"));
					tempOrder.setCustomerCost(rs.getDouble("customer_cost"));
					tempOrder.setPartsPrice(rs.getDouble("parts_price"));
					tempOrder.setManHour(rs.getDouble("man_hour"));
					tempOrder.setWorkHour(rs.getDouble("work_hour"));

					ordersList.add(tempOrder);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	public static Orders loadById(int id) {
		String sql = "Select * from Orders where id = ?;";
		Orders tempOrder = new Orders();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, id);
			try (ResultSet rs = prepStat.executeQuery()) {
				while (rs.next()) {
					tempOrder.setId(rs.getInt("id"));
					tempOrder.setReceiveDate(rs.getDate("receive_date"));
					tempOrder.setExpRepiarDate(rs.getDate("expect_repair_date"));
					tempOrder.setBeginRepair(rs.getDate("repair_begin"));
					tempOrder.setEmployeeId(rs.getInt("employee_id"));
					tempOrder.setProbDesc(rs.getString("problem_description"));
					tempOrder.setRepDesc(rs.getString("repair_description"));
					tempOrder.setStatusId(rs.getInt("status_id"));
					tempOrder.setCarId(rs.getInt("car_id"));
					tempOrder.setCustomerCost(rs.getDouble("customer_cost"));
					tempOrder.setPartsPrice(rs.getDouble("parts_price"));
					tempOrder.setManHour(rs.getDouble("man_hour"));
					tempOrder.setWorkHour(rs.getDouble("work_hour"));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempOrder;
	}
	
	public static List<Orders> loadAllByStatus(int id) {
		String sql = "Select * from Orders where status_id = ?;";
		List<Orders> ordersList = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, id);
			try (ResultSet rs = prepStat.executeQuery()) {
				while (rs.next()) {
					Orders tempOrder = new Orders();
					tempOrder.setId(rs.getInt("id"));
					tempOrder.setReceiveDate(rs.getDate("receive_date"));
					tempOrder.setExpRepiarDate(rs.getDate("expect_repair_date"));
					tempOrder.setBeginRepair(rs.getDate("repair_begin"));
					tempOrder.setEmployeeId(rs.getInt("employee_id"));
					tempOrder.setProbDesc(rs.getString("problem_description"));
					tempOrder.setRepDesc(rs.getString("repair_description"));
					tempOrder.setStatusId(rs.getInt("status_id"));
					tempOrder.setCarId(rs.getInt("car_id"));
					tempOrder.setCustomerCost(rs.getDouble("customer_cost"));
					tempOrder.setPartsPrice(rs.getDouble("parts_price"));
					tempOrder.setManHour(rs.getDouble("man_hour"));
					tempOrder.setWorkHour(rs.getDouble("work_hour"));
					ordersList.add(tempOrder);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	public static void saveToDb(Orders order) {
		int id = order.getId();
		Employee tempEmpl = EmployeeDao.loadById(order.getEmployeeId());
		try (Connection con = DbUtil.getConn()) {
			if (id == 0) {
				String sql = "insert into Orders " + "(receive_date, expect_repair_date, repair_begin, employee_id, "
						+ "problem_description, repair_description, status_id, car_id, "
						+ "customer_cost, parts_price, man_hour, work_hour) " + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setDate(1, order.getReceiveDate());
				prepStat.setDate(2, order.getExpRepiarDate());
				prepStat.setDate(3, order.getBeginRepair());
				prepStat.setInt(4, order.getEmployeeId());
				prepStat.setString(5, order.getProbDesc());
				prepStat.setString(6, order.getRepDesc());
				prepStat.setInt(7, order.getStatusId());
				prepStat.setInt(8, order.getCarId());
				prepStat.setDouble(9, order.getCustomerCost());
				prepStat.setDouble(10, order.getPartsPrice());
				prepStat.setDouble(11, tempEmpl.getManHour());
				prepStat.setDouble(12, order.getWorkHour());

				prepStat.executeUpdate();
			} else {
				String sql = "update Orders set "
						+ "receive_date = ?, expect_repair_date = ?, repair_begin = ?, employee_id = ?,"
						+ "problem_description = ?, repair_description = ?, status_id = ?,"
						+ " car_id = ?,customer_cost = ?, parts_price = ?, "
						+ "man_hour = ?, work_hour = ? where id = ?";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setDate(1, order.getReceiveDate());
				prepStat.setDate(2, order.getExpRepiarDate());
				prepStat.setDate(3, order.getBeginRepair());
				prepStat.setInt(4, order.getEmployeeId());
				prepStat.setString(5, order.getProbDesc());
				prepStat.setString(6, order.getRepDesc());
				prepStat.setInt(7, order.getStatusId());
				prepStat.setInt(8, order.getCarId());
				prepStat.setDouble(9, order.getCustomerCost());
				prepStat.setDouble(10, order.getPartsPrice());
				prepStat.setDouble(11, tempEmpl.getManHour());
				prepStat.setDouble(12, order.getWorkHour());
				prepStat.setInt(13, order.getId());
				prepStat.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Orders order) {
		String sql = "delete from Orders where id = ?;";
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, order.getId());
			prepStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
