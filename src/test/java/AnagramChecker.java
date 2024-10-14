import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "silent";
        System.out.println(isAnagram(s1,s2));
        System.out.println(isAnagramByFrequency(s1,s2));
    }

    static boolean isAnagram(String s1, String  s2) {
        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1,c2);
    }

    static boolean isAnagramByFrequency(String s1, String s2) {
        if(s1.length() != s2.length())
             return false;

        Map<Character,Integer> map = new HashMap<>();
        for(char c:s1.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (char c : s2.toCharArray()) {
            if(!map.containsKey(c) || map.getOrDefault(c,0)==0) {
                return false;
            }
            map.put(c, map.getOrDefault(c,0)-1);
        }

        return !map.values().stream().anyMatch(o-> o != 0);
    }
}
