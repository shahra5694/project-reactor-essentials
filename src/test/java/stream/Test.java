package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    @org.junit.jupiter.api.Test
    public void streamPeek() {
        Stream<User> userStream = Stream.of(new User("Alice"), new User("Bob"), new User("Chuck"));
        userStream.peek(u -> u.setName(u.getName().toLowerCase()))
                .forEach(u -> System.out.println(u.getName()));
    }

    class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @org.junit.jupiter.api.Test
    public void covertStringArrayToSortedMap() {
        String text[] = {"Rahul", "Srik", "Man"};
        Map<String, Integer> stringToLength = Arrays.stream(text)
                .collect(Collectors.toMap(Function.identity(), String::length));

        Map<String, Integer> newMap = stringToLength.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));

        System.out.println(newMap);

        Map<String, Integer> result2 = new LinkedHashMap<>();
        Arrays.stream(text).collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        System.out.println(result2);
    }

    @org.junit.jupiter.api.Test
    public void minimumCostForStation() {
        int[] prices = {2, 4, 6, 3, 1, 3};
        int n = prices.length;
        int[] clockwise = new int[n];
        int[] anticlockwise = new int[n];

        // Calculate the minimum cost to reach each station in the clockwise direction
        clockwise[0] = prices[0];
        for (int i = 1; i < n; i++) {
            clockwise[i] = Math.min(clockwise[i - 1], prices[i]);
        }

        // Calculate the minimum cost to reach each station in the anticlockwise direction
        anticlockwise[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            anticlockwise[i] = Math.min(anticlockwise[i + 1], prices[i]);
        }

        // Find the minimum cost to complete the full circle
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cost = clockwise[i] + anticlockwise[i];
            minCost = Math.min(minCost, cost);
        }

        System.out.println("The route that will cost the lowest price is: " + minCost);
    }

    @org.junit.jupiter.api.Test
    public void primeNumber() {
//        int n1 = 6n-1;
//        int n2 = 6n+1;
        for (int i = 1; i <= 10 / 2; i++) {
            System.out.println(6 * i - 1);
            System.out.println(6 * i + 1);
        }
    }

    @org.junit.jupiter.api.Test
    public void isPrimeNumber() {
        int n = 9;
        int count = 0;
        if (n < 1) {
            System.out.println("not natural number");
        }
        if (n == 1)
            System.out.println(" prime");

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
        new HashMap<Integer, String>();
    }

    @org.junit.jupiter.api.Test
    public void openerCloserProperlyNested() {
        String str = "{([[]])}";
        int j = 0;
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                list.push(c);
            } else {
                if (list.isEmpty()) {
                    j = 1;
                    break;
                }
                char preceding = list.pop();
                if (c == ')' && preceding != '(') {
                    j = 1;
                    break;
                }
                if (c == '}' && preceding != '{') {
                    j = 1;
                    break;
                }
                if (c == ']' && preceding != '[') {
                    j = 1;
                    break;
                }
            }
        }
        if (j == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
