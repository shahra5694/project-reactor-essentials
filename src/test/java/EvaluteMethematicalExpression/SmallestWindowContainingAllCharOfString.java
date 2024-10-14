package EvaluteMethematicalExpression;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallestWindowContainingAllCharOfString {

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println(getSmallestWindow(str));

        int length = str.length();

        // count all dist char

        HashMap<Character, Integer> map = new HashMap<>();
        IntStream.range(0, str.length()).mapToObj(str::charAt).forEach(ch -> {
            map.computeIfPresent(ch, (key, value) -> value + 1);
            map.putIfAbsent(ch, 1);
        });
        System.out.println(map);
        int dist_count = map.size();
        int size = Integer.MAX_VALUE;

        String res = "";

        for (int i = 0; i < length; i++) {
            int count = 0;
            int[] visited = new int[256];
            for (int j = 0; j < 256; j++) {
                visited[j] = 0;
            }
            StringBuilder subStr = new StringBuilder();

            for (int j = i; j < length; j++) {
                if (visited[str.charAt(j)] == 0) {
                    visited[str.charAt(j)] = 1;
                    count++;
                }
                subStr.append(str.charAt(j));
                if (count == dist_count)
                    break;
            }
            if (subStr.length() < size && count == dist_count) {
                res = subStr.toString();
                size = res.length();
            }
        }
        System.out.println(res);
    }

    private static String getSmallestWindow(String str) {
        int length = str.length();
        String res = "";
        int size = Integer.MAX_VALUE;

        int dist_count = IntStream.range(0, str.length()).mapToObj(str::charAt).collect(Collectors.toSet()).size();
        for (int i = 0; i < length; i++) {
            int count = 0;
            int visited[] = new int[256];

            StringBuilder sb = new StringBuilder();

            for (int j = i; j < length; j++) {
                if (visited[str.charAt(j)] == 0) {
                    visited[str.charAt(j)] = 1;
                    count++;
                }
                sb.append(str.charAt(j));
                if (count == dist_count) {
                    break;
                }
            }
            if (sb.length() < size && count == dist_count) {
                res = sb.toString();
                size = res.length();
            }
        }
        return res;
    }
}
