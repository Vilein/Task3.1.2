package task_3_1_2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import task_3_1_2.model.User;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(User user) {
        manager.persist(user);
    }
    @Override
    public void delete(Long id) {
        User user = manager.find(User.class, id);
        manager.remove(user);
    }
    @Override
    public User update(User user) {
         return manager.merge(user);
    }
    @Override
    public List<User> getAllUsers() {
        return manager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User getUserById(Long id) {
        return manager.find(User.class, id);
    }
}