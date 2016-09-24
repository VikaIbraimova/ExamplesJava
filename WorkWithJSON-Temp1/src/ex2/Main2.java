package ex2;

/**
 * Created by vika on 24.09.16.
 */



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * В данном примере показывается как можно распарсить HTML:
 * 1)Распарсим заголовок статьи+ссылку на эту статью
 * Для этого будем использовать библиотеку jsoup-1.9.2.jar
 * Парсить будем сайт 4pda.ru
 */
public class Main2  {
    public static void main(String[] args) throws IOException {
        //Список,в котром хранятся наши распарсенные статьи
        List<Article> articleList = new ArrayList<>();
        Document doc = Jsoup.connect("http://4pda.ru").get();
        /**
         * Анализ считанного документа с сайта
         * Пробегаемся по элементам(тегам) h1 страницы,
         * у которых атрибут - class, со значением list-post-title
         */
        Elements h1Elements = doc.getElementsByAttributeValue("class","list-post-title");
        h1Elements.forEach(h1Elemetn -> {
            /**
             * Берем первый элемент после строки <h1 class="list-post-title" itemprop="headline">
             */
            Element aElement = h1Elemetn.child(0);
            /**
             * Временная переменная, куда поместим значение ссылки, которую только что вырезали
             */
        String urlTemp = aElement.attr("href");
            /**
             * Получим значение текста, который привязан к этой ссылке(на текст щелкаешь и открываетсчя страница)
             */
        String textTemp = aElement.child(0).text();
            /**
             * Название и адрес считанной статьи в наш список статей станицы, которую мы парсим
             */
            articleList.add(new Article(urlTemp,textTemp));
        });
        //Выведим список на экран
        articleList.forEach(System.out::println);
    }
}

/**
 * Класс, вк котором будет хранится инфа о каждой из наших статей
 */
class Article{
    private String url;
    private String name;

    public Article(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}