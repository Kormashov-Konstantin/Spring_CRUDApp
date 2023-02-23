package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();

    User oneUser(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void removeUserById(int id);
}
