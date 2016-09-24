package ex5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vika on 20.09.16.
 */
//Вариант с парметрами для интерфейса PreparedStatement
public class FirstDB5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String login = "postgres";
        String password = "postgres";
        Connection conn = DriverManager.getConnection(url,login,password);
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM books WHERE id = ?");
        stmt.setInt(1,3);
        /**
         * Для задания параметра-даты: java.sql.Date
         * Однако здесь чисто дата, без времени!!!
         */
        //stmt.setDate(2,new java.sql.Date(System.currentTimeMillis()));
        /**
         * TimeStamp - содержит дату, время + часовой пояс - это не для всех удобно и нужно
         * В СберТехе идет преобразование даты в строчку и идет работы со строкой
         */
        //stmt.setTimestamp();
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String id = (rs.getString("id")).trim();
            String isdn = (rs.getString("isdn")).trim();
            String nameBook = (rs.getString("nameBook")).trim();
            System.out.println("id : " + id + " -isdn : " + isdn + " -nameBook : " + nameBook);
        }
    }
}
