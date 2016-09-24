package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Пример работы с БД:
 * УДАЛЕНИЕ СТРОКИ В ТАБЛИЦЕ.НЕТ ПРОВЕРКИ НА ПОВТОРЕНИЕ СТРОК
 */
public class FirstDB2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres3";
        String login = "postgres";
        String password = "postgres";
        Connection conn = DriverManager.getConnection(url,login,password);
        Statement stmt = conn.createStatement();
        int k = stmt.executeUpdate("DELETE FROM Books WHERE id = '1'");

    }
}
