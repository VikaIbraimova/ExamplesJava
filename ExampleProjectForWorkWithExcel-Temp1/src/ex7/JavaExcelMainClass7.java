package ex7;

/**
 * Created by vika on 06.09.16.
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Размеры ячеек
 */
public class JavaExcelMainClass7 {
    public static void main(String[] args) throws FileNotFoundException,IOException {

        //Создали книгу Excel(Excel-документ)
        Workbook wb = new HSSFWorkbook();

        //Создаем лист Excel документа
        Sheet sh0 = wb.createSheet("Лист_01");
        //Создадим строку в листе Excel-документа
        Row row = sh0.createRow(0);
        //Создадим ячейку в этой строке
        Cell cell = row.createCell(0);
        //Запишем в эту ячейку
        cell.setCellValue("Новая ячейка");
        /**
         * Устанавливаем размер ячейки:
         * 1-й параметр - номер ячейки
         * 2-й парамтетр - ширина ячейки
         */
        sh0.setColumnWidth(0,500);
        //высота ячейки
        row.setHeightInPoints(30);
        //Автоматическая подгонка ширины
        sh0.autoSizeColumn(0);



        //Для красоты добавим стиля
        CellStyle style = wb.createCellStyle();
        //Задаем выравниевание текста по горизонтали
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //Задаем выравниевание текста по вертикали
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        //Устанавливаем нижнюю границу
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_DASH_DOT_DOT);
        style.setBorderRight(CellStyle.BORDER_DASH_DOT_DOT);
        style.setBorderTop(CellStyle.BORDER_DASH_DOT_DOT);

        //Применяем стиль к ячейке
        cell.setCellStyle(style);
        /**
         * Объединение ячеек.Аргументы:
         * 1-й - с какой строки начать
         * 2-й - по какую строку
         * 3-й - с какой ячейки начать
         * 4-й - по какую ячейку
         */
        //sh0.addMergedRegion(new CellRangeAddress(0,5,0,2));
        //Определяем файл, в который будем писать
        FileOutputStream fos = new FileOutputStream("C:/Temp/1234.xls");
        //Создается в контексте приложения
        //FileOutputStream fos = new FileOutputStream("1234.xls");
        wb.write(fos);
        fos.close();
        wb.close();
    }
}
