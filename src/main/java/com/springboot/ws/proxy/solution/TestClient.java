package com.springboot.ws.proxy.solution;

import com.springboot.ws.proxy.Factory;
import com.springboot.ws.proxy.IFileUploader;

public class TestClient {

    public static void main(String[] args) {
        IFileUploader fileUploader = Factory.getFileUploader();
        fileUploader.upload(new byte[1024]);
    }
}
