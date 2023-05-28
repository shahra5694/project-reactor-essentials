package algoritham;

import java.util.HashMap;
import java.util.Map;

public class CharacterFreq {

    public static void main(String[] args) {
        String str = "RahulShah";
        usingHashMap(str);
        System.out.println("-------------------");
        usingDS(str);
    }

   static void usingDS(String str) {
        int freq [] = new int[256];
        for(int i=0;i<str.length();i++) {
            freq[str.charAt(i)]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0) {
                System.out.println("assci:" + i +" , "+((char)i +"-"+freq[i]));
            }
        }
   }

   static void usingHashMap(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i =0;i<str.length();i++) {
            char c = str.charAt(i);
            map.computeIfPresent(c,(key,value) -> value+1);
            map.putIfAbsent(c, 1);
        }
        for (int i =0;i<str.length();i++) {
            if(map.get(str.charAt(i)) != -1) {
                System.out.println(str.charAt(i)+"-"+map.get(str.charAt(i)));
                map.put(str.charAt(i),-1);
            }
        }
    }
}
