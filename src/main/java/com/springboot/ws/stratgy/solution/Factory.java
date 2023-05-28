package com.springboot.ws.stratgy.solution;

public class Factory {
     public static IRenderer getRender(String choice) {
         if(choice.equals("bar"))
             return new BarRenderer();
         else if(choice.equals("pie"))
             return new PieRenderer();
         return null;
     }
}
