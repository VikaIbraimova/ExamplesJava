package ex6;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by vika on 20.09.16.
 */
public class FirstDB6 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        SimpleDateFormat dateFormat = null;

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres3";
        String login = "postgres";
        String password = "postgres";
        Connection conn = DriverManager.getConnection(url,login,password);

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM money");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            /**
             * Если мы не уверены, что в этом поле таблицы данные типа Дата
             */
            //String originalDate = (rs.getString("date")).trim();
            /**
             * Если мы точно знаем, что в этом поле таблицы данные имеют тип Дата
             */
            Date originalDate = rs.getDate("date");
            //System.out.println("id : " + id + "isdn : " + isdn + "nameBook : " + nameBook);
            System.out.println("date: " + originalDate);
            /**
             * Просто меняем формат представления даты
             */
            dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            System.out.println("Constructor 2: " + dateFormat.format( originalDate ) );

            /**
             * В таблице формат даты: 1994-11-27.Мы переделываем формат на 27.11.1994
             * В данном пример у нас из таблицы пришло поле типа Дата(смотри строку 33) и
             * мы переделываем формат представления даты+сохраняем в строковой переменной
             */
            try {

                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                //String sDate = sdf.format(new Date(System.currentTimeMillis()));
                String sDate = sdf.format(originalDate);
                //Date uDate = sdf.parse("23.01.1999 06:34");
                //System.out.println("current date time: " + sDate+"\nuser date: "+uDate);
                System.out.println("sDate: " + sDate);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
