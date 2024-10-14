package com.springboot.ws.creationaldesignpattern.abstractfactory;

import com.springboot.ws.creationaldesignpattern.factorymethod.Computer;
import com.springboot.ws.creationaldesignpattern.factorymethod.PC;

public class PCFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() {
        return new PC(ram,hdd,cpu);
    }
}
