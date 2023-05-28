package com.springboot.ws.flyweight;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFactory {

    private static Map<String , Employee> map = new HashMap<>();
    public static Employee getEmployee(String type) {
        Employee p = null;
        if(map.get(type) != null)
            p = map.get(type);
        else {
            switch (type){
                case "Developer":
                    System.out.println("Developer Created");
                    p = new Developer();
                    break;
                case "Tester" :
                    System.out.println("Tester Created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("No Such Employee");
            }
            map.put(type,p);
        }
      return p;
    }

}
