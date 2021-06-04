package servlet;

import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class hello {

    private  String name;
    public String  getname(){

            return  name;

    }
    public void  setName(String name){
            this.name=name;

    }

    public  void show (){
        System.out.println("hello"+name);

    }
    public  void ak(){
        System.out.println("进来了测试了");

    }

    @Test
    public  void test(){
//        管理上下文的容器
        ApplicationContext  context=new ClassPathXmlApplicationContext("beans.xml");
        student userServic=(student) context.getBean("student");
        String s = userServic.toString();
        System.out.println(s);

    }


}
