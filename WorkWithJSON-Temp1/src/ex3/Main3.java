package ex3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vika on 25.09.16.
 */

/**
 * Пример парсит сайт магазина Лента:
 * 1)Заходит на страницу с акциями
 * 2)Выводит список всех актуальных акций магазина
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        //Список,в котром хранятся наши распарсенные статьи
        List<Action> articleList = new ArrayList<>();
        Document doc = Jsoup.connect("http://lenta.com/page/1071/").get();
        //Анализ
        Elements divElements = doc.getElementsByAttributeValue("class","list-item__title");
            divElements.forEach(divElemetn ->{
                /**
                 * Берем первый элемент после строки <div class="list-item__title" style="margin-bottom: 3px;">
                 */
                Element aElement = divElemetn.child(0);
                /**
                 * Временная переменная, куда поместим значение ссылки, которую только что вырезали
                 */
                String urlTemp = aElement.attr("href");
                /**
                 * Получим значение текста, который привязан к этой ссылке(на текст щелкаешь и открываетсчя страница)
                 */
                //String textTemp = aElement.child(0).text();
                //String textTemp = aElement.attr("href").intern();
                String textTemp = divElemetn.child(0).text();
                /**
                 * Название и адрес считанной статьи в наш список статей станицы, которую мы парсим
                 */
                //articleList.add(new Action(urlTemp,textTemp));
                articleList.add(new Action(textTemp));
            });
        //Выведим список на экран
        articleList.forEach(System.out::println);
        }
    }

class Action {
    //private String url;
    private String name;

    public Action(/*String url,*/ String name) {
        //this.url = url;
        this.name = name;
    }

   /* public String getUrl() {
        return url;
    }*/

    /*public void setUrl(String url) {
        this.url = url;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@Override
    public String toString() {
        return "Action{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                '}';
    }
}
