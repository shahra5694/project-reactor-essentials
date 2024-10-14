package com.springboot.ws.solid.lsp;


/*
 * Objects of a superclass should be replaceable with objects of its subclasses without breaking the system.
 * This means that every subclass class should be substitutable for their base class.
 * */
public abstract class SocialMedia {

    public abstract void chatWithFriend();

    public abstract void publishPost(Object post);

    public abstract void sendPhotoAndVideo();

    public abstract void groupVideoCall(String... users);
}
