package com.springboot.ws.creationaldesignpattern.abstractfactory;

import com.springboot.ws.creationaldesignpattern.factorymethod.Computer;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
