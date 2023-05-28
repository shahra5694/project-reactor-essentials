package com.springboot.ws;

import com.springboot.ws.scope.MyBean;
import com.springboot.ws.scope.MyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TempMainClass {

    public static void main(String [] ar) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyConfiguration.class);
        ctx.refresh();

        MyBean mb1 =  ctx.getBean(MyBean.class);
        System.out.println(mb1.hashCode());

        MyBean mb2 = ctx.getBean(MyBean.class);
        System.out.println(mb2.hashCode());

        ctx.close();
    }
}
