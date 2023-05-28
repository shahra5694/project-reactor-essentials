package com.springboot.ws.proxy;

public class FileUploader implements IFileUploader {
    @Override
    public void upload(byte[] content) {
        System.out.println("file uploaded");
    }

}
