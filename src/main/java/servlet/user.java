package servlet;

import Dao.userDao;

public class user implements userDao {
    @Override
    public void getUser() {
        System.out.println("获取用户信息");

    }
}
