package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.model.Status;

public class StatusDao {

	public static List<Status> loadAll() {
		String sql = "Select * from Status;";
		List<Status> statusList = new ArrayList<>();
		try (Connection con = DbUtil.getConn()) {
			Statement stat = con.createStatement();
			try (ResultSet rs = stat.executeQuery(sql)) {
				while (rs.next()) {
					Status tempStat = new Status();
					tempStat.setId(rs.getInt("id"));
					tempStat.setStatus(rs.getString("status"));					
					statusList.add(tempStat);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusList;
	}

	public static Status loadById(int id) {
		String sql = "Select * from Status where id = ?;";
		Status tempStat = new Status();
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, id);
			try (ResultSet rs = prepStat.executeQuery(sql)) {
				while (rs.next()) {
					tempStat.setId(rs.getInt("id"));
					tempStat.setStatus(rs.getString("status"));					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempStat;
	}

	public static void saveToDb(Status status) {
		int id = status.getId();
		try (Connection con = DbUtil.getConn()) {
			if (id == 0) {
				String sql = "insert into Status "
						+ "(status) "
						+ "values (?);";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setString(1, status.getStatus());
				prepStat.executeUpdate();
			} else {
				String sql = "update Status set status = ? where id=?";
				PreparedStatement prepStat = con.prepareStatement(sql);
				prepStat.setString(1, status.getStatus());
				prepStat.setInt(2, status.getId());
				prepStat.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Status status) {
		String sql = "delete from Status where id = ?;";
		try (Connection con = DbUtil.getConn()) {
			PreparedStatement prepStat = con.prepareStatement(sql);
			prepStat.setInt(1, status.getId());

			prepStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
