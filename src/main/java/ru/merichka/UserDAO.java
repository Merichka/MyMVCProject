package ru.merichka.dao;

import ru.merichka.models.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void save(User user);
    void delete(User user);
    User getById(long id);

    User getById(Long id);

    User getUserByName(String username);
}
