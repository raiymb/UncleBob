import java.sql.*;
public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "raimbek99");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
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

    public boolean addBalance(double amount) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "raimbek99");

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET balance = balance + ? WHERE username = ?");
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, username);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public double showBalance() {
        double balance = -1; // set default value in case of error
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "raimbek99");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT balance FROM users WHERE username = ?");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
                System.out.printf("Your balance is %.2f\n", balance);
            } else {
                System.out.println("Error: User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }
}
