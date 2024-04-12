package task_3_1_2.dao;

import task_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(Long id);
    User update(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}
