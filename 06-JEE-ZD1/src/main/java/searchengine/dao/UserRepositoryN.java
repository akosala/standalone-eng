package searchengine.dao;

import searchengine.domain.Users;

import javax.ejb.Local;

@Local
public interface UserRepositoryN {
    public boolean addUser(Users users);
}
