package ru.merichka.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.merichka.models.User;

import java.util.List;

@Component
@Transactional
public class UserDAOImpl implements UserDAO {
    public UserDAOImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public void save(User user) {
        User managed = entityManager.merge(user);
        entityManager.persist(managed);
    }

    @Transactional
    @Override
    public void delete(User user) {
        User managed = entityManager.merge(user);
        entityManager.remove(managed);
    }

       @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id );
    }

    @Override
    public User getUserByName(String username) {
        try {
            return entityManager.createQuery("SELECT u FROM User u where u.name = :name", User.class)
                    .setParameter("name", username)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}