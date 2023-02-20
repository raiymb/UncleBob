import java.sql.*;

public class Balance {
    private String username;

    public Balance(String username) {
        this.username = username;
    }

    public boolean add(double amount) {
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

    public double show() {
        double balance = -1;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "raimbek99");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT balance FROM users WHERE username = ?");
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            } else {
                System.out.println("Error: User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }
}