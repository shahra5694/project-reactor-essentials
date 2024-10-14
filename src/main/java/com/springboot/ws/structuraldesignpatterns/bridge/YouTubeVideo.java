package com.springboot.ws.structuraldesignpatterns.bridge;

public class YouTubeVideo extends Video {

    public YouTubeVideo(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String videoFile) {
        videoProcessor.process(videoFile);
    }
}
