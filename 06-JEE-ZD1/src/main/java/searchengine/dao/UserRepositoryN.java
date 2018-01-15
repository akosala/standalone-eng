package searchengine.dao;

import searchengine.domain.Users;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRepositoryN {
    boolean addUser(Users users);
    Users getUserById(int id);
    Users getUserByLogin(String login);
    List<Users> getUsersList();
}
