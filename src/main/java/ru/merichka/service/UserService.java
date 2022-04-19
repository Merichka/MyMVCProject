package ru.merichka.service;

import ru.merichka.models.User;

public interface UserService {
    Object getAllUsers();

    User readUser(long id);

    User deleteUser(long id);

    void createOrUpdateUser(User user);

}
