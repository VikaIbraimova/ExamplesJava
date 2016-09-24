package ex9;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by vika on 21.09.16.
 */
public class FirstDB9 {
    public static void main(String[] args) throws ParseException {
        String s="05.09.2013";
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date docDate= format.parse(s);
        System.out.println(docDate);
        SimpleDateFormat newDateFormat = null;
        newDateFormat = new SimpleDateFormat();
        System.out.println("Constructor 1: " + newDateFormat.format( s ) );
    }
}
