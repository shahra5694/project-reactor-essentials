package com.springboot.ws.abstractfactory;

import com.springboot.ws.factorymethod.Computer;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
