package ourMethodv2.gpt4o;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;

class Task131 {
    public static Object deserializeJson(String jsonData, Class<?> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            return objectMapper.readValue(jsonData, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String json1 = "{\"name\":\"John\", \"age\":30}";
        String json2 = "{\"title\":\"Book\", \"author\":\"Alice\"}";
        String json3 = "{\"make\":\"Toyota\", \"model\":\"Corolla\"}";
        String json4 = "{\"username\":\"admin\", \"password\":\"secret\"}";
        String json5 = "{\"city\":\"New York\", \"population\":8000000}";

        System.out.println(deserializeJson(json1, Person.class));
        System.out.println(deserializeJson(json2, Book.class));
        System.out.println(deserializeJson(json3, Car.class));
        System.out.println(deserializeJson(json4, User.class));
        System.out.println(deserializeJson(json5, City.class));
    }
}

class Person {
    public String name;
    public int age;
}

class Book {
    public String title;
    public String author;
}

class Car {
    public String make;
    public String model;
}

class User {
    public String username;
    public String password;
}

class City {
    public String city;
    public int population;
}