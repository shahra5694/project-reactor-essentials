package com.springboot.ws.structuraldesignpatterns.proxy.solution;

import com.springboot.ws.structuraldesignpatterns.proxy.Factory;
import com.springboot.ws.structuraldesignpatterns.proxy.IFileUploader;

public class TestClient {

    public static void main(String[] args) {
        IFileUploader fileUploader = Factory.getFileUploader();
        fileUploader.upload(new byte[1024]);
    }
}
