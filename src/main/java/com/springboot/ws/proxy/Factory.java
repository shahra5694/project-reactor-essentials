package com.springboot.ws.proxy;

import com.springboot.ws.proxy.solution.ProxyUploader;

public class Factory {
    public static IFileUploader getFileUploader() {
       return new ProxyUploader();
    }
}
