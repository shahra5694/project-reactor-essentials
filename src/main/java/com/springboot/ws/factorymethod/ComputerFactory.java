package com.springboot.ws.factorymethod;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String cpu, String hdd) {
        if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);

        return null;
    }
}
