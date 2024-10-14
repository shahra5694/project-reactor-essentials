package com.springboot.ws.structuraldesignpatterns.proxy;

import com.springboot.ws.structuraldesignpatterns.proxy.solution.ProxyUploader;

public class Factory {
    public static IFileUploader getFileUploader() {
       return new ProxyUploader();
    }
}
