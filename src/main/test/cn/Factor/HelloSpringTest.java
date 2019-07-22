package cn.Factor;

import cn.sprindemo.HelloSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class HelloSpringTest {
    @Test
    public void text(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring= (HelloSpring) context.getBean("helloSping");
        helloSpring.print();

    }
}
