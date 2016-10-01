package ex1;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by vika on 05.09.16.
 */
/**
 * Все примеры кода берутся из след.источника:
 * http://poi.apache.org/spreadsheet/quick-guide.html
 */

/**
 * В данном примере показывается как создать и сохранить Excel-документ
 * !!!ВАЖНО: Для работы с Excel-документами нужно скачать с сайта
 * и подключить библиотеку
 */
public class JavaExcelMainClass {
    public static void main(String[] args) throws IOException {
        //Создали книгу Excel
        /**
         * Workbook - это интерфейс
         * HSSFWorkbook - это класс, который позволяет работать с Excel 98-2003 годов
         * Sheet - это интерфейс
         */
        Workbook wb = new HSSFWorkbook();
        //Создаем лист Excel документа
        Sheet sh = wb.createSheet("Лист 1");
        //Создадим файл, куда будем все это записывать
        FileOutputStream fos = new FileOutputStream("C:/Temp/123.xls");
        //Записываем книгу в файл
        wb.write(fos);
        //Закрываем поток
        fos.close();
    }
}
