package servlet;

import Dao.userDao;

public class mysql implements userDao {

    @Override
    public void getUser() {
        System.out.println("调用mysql");
    }
}
