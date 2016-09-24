package ex1;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vika on 24.09.16.
 */
public class Person {
    private String name;
    private Integer age;
    /**
     * Меняем geoHistory на geo с помощью анотации
     */
    @SerializedName("geo")
    private List<String> geoHistory = new ArrayList<>();
    //Конструктор
    public Person(String name, Integer age, List<String> geoHistory) {
        this.name = name;
        this.age = age;
        this.geoHistory = geoHistory;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getGeoHistory() {
        return geoHistory;
    }
}
