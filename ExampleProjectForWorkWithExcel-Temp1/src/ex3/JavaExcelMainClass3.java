package ex3;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

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
 * 5)Создадим строку в листе Excel-документа
 * 6)Создадим ячейку в новой строке в листе Excel-документа
 */
public class JavaExcelMainClass3 {
    public static void main(String[] args) throws IOException {

        //Создали книгу Excel(Excel-документ)
        Workbook wb = new HSSFWorkbook();

        //Создаем лист Excel документа
        Sheet sh0 = wb.createSheet("Издатели");
        //Создадим строку в листе Excel-документа
        Row row = sh0.createRow(3);
        //Создадим ячейку в этой строке
        Cell cell = row.createCell(4);
        //Запишем в эту ячейку
        cell.setCellValue("O'Relly");

        Sheet sh1 = wb.createSheet("Произведения");
        //Создадим строку в листе Excel-документа
        Row row1 = sh1.createRow(0);
        //Создадим ячейку в этой строке
        Cell cell1 = row1.createCell(0);
        //Запишем в эту ячейку
        cell1.setCellValue("Война и Мир");
        Row row2 = sh1.createRow(1);
        Cell cell2 = row2.createCell(3);
        cell2.setCellValue("Евгений Онегин");

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
