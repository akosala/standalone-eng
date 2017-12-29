package searchengine.dao;

import searchengine.domain.User;
import searchengine.domain.Users;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersRepositoryDao {
    public User addUser(Users user);

    public User getUserById(int id);

    public User getUserByLogin(String login);

    public List<User> userList();

}
