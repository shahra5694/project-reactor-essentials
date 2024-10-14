package com.springboot.ws.structuraldesignpatterns.bridge;

/**
 * When we have interface hierarchies in both interfaces and implementations,
 * then the bridge design pattern is used to decouple the interfaces from the implementation
 * and to hide the implementation details from the client programs.
 */

public class Main {

    public static void main(String[] args) {
        Video youTubeVideo = new YouTubeVideo(new HDProcessor());
        youTubeVideo.play("abc.mp4");

        Video netflixVideo = new NetflixVideo(new HD4KProcessor());
        netflixVideo.play("xyz.mp4");
    }
}
