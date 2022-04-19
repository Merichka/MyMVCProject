package ru.merichka.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.merichka.models.User;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UseDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findById(Long id){
        return userDAO.getOne(id);
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public User saveUser(User user){
        return userDAO.save(user);
    }

    public void deleteById(Long id){
        userDAO.deleteById(id);
    }
}
