package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Calcul;

public class DAOCalcul {
	private static Connection getConnection() {
		Connection connection = null;

		String username = "root";
		String password = "1234";
		String url = "jdbc:mysql://localhost:3306/aar4";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public int addCalcul(Calcul c) {
		Connection connection = getConnection();
		try {
			CallableStatement call = connection
					.prepareCall("INSERT INTO calcul(num1,num2,result) values(?,?,?)");
			call.setInt(1, c.getNum1());
			call.setInt(2, c.getNum2());
			call.setInt(3, c.getResult());

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

	public Calcul getCalculById(int id) {
		Calcul c = new Calcul();
		Connection connection = getConnection();
		try {
			CallableStatement call = connection
					.prepareCall("SELECT * FROM calcul WHERE idcalcul=" + id);
			call.execute();
			c.setId(call.getInt(1));
			c.setNum1(call.getInt(2));
			c.setNum2(call.getInt(3));
			c.setResult(call.getInt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
