package stream;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;

import java.util.List;
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

}
