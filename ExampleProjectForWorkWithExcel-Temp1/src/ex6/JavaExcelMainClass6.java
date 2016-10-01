package ex6;

/**
 * Created by vika on 05.09.16.
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Пример работы со стилям и шрифтами
 */
public class JavaExcelMainClass6 {
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
        cell.setCellValue("Привет");

        //Начинаем заниматься внешним видом ячеек - Определяем стиль
        CellStyle style = wb.createCellStyle();
        /**
         * Задаем тип кисти
         * SOLID_FOREGROUND - сплошной цвет
         */
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        //Определяем сам цвет
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        //Баг - он не работает!!!!
        //style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
        //Задаем выравниевание текста по горизонтали
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //Задаем выравниевание текста по вертикали
        style.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        //Устанавливаем нижнюю границу
        style.setBorderBottom(CellStyle.BORDER_DASH_DOT_DOT);
        //Устанавливаем цвет нижней границы
        style.setBottomBorderColor(IndexedColors.BRIGHT_GREEN.getIndex());

        //Поработаем со словом в ячейке
        Font font = wb.createFont();
        //Задаем тип шрифта(Timew New Roman,Arial,...).Точное имя шрифта берем из Excel-документа
        font.setFontName("Courier New");
        //Высота шрифта
        font.setFontHeightInPoints((short) 15);
        //Толщина букв.Зададим, чтобы буквы были толстые
        font.setBold(true);
        //Сделаем текст зачеркнутым
        font.setStrikeout(true);
        //Сделаем текст подчеркнутым
        font.setUnderline(Font.U_SINGLE);
        //Установим цвет текста - сделаем красный
        font.setColor(IndexedColors.RED.getIndex());
        //Создыннй фон применяем к нашему стилю
        style.setFont(font);

        //Применяем стиль к ячейке
        cell.setCellStyle(style);

        //Определяем файл, в который будем писать
        FileOutputStream fos = new FileOutputStream("C:/Temp/1234.xls");
        wb.write(fos);
        fos.close();
        wb.close();
    }
}
