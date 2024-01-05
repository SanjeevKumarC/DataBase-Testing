package TSQLandAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static String dbName="users";
	public static void main(String[] args) {
		// JDBC URL, username, and password of MySQL server
		String jdbcUrl = "jdbc:mysql://localhost:3306/"+dbName;
		String username = "root";
		String password = "1234";

		// JDBC variables for opening, closing, and managing connection
		Connection connection = null;

		try {
			// Registering the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Opening a connection
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(jdbcUrl, username, password);

			System.out.println("Connected to the database!");

			// Perform database operations here...
			createTable(connection);

			// Inserting data
			insertData(connection, "SanjeevKumar", "sanjeev@testyantra.com");

			// Querying data
			queryData(connection);

			// Updating data
			System.out.println("Updating the data");
			updateData(connection, "SanjeevKumar", "sanjeev@fireflink.com");

			// Querying data after update
			queryData(connection);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the connection
				if (connection != null && !connection.isClosed()) {
					connection.close();
					System.out.println("Connection closed.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void createTable(Connection connection) throws SQLException {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS "+dbName+" (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "username VARCHAR(255) NOT NULL," + "email VARCHAR(255) NOT NULL" + ")";

		try (Statement statement = connection.createStatement()) {
			statement.execute(createTableSQL);
		}
	}

	private static void insertData(Connection connection, String username, String email) throws SQLException {
		String insertDataSQL = "INSERT INTO "+dbName+" (username, email) VALUES (?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.executeUpdate();
		}
	}

	private static void queryData(Connection connection) throws SQLException {
		String queryDataSQL = "SELECT * FROM "+dbName+"";

		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(queryDataSQL)) {

			System.out.println("Querying data from "+dbName+" table:");

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");

				System.out.println("ID: " + id + ", Username: " + username + ", Email: " + email);
			}
			System.out.println();
		}
	}

	private static void updateData(Connection connection, String username, String newEmail) throws SQLException {
		String updateDataSQL = "UPDATE "+dbName+" SET email = ? WHERE username = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(updateDataSQL)) {
			preparedStatement.setString(1, newEmail);
			preparedStatement.setString(2, username);
			preparedStatement.executeUpdate();
		}
	}
}
