package com.springboot.ws.structuraldesignpatterns.bridge;

public class NetflixVideo extends Video {

    public NetflixVideo(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String videoFile) {
        videoProcessor.process(videoFile);
    }
}
