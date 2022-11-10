package pages;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBprogramPOSTGRE {

    public String clearTablePOSTGRE() {
        try {
            var conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/app", "app", "pass"
            );
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM order_entity;");
            statement.execute("DELETE FROM payment_entity;");
            statement.execute("DELETE FROM credit_request_entity;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public String takeFromPurchasePOSTGRE() {
        try {
            var conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/app", "app", "pass"
            );
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT status FROM payment_entity;");
            while (resultSet.next()) {
                String result = resultSet.getString(1);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String takeFromCreditPOSTGRE() {
        try {
            var conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/app", "app", "pass"
            );
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT status FROM credit_request_entity;");
            while (resultSet.next()) {
                String result = resultSet.getString(1);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
