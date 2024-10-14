import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class printItineraryFromGivenCities {

    public static void main(String[] args) {
//        Input:
//        "Chennai" -> "Banglore"
//        "Bombay" -> "Delhi"
//        "Goa"    -> "Chennai"
//        "Delhi"  -> "Goa"
//
//        Output:
//        Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,

        Map<String,String> map = new HashMap<>();
        map.put("Chennai","Banglore");
        map.put("Bombay","Delhi");
        map.put("Goa","Chennai");
        map.put("Delhi","Goa");

        printResult(map);
    }

    static void printResult(Map<String,String> map) {
        List<String> endCities = new ArrayList<>(map.values());

        // Find the starting point of itinerary
        String startCity = map.entrySet().stream().dropWhile(entry -> endCities.contains(entry.getKey())).findFirst().get().getKey();
        System.out.println("StartCity = " + startCity);

        // Once we have starting point, we simple need to go next, next
        // of next using given hash map

       String endCity = map.get(startCity);
       while (endCity != null) {
           System.out.println(startCity +" -> "+endCity);
           startCity = endCity;
           endCity = map.get(startCity);
       }
    }
}
