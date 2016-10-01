package ex4;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by vika on 05.09.16.
 */
public class JavaExcelMainClass4 {
    //Задаем формат вывода данных типа Дата
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    public static void main(String[] args) throws FileNotFoundException,IOException {
        //Создали поток к файлу, передали в качестве аргумента путь к этому файлу
        FileInputStream fis = new FileInputStream("C:/Temp/123.xls");
        /**
         * Создаем книгу и определяем файл, откуд будем читать
         * getStringCellValue() - используется только для ячеек с типом текст
         */
        Workbook wb = new HSSFWorkbook(fis);
        //Читаем строковые данные
        String result = wb.getSheetAt(1).getRow(0).getCell(0).getStringCellValue();
        System.out.println(result);
        //Читаем числовые данные
        //Будет ошибка
        //String result2 = wb.getSheetAt(1).getRow(0).getCell(1).getStringCellValue();
        //Написав функцию getCellText мы решили эту проблему
        //String result2 = getCellText(wb.getSheetAt(1).getRow(0).getCell(1));
        //System.out.println(result2);
        //Проход по ячейкам выборочно
       /* System.out.println(getCellText(wb.getSheetAt(1).getRow(0).getCell(0)));
        System.out.println(getCellText(wb.getSheetAt(1).getRow(0).getCell(1)));
        System.out.println(getCellText(wb.getSheetAt(1).getRow(0).getCell(2)));
        System.out.println(getCellText(wb.getSheetAt(1).getRow(0).getCell(3))+ " руб");*/

        /**
         * Перебор всех ячеек листа
         */
        for (Row row: wb.getSheetAt(1)) {
            for (Cell cell: row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");
                System.out.println(getCellText(cell));
            }
        }
        fis.close();
    }

    /**
     * Универсальная функция для получения строки из ячейки,
     * в которой может быть
     * текст(String)
     * число
     * булево значение
     * На вход подается ячейка из Excel-документа
     * @param cell
     * @return
     */
    public static String getCellText(Cell cell) {
        String result = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                //System.out.println(cell.getRichStringCellValue().getString());
                result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                /**
                 * Явялется ли ячейка с числами датой
                 */
                if (DateUtil.isCellDateFormatted(cell)) {
                    //Строка с числами является датой
                    //System.out.println(cell.getDateCellValue());
                    //result = cell.getDateCellValue().toString();
                    //Mon Sep 05 00:00:00 GMT+03:00 2016
                    result = sdf.format(cell.getDateCellValue());
                } else {
                    //Строка с числами
                    //System.out.println(cell.getNumericCellValue());
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                //System.out.println(cell.getBooleanCellValue());
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                //System.out.println(cell.getCellFormula());
                result = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return result;
    }
}
