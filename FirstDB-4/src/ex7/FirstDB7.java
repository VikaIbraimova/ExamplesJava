package ex7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vika on 20.09.16.
 */
public class FirstDB7 {
    public static void main(String[] args) throws ParseException {
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
        System.out.println(date);

// преобразование даты в строку используя второй формат
        System.out.println(format2.format(date));
    }
}
