package server.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import server.dao.UserDao;
import server.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String URL = "jdbc:sqlite:miracle.sqlite";
    private Dao<User, Integer> dao;

    {
        try {
            ConnectionSource source = new JdbcConnectionSource(URL);
            dao = DaoManager.createDao(source, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() throws SQLException {
        return dao.queryForAll();
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        return dao.queryBuilder()
                .where()
                .eq("email", email)
                .queryForFirst();
    }

    @Override
    public List<User> findSortByUniversalParam(String field, boolean sort) throws SQLException {
        return dao.queryBuilder()
                .orderBy(field, sort)
                .query();
    }

    @Override
    public void save(User user) throws SQLException {
        dao.create(user);
    }

    public void update(User user) throws SQLException {
        dao.update(user);
    }

    public void delete(int userId) throws SQLException {
        dao.deleteById(userId);
    }
}
