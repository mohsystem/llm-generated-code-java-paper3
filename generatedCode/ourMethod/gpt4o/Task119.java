package ourMethod.openai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task119 {
    public static List<List<String>> parseCSV(String input) {
        List<List<String>> result = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            List<String> values = Arrays.asList(line.split(","));
            result.add(values);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> data1 = parseCSV("name,age,city\nJohn,25,New York");
        List<List<String>> data2 = parseCSV("fruit,quantity\nApple,10");
        List<List<String>> data3 = parseCSV("product,price\nLaptop,999.99");
        List<List<String>> data4 = parseCSV("car,year\nToyota,2020");
        List<List<String>> data5 = parseCSV("language,level\nJava,Expert");
    }
}