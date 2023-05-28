package com.springboot.ws.factorymethod;

public class TestFactory {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC", "2 GB", "2.4 GHz", "500 GB");
        Computer server = ComputerFactory.getComputer("SERVER", "16 GB", "2.9 GHz", "1 TB");
        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);
    }
}
