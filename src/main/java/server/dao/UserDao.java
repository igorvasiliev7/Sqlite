package server.dao;

import server.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> findAll() throws SQLException;

    User findByEmail(String email) throws SQLException;

    List<User> findSortByUniversalParam(String field, boolean sort) throws SQLException;

    void save(User user) throws SQLException;

    void update(User user) throws SQLException;

    void delete(int userId) throws SQLException;
}
