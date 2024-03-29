package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Calcul;

public class DAOCalcul {

	static Connection connection = null;

	private static Connection getConnection() {

		String username = "root";
		String password = "1234";
		String url = "jdbc:mysql://localhost:3306/aar4";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			if (connection == null)
				connection = DriverManager.getConnection(url, username,
						password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public int getMaxId() {
		int id = 0;
		Connection connection = getConnection();
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("Select LAST_INSERT_ID()");
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	public int addCalcul(Calcul c) {
		Connection connection = getConnection();
		try {
			CallableStatement call = connection
					.prepareCall("INSERT INTO calcul(num1,num2,lastcalcul) values(?,?,?)");
			call.setInt(1, c.getNum1());
			call.setInt(2, c.getNum2());
			call.setInt(3, c.getLastCalcul());

			call.execute();
			int id = 0;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("Select LAST_INSERT_ID()");
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			call.close();

			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void updatePermalien(int id) {
		Connection connection = getConnection();
		List<Calcul> listCalcul = getCalculById(id);
		if (listCalcul.size() == 0)
			return;
		Statement call;
		for (int i = 0; i < listCalcul.size(); i++) {
			try {
				call = connection.createStatement();
				call.executeUpdate("UPDATE calcul SET permalien=1 WHERE idcalcul="
						+ listCalcul.get(i).getId());
				call.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Calcul> getCalculById(int id) {
		List<Calcul> list = new ArrayList<Calcul>();
		Connection connection = getConnection();
		try {
			Statement call = connection.createStatement();
			ResultSet rs = call
					.executeQuery("SELECT * FROM calcul WHERE idcalcul=" + id);
			int lastCalcul = 0;
			if (rs.next()) {
				lastCalcul = rs.getInt(4);

				Calcul c = new Calcul();
				c.setId(rs.getInt(1));
				c.setNum1(rs.getInt(2));
				c.setNum2(rs.getInt(3));
				c.setLastCalcul(lastCalcul);
				if (rs.getInt(5) == 1)
					c.setPermalien(true);
				else
					c.setPermalien(false);
				list.add(c);
				if (lastCalcul != 0)
					list.addAll(getCalculById(lastCalcul));
			}
			rs.close();
			call.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteHistory(int id) {
		Connection connection = getConnection();
		Statement call;
		try {
			call = connection.createStatement();
			call.executeUpdate("DELETE FROM calcul WHERE permalien=0 AND idcalcul <> "
					+ id);
			call.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getLastSumById(int id) {
		Connection connection = getConnection();
		int num1 = 0, num2 = 0;
		try {
			Statement call = connection.createStatement();
			ResultSet rs = call
					.executeQuery("SELECT * FROM calcul WHERE idcalcul=" + id);

			while (rs.next()) {
				num1 = rs.getInt(2);
				num2 = rs.getInt(3);
			}
			rs.close();
			call.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num1 + num2;

	}
}
