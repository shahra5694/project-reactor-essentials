package com.springboot.ws.creationaldesignpattern.singleton;

import java.io.*;

public class SerializationToBreakSingleton {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            Singleton s1 = Singleton.getInstance();
            ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("file.txt"));
            objectOutput.writeObject(s1);
            objectOutput.close();

            ObjectInput input = new ObjectInputStream(new FileInputStream("file.txt"));
            Singleton s2 = (Singleton) input.readObject();
            input.close();
            System.out.println("instance1 hashCode:- " + s1.hashCode());
            System.out.println("instance2 hashCode:- " + s2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

