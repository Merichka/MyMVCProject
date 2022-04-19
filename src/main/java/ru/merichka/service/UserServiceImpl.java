package ru.merichka.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.merichka.models.User;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserDAO userDAO;

   @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add(User user){
        return userDAO.addUser(user);
    }

    public update(User user){
        return userDAO.update(user);
    }

    public void deleteUser(int id){
        userDAO.delete(id);
    }
