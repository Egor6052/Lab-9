package Package;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    /**
     * В отдельном классе реализовать загрузку данных отдельным потоком из JSON любого сайта,
     * отдающего данные  этом формате. Реализовать возможность фильтрации полученных данных
     * и поиска по списку с использованием компараторов в виде лямбда-выражений.
     * Выгрузить проект в репозиторий GitHub и добавить к нему описание в README
     * (кратко, несколько строк пояснений по каждому заданию).
     * Прикрепить ссылку на репозиторий в виде ответа на задание.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("Семенов Егор АТ-212");

        //ExampleList resList = new ExampleList();

        JSONGetter jsonGetter = new JSONGetter();
        JSONGetter.url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        jsonGetter.start();
        jsonGetter.join();

        String jsonString = jsonGetter.getOutJson();

        Object obj = null;
        try {
            obj = new JSONParser().parse(jsonString);
        } catch (ParseException e){
            e.printStackTrace();
        }

        JSONArray jsonArray = (JSONArray) obj;

        Result results = new Result();
        assert jsonArray != null;
        for (Object jsonObject : jsonArray){
            JSONObject current = (JSONObject) jsonObject;
            String link = (String) current.get("link");
            String from = (String) current.get("from");
            String to = (String) current.get("to");
            String date = (String) current.get("date");
            String time = (String) current.get("time");

            Result result = new Result(link, from, to, date, time);
            result.add(result);
        }
        System.out.println(results);
        //Сортировка списков и вывод отсортированных списков объектов

        results.getResults().sort(Result.byNameAsc);
        System.out.println("Format by link (ascending)\n"+results);
        results.getResults().sort(Result.byNameDesc);
        System.out.println("Format by link (descending)\n"+results);

        results.getResults().sort(Result.byDateAsc);
        System.out.println("Format by date (ascending)\n"+results);
        results.getResults().sort(Result.byDateDesc);
        System.out.println("Format by date (descending)\n"+results);

        results.getResults().sort(Result.byTimeAsc);
        System.out.println("Format by time (ascending)\n"+results);
        results.getResults().sort(Result.byTimeDesc);
        System.out.println("Format by time (descending)\n"+results);
    }
}
