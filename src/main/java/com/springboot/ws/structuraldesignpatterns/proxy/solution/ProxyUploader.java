package com.springboot.ws.structuraldesignpatterns.proxy.solution;

import com.springboot.ws.structuraldesignpatterns.proxy.FileUploader;
import com.springboot.ws.structuraldesignpatterns.proxy.IFileUploader;

public class ProxyUploader implements IFileUploader {

    private IFileUploader fileUploader;

    @Override
    public void upload(byte[] content) {
//         check user access
//        validate file extension
//        check if cloud resource is not loaded

        fileUploader = new FileUploader(); // also called lazy loading
        fileUploader.upload(content);
    }
}
