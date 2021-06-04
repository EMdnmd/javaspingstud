package servlet;

import Dao.userDao;
import Dao.userServiceDao;
import org.junit.Test;

public class userServic  implements userServiceDao {
    private   userDao  userDao ;
    public  void  setUserdao(userDao userDao){
                this.userDao=userDao;

    }
    @Override
    public void getUser() {
                userDao.getUser();
    }

@Test
public   void  test(){
        userServic usd=new userServic();
        usd.setUserdao(new mysql());
        usd.getUser();


}
}

