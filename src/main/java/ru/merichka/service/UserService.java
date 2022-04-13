package ru.merichka.service;

import ru.merichka.models.User;

public interface UserService {
    Object getAllUsers();

    User readUser(int id);

    User deleteUser(int id);

    void createOrUpdateUser(User user);

}
