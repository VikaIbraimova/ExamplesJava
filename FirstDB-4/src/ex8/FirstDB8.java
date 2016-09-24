package ex8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by vika on 21.09.16.
 */
public class FirstDB8 {
    public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
        //Входная дата
        String original = "21.03.2006";

// первый формат
        SimpleDateFormat format1 = new SimpleDateFormat();
        format1.applyPattern("dd.mm.yyyy");

// второй формат
        SimpleDateFormat format2 = new SimpleDateFormat();
        format2.applyPattern("yyyy-mm-dd");

// преобразование в дату используя первый формат
        Date date = format1.parse(original);
        System.out.println("format1,тип Date" + date);

// преобразование даты в строку используя второй формат
        String sDate = format2.format(date);
        System.out.println(sDate);

        String s="2006-03-21";
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date docDate= format.parse(s);
        System.out.println(docDate);


        //Вставка новой даты в таблицу
       /* Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres3";
        String login = "postgres";
        String password = "postgres";
        Connection conn = DriverManager.getConnection(url,login,password);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO money (city, kurs_begin, kurs_end,date) VALUES ('Kirovsk','50','52',"+ docDate+")");*/
    }
}
