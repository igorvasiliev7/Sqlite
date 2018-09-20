package server.demo;

import server.dao.UserDao;
import server.dao.impl.UserDaoImpl;
import server.model.User;
import server.util.Constant;

import java.sql.SQLException;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {

        final User user = new User();
        user.setName("Bob");
        user.setEmail("bob@ukr.net");

        UserDao userDao = new UserDaoImpl();
//        userDao.save(user);
//        final List<User> users = userDao.findAll();

//        users.forEach(s -> System.out.println(s.toString()));

//        final User byEmail = userDao.findByEmail(user.getEmail());
//        System.out.println(byEmail.toString());
        final List<User> userList = userDao.findSortByUniversalParam(Constant.FIELD_NAME, Constant.DESC);
        userList.forEach(s -> System.out.println(s.toString()));

    }
}
