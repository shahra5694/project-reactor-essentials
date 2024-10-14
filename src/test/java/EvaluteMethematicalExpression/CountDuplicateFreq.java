package EvaluteMethematicalExpression;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicateFreq {

    public static void main(String[] args) {
        List<String> wordsList = List.of("hello", "bye", "ciao", "bye", "ciao");
        Map<String,Long> map = wordsList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

        map = wordsList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.summingLong(e->1)));
        System.out.println(map);
    }
}
