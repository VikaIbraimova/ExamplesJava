package ex8;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by vika on 06.09.16.
 */
public class JavaExcelMainClass8 {
    public static void main(String[] args) throws FileNotFoundException,IOException {

        //Создали книгу Excel(Excel-документ)
        Workbook wb = new HSSFWorkbook();

        //Создаем лист Excel документа
        Sheet sh0 = wb.createSheet("Картинки");

        /**
         * Для создания картинки нужно создать
         * три вещи:
         * 1)художник
         * 2)область рисования нашей фигуры
         * 3)
         */
        //Создаем художника
        HSSFPatriarch patriarch = (HSSFPatriarch) sh0.createDrawingPatriarch();
        //Создаем область рисования
        HSSFClientAnchor anchor = new HSSFClientAnchor();
        anchor.setCol1(2);
        anchor.setRow1(2);
        anchor.setCol2(10);
        anchor.setRow2(10);

        //Создаем саму фигуру.!!!Фигуру создает художник(patriarch)
        HSSFSimpleShape  shape = patriarch.createSimpleShape(anchor);
        //Определим тип фигуры.Здесь линия
        shape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
        //Определим тип фигуры.Здесь овал
        shape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);
        //Заполним овал цветом
        shape.setFillColor(0,0,255);
        /**
         * Зададим цвет фигуры.Можно тремя цветами: красный, зелный,синий
         * Если хоти красный, значит 255,а отсальные ноль
         */
        shape.setLineStyleColor(255,0,0);
        //Установим толщину фигуры.Она берется из класса HSSSimpleShape.LINEWIDTH_ONE_PT - это статическое поле, минимальное значение
        shape.setLineWidth(HSSFSimpleShape.LINEWIDTH_ONE_PT*3);
        //Задаим тип линии(точка-тире-точка)
        shape.setLineStyle(HSSFSimpleShape.LINESTYLE_DASHDOTSYS);

        //Определяем файл, в который будем писать
        FileOutputStream fos = new FileOutputStream("C:/Temp/1234.xls");
        //Создается в контексте приложения
        //FileOutputStream fos = new FileOutputStream("1234.xls");
        wb.write(fos);
        fos.close();
        wb.close();
    }
}
