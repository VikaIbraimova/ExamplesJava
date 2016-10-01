package ex2;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by vika on 05.09.16.
 */

/**
 * В данном примере показывается:
 * 1)Как создать
 * 2)Как сохранить Excel-документ
 * 3)Как создать несколько листов
 * 4)Как обойти запрет на имя с спец.символами
 */
public class JavaExcelMainClass2 {
    public static void main(String[] args) throws IOException {
        //Создали книгу Excel(Excel-документ)
        Workbook wb = new HSSFWorkbook();
        //Создаем лист Excel документа
        Sheet sh0 = wb.createSheet("Издатели");
        Sheet sh1 = wb.createSheet("Книги");
        Sheet sh2 = wb.createSheet("Авторы");
        /**
         * Проблема может быть с именем листа
         * Выходит вот такая ошибка  Invalid char (*) found at index (4) in sheet name 'd3sd*^^^*^*ujbkjy*7'
         */
        //Sheet sh3 = wb.createSheet("d3sd*^^^*^*ujbkjy*7");
        //Обходим эту проблему
        Sheet sh3 = wb.createSheet(WorkbookUtil.createSafeSheetName("d3sd*^^^*^*ujbkjy*7"));
        //Создадим файл, куда будем все это записывать()
        FileOutputStream fos = new FileOutputStream("C:/Temp/123.xls");
        //Записываем книгу в файл
        wb.write(fos);
        //Закрываем поток
        fos.close();
    }
}
