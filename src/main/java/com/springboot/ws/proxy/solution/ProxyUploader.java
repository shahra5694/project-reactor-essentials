package com.springboot.ws.proxy.solution;

import com.springboot.ws.proxy.FileUploader;
import com.springboot.ws.proxy.IFileUploader;

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
