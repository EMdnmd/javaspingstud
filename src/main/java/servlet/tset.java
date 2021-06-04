package servlet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import servlet.shout.xiangjia;

@Component("test")
public class tset {

            public  void  shout(){
                System.out.println("叼你妈的");

            }
@Test
public void sk(){
        ApplicationContext context =new ClassPathXmlApplicationContext("user.xml");
        xiangjia test =(xiangjia) context.getBean("number");
         test.showNumber();
}

}

