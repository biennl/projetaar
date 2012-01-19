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

	public int addCalcul(Calcul c) {
		Connection connection = getConnection();
		try {
			CallableStatement call = connection
					.prepareCall("INSERT INTO calcul(num1,num2,result,idsession) values(?,?,?,?)");
			call.setInt(1, c.getNum1());
			call.setInt(2, c.getNum2());
			call.setInt(3, c.getResult());
			call.setString(4, c.getIdSession());

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

	public List<Calcul> getCalculById(int id, String idSession) {
		List<Calcul> list = new ArrayList<Calcul>();
		Connection connection = getConnection();
		try {
			Statement call = connection.createStatement();
			ResultSet rs = call
					.executeQuery("SELECT * FROM calcul WHERE idsession="
							+ idSession + " and idcalcul <= " + id);
			if (rs.next()) {
				Calcul c = new Calcul();
				c.setId(rs.getInt(1));
				c.setNum1(rs.getInt(2));
				c.setNum2(rs.getInt(3));
				c.setResult(rs.getInt(4));
				c.setIdSession(rs.getString(5));
				list.add(c);
			}
			rs.close();
			call.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
