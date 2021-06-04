package servlet.shout;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class user {
//    将User中所有set方法去掉
            @Autowired
            public  dog dog;
            @Autowired
            public  cat cat;
            public  String name;

@Test
public  void  test(){
    ApplicationContext context =new ClassPathXmlApplicationContext("user.xml");
    user user=(user)context.getBean("user");
    user.cat.shout();
    user.dog.shout();


}


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCat(servlet.shout.cat cat) {
        this.cat = cat;
    }

    public servlet.shout.cat getCat() {
        return cat;
    }

    public void setDog(servlet.shout.dog dog) {
        this.dog = dog;
    }

    public servlet.shout.dog getDog() {
        return dog;
    }
}




