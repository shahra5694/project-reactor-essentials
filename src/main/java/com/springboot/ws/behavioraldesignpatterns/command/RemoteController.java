package com.springboot.ws.behavioraldesignpatterns.command;

public class RemoteController {

   private Command command;

    public RemoteController(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
