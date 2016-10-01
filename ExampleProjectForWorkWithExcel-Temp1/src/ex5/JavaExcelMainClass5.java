package ex5;

/**
 * Created by vika on 05.09.16.
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * В этом примере показывается как можно работать с ячейками, в которых данные
 * задаются по формуле
 * Здесь мы пишем в файл
 */
public class JavaExcelMainClass5 {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        Workbook wb = new HSSFWorkbook();
        //Создаем лист Excel документа
        Sheet sh1 = wb.createSheet("Формулы");
        Row row = sh1.createRow(0);
        //Создадим ячейку в этой строке
        Cell cell0 = row.createCell(0);
        //Запишем в эту ячейку
        cell0.setCellValue(2);
        //Создадим ячейку в этой строке
        Cell cell1 = row.createCell(1);
        //Запишем в эту ячейку
        cell1.setCellValue(7);
        //В этой ячейке будем складывать значения ячеек 0 и 1
        Cell cell2 = row.createCell(2);
        //Запишем в эту ячейку сумму двух ячеек
        cell2.setCellFormula("A1+B1");

        //Суммирование группы ячеек
        Row row1 = sh1.createRow(1);
        //Создадим ячейку в этой строке
        Cell cell3 = row1.createCell(0);
        //Запишем в эту ячейку
        cell3.setCellValue(2);

        Row row2 = sh1.createRow(2);
        //Создадим ячейку в этой строке
        Cell cell4 = row2.createCell(0);
        //Запишем в эту ячейку
        cell4.setCellValue(2);

        Row row3 = sh1.createRow(3);
        Cell cell5 = row3.createCell(0);
        cell5.setCellValue(2);

        Row row4 = sh1.createRow(4);
        Cell cell6 = row4.createCell(0);
        cell6.setCellFormula("SUM(A1:A4)");

        //Определяем файл, в который будем писать
        FileOutputStream fos = new FileOutputStream("C:/Temp/1234.xls");
        wb.write(fos);
        fos.close();
        wb.close();

    }
}
