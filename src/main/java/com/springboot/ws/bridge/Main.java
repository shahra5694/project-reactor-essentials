package com.springboot.ws.bridge;

public class Main {

    public static void main(String[] args) {
        Video youTubeVideo = new YouTubeVideo(new HDProcessor());
        youTubeVideo.play("abc.mp4");

        Video netflixVideo = new NetflixVideo(new HD4KProcessor());
        netflixVideo.play("xyz.mp4");
    }
}
