package com.springboot.ws.structuraldesignpatterns.proxy;

/*
*  Proxy pattern provides a placeholder or an intercepter for a resource.
* */

/*
*  Scenarios/Problems when proxy pattern need to use.
*
*   1. uploading is allowed only for specific extension files
*   2. file upload should not be allowed when cloud uploader is overloaded.
*   3. only specific user can upload the files.
* */
public class Test {

    public static void main(String[] args) {
        FileUploader fileUploader = new FileUploader();
        fileUploader.upload(new byte[1024]);
    }

}
