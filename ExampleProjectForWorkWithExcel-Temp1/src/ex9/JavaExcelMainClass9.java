package ex9;

/**
 * Created by vika on 06.09.16.
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * В этом примере показывается как с помощью библиотеки ApachePOI
 * создать документ формата XLSX
 */
public class JavaExcelMainClass9 {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        //Это пример создания файла старого формата(97-2003 Excel)------------------
        //Создали книгу Excel
       /* Workbook wb = new HSSFWorkbook();
        //Определяем файл, в который будем писать
        FileOutputStream fos = new FileOutputStream("C:/Temp/9.xls");
        //Создаем лист Excel документа
        Sheet sh1 = wb.createSheet("Произведения");
        //Создадим строку в листе Excel-документа
        Row row1 = sh1.createRow(3);
        //Создадим ячейку в этой строке
        Cell cell1 = row1.createCell(4);
        cell1.setCellValue("O'Relly");
        wb.write(fos);
        fos.close();*/
        //------------------------------------------------------------------------

        /**
         * 1)Для создания Excel-файла формата XLSX, нужно использовать
         * другую библиотеку, не HSSFWorkbook как выше
         * Другими словами нужно использовать не класс HSSFWorkbook(),
         * а другой класс. А чтобы использовать другой класс, нужно подключить дополнительные библиотеки в проект:
         * poi-ooxml,poi-ooxml-schemas.
         * И еще одну из папки ooxml-lib ->xmlbeans
         * 2)Заменить HSSFWorkbook на XSSFWorkbook
         * 3)У меня файлы с расширением xlsx не открываются
         */
        //Создали книгу Excel
        Workbook wb = new XSSFWorkbook();
        //Определяем файл, в который будем писать
        FileOutputStream fos = new FileOutputStream("9.xlsx");
        //Создаем лист Excel документа
        Sheet sh1 = wb.createSheet("Произведения");
        //Создадим строку в листе Excel-документа
        Row row1 = sh1.createRow(3);
        //Создадим ячейку в этой строке
        Cell cell1 = row1.createCell(4);
        cell1.setCellValue("O'Relly");
        wb.write(fos);
        fos.close();


    }
}
