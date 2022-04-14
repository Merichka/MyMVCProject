package ru.merichka.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.merichka.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static int USERS_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USERS_COUNT, "Dima"));
        users.add(new User(++USERS_COUNT, "Masha"));
        users.add(new User(++USERS_COUNT, "Vanya"));
        users.add(new User(++USERS_COUNT, "Dasha"));
    }

    public List<User> index() {
        return users;
    }

    public Object show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = (User) show(id);

        userToBeUpdated.setName(updatedUser.getName());

    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User readUser(int id) {
        return null;
    }

    @Override
    public User deleteUser(int id) {
        return null;
    }

    @Override
    public void createOrUpdateUser(User user) {

    }
}


