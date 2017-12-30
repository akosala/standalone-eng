package searchengine.dao;

import searchengine.domain.User;
import searchengine.domain.Users;

import javax.ejb.Local;

import java.util.List;

@Local
public interface UsersRepositoryDao {
    public Users addUser(Users users);

    public Users getUserById(int id);

    public Users getUserByLogin(String login);

    public List<User> userList();

}
