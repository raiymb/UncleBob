import java.sql.*;
import java.util.Scanner;

public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "raimbek99");

            // Check if the user's credentials are valid
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'");
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
