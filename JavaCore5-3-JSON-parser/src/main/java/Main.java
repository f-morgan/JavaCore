import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "data.json";
        String json = readString(fileName);
        List<Employee> list = jsonToList(json);
        list.forEach(System.out::println);
    }

    private static String readString(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String result = "";
            while (bufferedReader.ready()) {
                result += bufferedReader.readLine();
            }
            return result;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static List<Employee> jsonToList(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}
