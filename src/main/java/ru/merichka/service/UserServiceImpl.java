package ru.merichka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.merichka.dao.UserDAO;
import ru.merichka.models.User;


@Service
public class UserServiceImpl {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(User user){
        userDAO.addUser(user);
    }

    public void update(User user){
        userDAO.update(user);
    }

    public void deleteUser(long id){
        userDAO.delete(id);
    }
}
