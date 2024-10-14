package com.springboot.ws.behavioraldesignpatterns.observer;


/*
*  Behavioral design patter provides solution for better interaction between objects and how to provide
*  loos-coupling and flexibility to extend.
*
*  Observer design is one of the behavioral design pattern. This pattern is useful when you are interested
*  in state change of an object and want to get notified whenever there is any change in the state.
*  In observer pattern, the object that watch the state of another object is called observer and
*  the object that is being watched is called Subject.
* */

public class TestClient {

    public static void main(String[] args) {
        YoutubeChannel1 youtubeChannel1 = new YoutubeChannel1();
        YoutubeChannel2 youtubeChannel2 = new YoutubeChannel2();

        User1 user1 = new User1();
        User2 user2 = new User2();
        User3 user3 = new User3();

        youtubeChannel1.registerObserver(user1);
        youtubeChannel1.registerObserver(user2);

        youtubeChannel2.registerObserver(user1);
        youtubeChannel2.registerObserver(user2);
        youtubeChannel2.registerObserver(user3);

        youtubeChannel1.newVideoAdded("Video 5 added in channel 1");
        youtubeChannel2.newVideoAdded("Video 10 added in channel 2");
    }
}
