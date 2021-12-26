import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapKeyTester {
    public static void main (String... args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("key1", "one");
        map.put("Jan-20", "two");
        map.put("Apr-21", "three");
        map.put("Sep-22", "four");
        map.put("key2", "five");
        map.put("key3", "six");


        //Map<String, String> collect;
        //collect = map.entrySet().stream().filter(entry ->entry.getKey().contains("-2")).
        //        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        List keyString;
        //keyString =
         //       map.entrySet().stream().filter(entry ->entry.getKey().contains("-2")).collect(Collectors.toList(Map
        //       .Entry::getKey));
        keyString = map.keySet().stream().filter(entry -> entry.contains("-2")).collect(Collectors.toList());
        System.out.println(keyString);
    }
}
