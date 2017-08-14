package nl.plaatsoft.cyber.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;

@WebService(endpointInterface = "nl.plaatsoft.cyber.server.Server")

public class ServerImpl implements Server {

	static final String DB_URL = "jdbc:mysql://127.0.0.1/plaatcyber?serverTimezone=UTC";
	static final String USER = "plaatcyber";
	static final String PASS = "plaatcyber";
	
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

	public String getElements() {
		return loadElements();
	}

	private String loadElements() {

		String answer = "";
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT eid, name, level, price, build_time FROM element";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int eid = rs.getInt("eid");
				String name = rs.getString("name");
				int level = rs.getInt("level");
				int price = rs.getInt("price");
				int buildtime = rs.getInt("build_time");
	
				// Display values
				answer += "eid: " + eid;
				answer += " name: " + name;
				answer += " level: " + level;
				answer += " price: " + price;
				answer += " buildtime: " + buildtime +"\n\r";
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return answer;
	}
}
