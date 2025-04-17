package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/redalert";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection connection;

    // Set up the connection in the Constructor
    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Veritabanına bağlan
            this.connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, QueryExecutor executor) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            executor.execute(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public interface PreparedStatementSetter {
        void setValues(PreparedStatement preparedStatement) throws SQLException;
    }
    public interface QueryExecutor {
        void execute(PreparedStatement preparedStatement) throws SQLException;
    }

}
