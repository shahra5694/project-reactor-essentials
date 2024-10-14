package hashmap;

import java.util.Map;
import java.util.TreeMap;

public class HashMapSimilerkey {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("rahul", 1);
        map.put("person", 2);
        map.put("PERSON", 3);
        map.put("person1", 2);
        map.put("PERSON1", 3);

        System.out.println(map);
    }
}
