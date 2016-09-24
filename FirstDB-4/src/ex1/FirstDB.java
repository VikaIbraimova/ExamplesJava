package ex1;

import java.sql.*;

/**
 * Created by vika on 19.09.16.
 */

/**
 * Пример работы с БД:
 * ВСТАВКА В ТАБЛИЦУ.НЕТ ПРОВЕРКИ НА ПОВТОРЕНИЕ СТРОК
 */
public class FirstDB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres3";
        String login = "postgres";
        String password = "postgres";
        Connection conn = DriverManager.getConnection(url,login,password);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO Books (id, isdn, nameBook) VALUES ('1','A-1','Java-Head-1')");
        // i - это кол-во вставленных строк
        //int i = stmt.executeUpdate("INSERT INTO Books (id, isdn, nameBook) VALUES ('1','A-1','Java-Head-1')");

       /* int j = stmt.executeUpdate("INSERT INTO Books (id,isdn,nameBook)" +
                " VALUES" +
                " ('1','A-1','Java-Head-1'),"
                + "('2','A-2','Java-Head-2')");
        System.out.println("Result: " + j);
*/
    }
}
