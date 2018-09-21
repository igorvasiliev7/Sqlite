package server.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import server.dao.TodoDao;
import server.model.Todo;
import server.model.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    private static final String URL = "jdbc:sqlite:miracle.sqlite";
    private Dao<Todo, Integer> dao;

    {
        try {
            ConnectionSource source = new JdbcConnectionSource(URL);
            dao = DaoManager.createDao(source, Todo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Todo> findAll() throws SQLException {
        return dao.queryForAll();
    }

    @Override
    public List<Todo> findOverdue(Date date) throws SQLException {
        List<Todo> list = dao.queryForAll();
        List<Todo> list2=new LinkedList<>();
        for (Todo todo : list) {
            if(todo.getDate().after(date)){
                list2.add(todo);
            }
        }
        return list2;
    }

    @Override
    public void save(Todo todo) throws SQLException {
        dao.create(todo);
    }

    @Override
    public void update(Todo todo) throws SQLException {
        dao.update(todo);
    }

    @Override
    public void delete(int todoId) throws SQLException {
    dao.deleteById(todoId);
    }
}
