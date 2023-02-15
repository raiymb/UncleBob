import java.sql.*;

public class Payment {
    private String username;
    private double price;

    public Payment(String username, double price) {
        this.username = username;
        this.price = price;
    }

    public boolean makePayment() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "raimbek99");

            PreparedStatement getUserStatement = connection.prepareStatement("SELECT balance FROM users WHERE username = ?");
            getUserStatement.setString(1, username);
            ResultSet resultSet = getUserStatement.executeQuery();
            if (!resultSet.next()) {
                return false;
            }
            int balance = resultSet.getInt(1);

            if (balance < price) {
                return false;
            }

            PreparedStatement updateBalanceStatement = connection.prepareStatement("UPDATE users SET balance = ? WHERE username = ?");
            updateBalanceStatement.setInt(1, balance - (int)price);
            updateBalanceStatement.setString(2, username);
            updateBalanceStatement.executeUpdate();

            PreparedStatement addPaymentStatement = connection.prepareStatement("INSERT INTO payments (username, amount) VALUES (?, ?)");
            addPaymentStatement.setString(1, username);
            addPaymentStatement.setDouble(2, price);
            addPaymentStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}