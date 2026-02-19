import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DBConnection {

    public Connection getConnection() {

        try {
            Dotenv dotenv = Dotenv.load();

            String jdbcUrl = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");

            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
    }

    public void closeConnection(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erreur lors de la fermeture de la connexion", e);
            }
        }
    }
}
