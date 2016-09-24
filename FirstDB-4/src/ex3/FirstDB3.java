package ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Пример работы с БД:
 * ИЗМЕНЕНИЕ СТРОКИ В ТАБЛИЦЕ.
 */
public class FirstDB3 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres3";
        String login = "postgres";
        String password = "postgres";
        Connection conn = DriverManager.getConnection(url,login,password);
        Statement stmt = conn.createStatement();
        int h = stmt.executeUpdate("UPDATE Books SET nameBook = 'Frameworks in Java' WHERE isdn = 'A1B1-C' ");

    }
}