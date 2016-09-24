package ex1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * Created by vika on 24.09.16.
 */

/**
 * В данном примере используется библиотека gson-2.6.2.jar,
 * которая преобразует данные класса в json-формат и наоборот
 */
public class Main {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        Person person1 = new Person("Ivan",30,Arrays.asList("Kirovsk","SpB","Zurich"));
        String json = GSON.toJson(person1);
        System.out.println(json);

        /**
         * Конвертируем обратно из json в поля класса Person
         */
        Person person2= GSON.fromJson(json,Person.class);
        System.out.println(person2.getName()+", " +  person2.getAge()+ ", " + person2.getGeoHistory());
    }
}
