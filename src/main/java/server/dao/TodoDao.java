package server.dao;

import server.model.Todo;
import server.model.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface TodoDao {

    List<Todo> findAll() throws SQLException;

    List<Todo> findOverdue(Date date) throws SQLException;

    void save(Todo todo) throws SQLException;

    void update(Todo todo) throws SQLException;

    void delete(int todoId) throws SQLException;

}
