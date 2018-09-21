package server.dao.factory;

import server.dao.impl.TodoDaoImpl;
import server.dao.impl.UserDaoImpl;

public class DaoFactory {

    public static TodoDaoImpl todoDaoImpl(){
        return new TodoDaoImpl();
    }

    public static UserDaoImpl userDaoImpl(){
        return new UserDaoImpl();
    }

}
