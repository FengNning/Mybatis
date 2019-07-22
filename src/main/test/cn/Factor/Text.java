package cn.Factor;

import cn.KeTang.Greeting;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text {
    @Test
    public void text(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Greeting zhangga=(Greeting)context.getBean("zhangGa");
        Greeting rod=(Greeting)context.getBean("rod");
        zhangga.jg();
        rod.jg();
    }
}
