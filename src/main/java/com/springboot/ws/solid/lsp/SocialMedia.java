package com.springboot.ws.solid.lsp;

public abstract class SocialMedia {

    public abstract void chatWithFriend();

    public abstract void publishPost(Object post);

    public abstract void sendPhotoAndVideo();

    public abstract void groupVideoCall(String... users);
}
