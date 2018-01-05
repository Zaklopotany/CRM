package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.model.Customer;

public class CustomerDao {
	
	public static List<Customer> loadAll() {
		String sql ="Select * from Customer;";
		List<Customer> customerList = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			Statement stat = con.createStatement();
			
			try(ResultSet rs = stat.executeQuery(sql)) {
				while (rs.next()) {
					Customer tempCust = new Customer();
					tempCust.setId(rs.getInt("id"));
					tempCust.setFirstname(rs.getString("name"));
					tempCust.setSurname(rs.getString("surname"));
					tempCust.setBdDate(rs.getString("bd_date"));
					customerList.add(tempCust);					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public static List<Customer> loadAllBySpec(String spec, String value) {
		String sql = "Select * from Customer "
				+ "where ? like '?%' "
				+ "COLLATE utf8_general_ci;";
		List<Customer> customerList = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setString(1, spec);
			prepStat.setString(2, value);			
			
			try(ResultSet rs = prepStat.executeQuery()) {
				while (rs.next()) {
					Customer tempCust = new Customer();
					tempCust.setId(rs.getInt("id"));
					tempCust.setFirstname(rs.getString("name"));
					tempCust.setSurname(rs.getString("surname"));
					tempCust.setBdDate(rs.getString("bd_date"));
					customerList.add(tempCust);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public static Customer loadById(int id) {
		String sql ="Select * from Customer where id = ?;";
		Customer tempCust = new Customer();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, id);
			try(ResultSet rs = prepStat.executeQuery()) {
				while (rs.next()) {
					tempCust.setId(rs.getInt("id"));
					tempCust.setFirstname(rs.getString("name"));
					tempCust.setSurname(rs.getString("surname"));
					tempCust.setBdDate(rs.getString("bd_date"));					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempCust;
	}
	
	public static void saveToDb (Customer customer) {
		int id = customer.getId();
		try (Connection con = DbUtil.getConn()) {
			if (id == 0) {
				String sql = "insert into Customer values (null,?,?,?);";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setString(1, customer.getFirstname());
				prepStat.setString(2, customer.getSurname());
				if (customer.getBdDate() != null) {
					prepStat.setString(3,customer.getBdDate().toString());					
				} else {
					prepStat.setString(3,null);					
				}
				
				prepStat.executeUpdate();
			} else {
				String sql = "update Customer set name=?,surname=?,bd_date=? where id=?";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setString(1, customer.getFirstname());
				prepStat.setString(2, customer.getSurname());
				if (customer.getBdDate() != null) {
					prepStat.setString(3,customer.getBdDate().toString());					
				} else {
					prepStat.setString(3,null);					
				}
				prepStat.setInt(4, customer.getId());
				
				prepStat.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete (Customer customer) {
		String sql = "delete from Customer where id = ?;";
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, customer.getId());
			
			prepStat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
