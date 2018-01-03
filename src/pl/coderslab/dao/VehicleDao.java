package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.model.Vehicle;

public class VehicleDao {
	
	public static List<Vehicle> loadAll() {
		String sql = "Select * from Vehicle;";
		List<Vehicle> vehicleList = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			Statement stat = con.createStatement();
			try (ResultSet rs = stat.executeQuery(sql)) {
				while (rs.next()) {
					Vehicle tempVehicle = new Vehicle();
					tempVehicle.setId(rs.getInt("id"));
					tempVehicle.setModel(rs.getString("model"));
					tempVehicle.setBrand(rs.getString("brand"));
					tempVehicle.setProductionYear(rs.getDate("production_year"));
					tempVehicle.setRegistrationNumber(rs.getString("registration_number"));
					tempVehicle.setNextReviewDate(rs.getDate("next_review_date"));
					tempVehicle.setClientId(rs.getInt("client_id"));
					vehicleList.add(tempVehicle);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

	public static Vehicle loadById(int id) {
		String sql = "Select * from Vehicle where id = ?;";
		Vehicle tempVehicle = new Vehicle();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, id);
			try (ResultSet rs = prepStat.executeQuery()) {
				while (rs.next()) {
					tempVehicle.setId(rs.getInt("id"));
					tempVehicle.setModel(rs.getString("model"));
					tempVehicle.setBrand(rs.getString("brand"));
					tempVehicle.setProductionYear(rs.getDate("production_year"));
					tempVehicle.setRegistrationNumber(rs.getString("registration_number"));
					tempVehicle.setNextReviewDate(rs.getDate("next_review_date"));
					tempVehicle.setClientId(rs.getInt("client_id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempVehicle;
	}
	
	public static List<Vehicle> loadAllbyUserId(int id) {
		String sql="Select * from Vehicle where client_id = ?";
		List<Vehicle> listVeh = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, id);
			try (ResultSet rs = prepStat.executeQuery()) {
				while(rs.next()) {
					Vehicle tempVehicle = new Vehicle();
					tempVehicle.setId(rs.getInt("id"));
					tempVehicle.setModel(rs.getString("model"));
					tempVehicle.setBrand(rs.getString("brand"));
					tempVehicle.setProductionYear(rs.getDate("production_year"));
					tempVehicle.setRegistrationNumber(rs.getString("registration_number"));
					tempVehicle.setNextReviewDate(rs.getDate("next_review_date"));
					tempVehicle.setClientId(rs.getInt("client_id"));
					listVeh.add(tempVehicle);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVeh;
	}

	public static void saveToDb(Vehicle vehicle) {
		int id = vehicle.getId();
		try (Connection con = DbUtil.getConn()) {
			if (id == 0) {
				String sql = "insert into Vehicle (model, brand, production_year, "
						+ "registration_number, next_review_date, client_id) "
						+ "values (?,?,?,?,?,?);";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setString(1, vehicle.getModel());
				prepStat.setString(2, vehicle.getBrand());
				prepStat.setDate(3, vehicle.getProductionYear());
				prepStat.setString(4, vehicle.getRegistrationNumber());
				prepStat.setDate(5, vehicle.getNextReviewDate());
				prepStat.setInt(6, vehicle.getClientId());
				
				prepStat.executeUpdate();
			} else {
				String sql = "update Vehicle set "
						+ "model = ?, brand = ?, production_year = ?, "
						+ "registration_number = ?, next_review_date = ?, client_id =? "
						+ "where id = ?";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setString(1, vehicle.getModel());
				prepStat.setString(2, vehicle.getBrand());
				prepStat.setDate(3, vehicle.getProductionYear());
				prepStat.setString(4, vehicle.getRegistrationNumber());
				prepStat.setDate(5, vehicle.getNextReviewDate());
				prepStat.setInt(6, vehicle.getClientId());
				prepStat.setInt(7, vehicle.getId());
				prepStat.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Vehicle vehicle) {
		String sql = "delete from Vehicle where id = ?;";
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, vehicle.getId());

			prepStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
