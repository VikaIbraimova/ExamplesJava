package ex10;

/**
 * Created by vika on 06.09.16.
 */
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Line chart example.
 */

/**
 * В данном примере показывается, как нарисовать график в Excel, используя пример
 * https://svn.apache.org/repos/asf/poi/trunk/src/examples/src/org/apache/poi/xssf/usermodel/examples/LineChart.java
 *
 */
public class JavaExcelMainClass10 {

    public static void main(String[] args) throws Exception {
        //1)Создается книга, сипользуется библиотека XSSFWorkbook - это для xlsx-файлов
        Workbook wb = new XSSFWorkbook();
        //2)Создается лист Excel-документа
        Sheet sheet = wb.createSheet("linechart");
        //3)Определяется кол-во строки и столбцов в таблице:
        final int NUM_OF_ROWS = 3;
        final int NUM_OF_COLUMNS = 10;

        Row row2 = sheet.createRow(20);
        Cell cell2 = row2.createCell(3);
        cell2.setCellValue("Для синего графика: значения по x - это первая строка, по y - это вторая строка.Для красного графика:значения по x - это первая строка, по y - это третья строка.");
        // Create a row and put some cells in it. Rows are 0 based.
        Row row;
        Cell cell;
        //4)Пробегаемся по таблице
        //Создаем строки
        for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
            row = sheet.createRow((short) rowIndex);
            //Создаем столбцы
            for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
                cell = row.createCell((short) colIndex);
                cell.setCellValue(colIndex * (rowIndex + 1));
            }
        }

        /**
         * 5)Используя объект sheet(лист Excel-документа) создаем объект drawing(хотя Drawing - это интерфейс)
         */
        Drawing drawing = sheet.createDrawingPatriarch();
        /**
         * ClientAnchor - это область расположения нашего графика
         * !!!В скобках важны последние четыре значения: 0 5 - нулевая колонка пятая строка, 10 15 - десятая колонка пятьнадцатая строка - это
         * область риосвания наших графиков
         */

        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);
        /**
         * 6)Создаем график(Chart chart) и с помощью объекта drawing его рисуем,
         * связывая с областью рисования anchor
         */
        Chart chart = drawing.createChart(anchor);
        //Создаем легенду(описание) к графику
        ChartLegend legend = chart.getOrCreateLegend();
        //Задается расположение легенды
        //legend.setPosition(LegendPosition.TOP_RIGHT);
        legend.setPosition(LegendPosition.TOP);

        /**
         * 7а)Заполняется график данными -формируется коробка для данных
         */
        LineChartData data = chart.getChartDataFactory().createLineChartData();

        // Use a category axis for the bottom axis.
        //Рисование самих графиков - неясно как
        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        /**
         * 7б)УКазываем значения(указываем лист в скобках) - диапазон значений(fromNumericCellRange):
         * !!!Для первого графика(xs,ys1),для второго(xs,ys2)
         * для x(xs): 1-ая строка, последняя строка,1-ая колнка,последняя колонка
         * для y(ys1):
         */
        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 0, NUM_OF_COLUMNS - 1));
        ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 0, NUM_OF_COLUMNS - 1));
        ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 2, 0, NUM_OF_COLUMNS - 1));

        /**
         * Сформрованные значения из 7б мы кладем в 7а, тоесть имея значения формируем графики
         */
        data.addSeries(xs, ys1);
        data.addSeries(xs, ys2);

        /**
         * Кладем графики на область диаграммы.Здесь три аргумента:
         * date - какие значения отобразить на графике
         * bottomAxis -
         */
        chart.plot(data, bottomAxis, leftAxis);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("OoxmLlineChart.xlsx");
        //FileOutputStream fos = new FileOutputStream("C:/Temp/OoxmLlineChart.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }
}