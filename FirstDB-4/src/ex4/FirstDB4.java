package ex4;

import java.sql.*;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FirstDB4 {
    public static void main(String[] args) throws Exception {

        /**
         * Работа с датой:
         * http://www.seostella.com/ru/article/2012/02/05/formatirovanie-daty-v-java.html
         * Показаны все четыре конструктора класса SimpleDateFormat для
         * форматирования внешнего вида выводимой даты
         * Для преобразования даты и времени в строку и обратно используется класс SimpleDateFormat.
         *
         */

        SimpleDateFormat dateFormat = null;

       /* Date currentDate = new Date();
        dateFormat = new SimpleDateFormat();
        System.out.println("Constructor 1: " + dateFormat.format( currentDate ) );

        dateFormat = new SimpleDateFormat("dd MMMM");
        System.out.println("Constructor 2: " + dateFormat.format( currentDate ) );

        dateFormat = new SimpleDateFormat("dd MMMM", myDateFormatSymbols );
        System.out.println("Constructor 3: " + dateFormat.format( currentDate ) );

        dateFormat = new SimpleDateFormat("dd MMMM", Locale.ENGLISH);
        System.out.println("Constructor 4: " + dateFormat.format( currentDate ) );*/

        //------------------------------------------------------------------------

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String login = "postgres";
        String password = "postgres";
        Connection conn = DriverManager.getConnection(url,login,password);
        /**
         * Варианты получения данных
         * Вариант 1: интерфейс Statement
         * Минусы Statement:
         * 1)передача параметров(ур15 часть 2 мин 12)
         * 2)нет защиты от SQL-иньекций
         */
        /**
         * Вариант 2: интерфейс PreparedStatement - это наследник Statement - позволяет
         * создавать параметризованные запросы - запросы в которых определены места для парамтров
         */
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM books");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String id = (rs.getString("id")).trim();
            String isdn = (rs.getString("isdn")).trim();
            String nameBook = (rs.getString("nameBook")).trim();
            System.out.println("id : " + id + "isdn : " + isdn + "nameBook : " + nameBook);

            /**
             * Добавила вывод системного времени
             * Сейчас выводится просто системная дата + системное время
             */
            //System.out.println("id : " + id + "isdn : " + isdn + "nameBook : " + nameBook + new Date());
            /**
             * Добавим форматирование даты
             */
            //Вариант 1
            //dateFormat = new SimpleDateFormat();
            //Вариант 2
            //dateFormat = new SimpleDateFormat("dd MMMM");
            //Вариант 3
            //dateFormat = new SimpleDateFormat("dd MMMM", myDateFormatSymbols );
            //Вариант 4
            //dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
            //System.out.println("id : " + id + "isdn : " + isdn + "nameBook : " + nameBook + " " + dateFormat.format(new Date()));
        }
    }

    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){

        @Override
        public String[] getMonths() {
            return new String[]{"января", "февраля", "марта", "апреля", "мая", "июня",
                    "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        }

    };
}
