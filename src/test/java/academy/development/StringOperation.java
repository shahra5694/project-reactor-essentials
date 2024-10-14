package academy.development;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.http.*;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class StringOperation {

    @Test
    public void makeWordTitleCase() {
        String s = "thisHasASingleLetterWor";
        LinkedList<String> result = new LinkedList<String>();
//        for (String w : s.split("(([A-Z]?[a-z]+)|([A-Z]))")) {
//            result.add(w);
//        }
        for (String w : s.split("(?=[A-Z]+)")) {
            result.add(w);
        }
//        log.info(s.replaceAll("(?=[A-Z]+)", " ").trim());
//        log.info(result.toString());

        log.info(Arrays.stream(s.split("(?=[A-Z]+)")).map(StringUtils::capitalize).collect(Collectors.joining(" ")));

    }

    @Test
    public void listOp () {
          List<String> listOne = Arrays.asList("Jack", "Tom", "Sam", "John", "James", "Jack");
          List<String> listTwo = new ArrayList<>();

        List<String> differences = new ArrayList<>(listOne);
        differences.removeAll(listTwo);
//        differences.addAll(listTwo);


        log.info("{}",differences);
    }

    @Test
    public void fetchFile() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://img.championat.com/news/big/l/c/ujejn-runi_1439911080563855663.jpg";
        // Optional Accept header
        RequestCallback requestCallback = request -> request
                .getHeaders()
                .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));

        // Streams the response instead of loading it all in memory
        ResponseExtractor<Void> responseExtractor = response -> {
            // Here you can write the inputstream to a file or any other place
            Path path = Paths.get("downloadv3.jpg");
            Files.copy(response.getBody(), path);
            return null;
        };
        restTemplate.execute(url, HttpMethod.GET, requestCallback, responseExtractor);
    }

    @Test
    public void f() {
        String stringValue = "Hello world";
// Encode this value into Base6
        String stringValueBase64Encoded = Base64.getEncoder().encodeToString(stringValue.getBytes());
        System.out.println(stringValue  + " when Base64 encoded is: " + stringValueBase64Encoded);

        byte[] byteValueBase64Decoded = Base64.getDecoder().decode(stringValueBase64Encoded);
        String stringValueBase64Decoded = new String(byteValueBase64Decoded);
        System.out.println(stringValueBase64Encoded  + " when decoded is: " + stringValueBase64Decoded);
    }

    @Test
    public void stringJoin() {
        log.info(new StringBuilder("2022-09-01").insert(4, '-').insert(7, "-").toString());

    }

    @Test
    public void reversSringUsingJava8() {
        String str = "quick brown fox jumps over lazy dog";
        String finalStr = str;
        str = IntStream.range(0,str.length()).mapToObj(le -> finalStr.charAt(finalStr.length()-1-le))
                .collect(StringBuilder::new,StringBuilder::append,StringBuilder::append)
                .toString();
        log.info(str);
    }

    @Test
    public void revers() {
        String string = "quick brown fox jumps over lazy dog";
        String u = IntStream.range(0,string.length()).mapToObj(i -> string.charAt(string.length()-1-i))
                        .collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString();
        log.info(u);
    }
    @Test
    public void reversStr() {
        String string = "quick brown fox jumps over lazy dog";
        string = string.chars().mapToObj(i->(char)i).reduce("",(sum,element) -> element+sum,(a2,b2) -> a2+b2);
        log.info(string);
    }
    @Test
    public void reversString() {
        String string = "quick brown fox jumps over lazy dog";
        String finalString = string;
        string= IntStream.range(0,string.length()).mapToObj(i -> finalString.charAt(finalString.length()-1-i))
                .reduce("",(sum,ele) -> sum+ele,(s1,s2) -> s2+s1);
        log.info(string);
    }

    @Test
    public void splitTitleCaseString(){
        String text ="shahRahulTeam";
        String SPLITWORD_BY_CAMELCASE_REGEX = "(?=[A-Z]+)";
        if(StringUtils.hasText(text)) {
            text =  Arrays.stream(text.split(SPLITWORD_BY_CAMELCASE_REGEX)).map(StringUtils::capitalize).collect(Collectors.joining(" "));
        }
        System.out.println(text);;
    }

    @Test
    public void randomInteger() {
        int[] ar = new Random().ints(10,1,100).toArray();
        for (int i:ar) {
            System.out.println(i);
        }
        System.out.println();
         ar = new Random().ints(0,10).limit(5).toArray();
        for (int i:ar) {
            System.out.println(i);
        }
    }

    @Test
    public void minHeap() {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            heap.add(11);
            heap.add(2);
            heap.add(10);
            heap.add(7);
            heap.add(3);
            heap.add(8);
            System.out.println("size of heap : " + heap.size());
            System.out.println("min in heap : " +heap.peek());
            heap.poll();
            System.out.println("after deletion");
            System.out.println("size of heap : " + heap.size());
            System.out.println("min in heap : " +heap.peek());
    }
}
