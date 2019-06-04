package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMyAQL {

    public static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Runtime.getRuntime().addShutdownHook(new getClose());
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/db_cadela", "root", "q1w2e3r4.");
            }
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Conexión fallida", e);
        }
    }

    static class getClose extends Thread{
        @Override
        public void run() {
            try {
                Connection conn = ConexionMyAQL.getConnection();
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
