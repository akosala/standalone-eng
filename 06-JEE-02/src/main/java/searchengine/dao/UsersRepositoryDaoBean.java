package searchengine.dao;

import searchengine.domain.User;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless

public class UsersRepositoryDaoBean implements UsersRepositoryDao,UsersRepositoryDaoRemote {

    private static Map<Integer, Integer> mapStatistic = new HashMap<>();
//    @PersistenceContext(name = "pUnit")
    EntityManager entityManager;

    @Override

    public List<User> userList() {
        return UsersRepository.getRepository();
    }

    @Override
    public User addUser(User user) {
        UsersRepository.getRepository().add(user);
        return null;
    }

    @Override
    public User getUserById(int id) {
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }


    @Override
    public User getUserByLogin(String login) {

        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public static Map<Integer, Integer> getHasMapStatis() {
        return mapStatistic;
    }

    public static void startStistic() {
        if (mapStatistic.isEmpty()) {
            for (User user : UsersRepository.getRepository()) {
                mapStatistic.put(user.getId(), 0);

            }
        }
    }


    public static void increamentUserStatistics(int id) {
        mapStatistic.put(id, (mapStatistic.get(id) + 1));
    }

    public static void newUserStatistic(Integer id) {
        startStistic();
        mapStatistic.put(id, 0);
    }


    @Override
    public List<String> getUserNames() {
        List<String> userList = new ArrayList<>();

        for (int i = 0; i < UsersRepository.getRepository().size(); i++) {
            userList.add(UsersRepository.getRepository().get(i).getName()) ;
        }

        return userList;
    }
}
