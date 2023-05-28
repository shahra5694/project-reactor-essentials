package com.springboot.ws.bridge;

public class YouTubeVideo extends Video {

    public YouTubeVideo(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void play(String videoFile) {
        videoProcessor.process(videoFile);
    }
}
