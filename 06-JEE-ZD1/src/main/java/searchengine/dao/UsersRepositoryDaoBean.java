package searchengine.dao;

import searchengine.Interceptor.AddUserInterceptor;
/*import searchengine.domain.User;*/
import searchengine.domain.Roles;
import searchengine.domain.User;
import searchengine.domain.Users;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao,UsersRepositoryDaoRemote,RolesReposytory {

    @EJB
    private UserRepositoryN usersRepository;
    private RolesReposytory rolesReposytory;

    @Override
   // @Interceptors({ AddUserInterceptor.class})
    public boolean addUser(Users users) {
        usersRepository.addUser(users);
        return true;
    }


    @Override
    public Users getUserById(int id) {
        return usersRepository.getUserById(id);
    }

    @Override
    public Users getUserByLogin(String login) {
        return usersRepository.getUserByLogin(login);
    }

    @Override
    public List<User> userList() {
        return null;
    }


    public List<Users> getUsersList() {
        return usersRepository.getUsersList();
    }


    public List<String> getUsersNames() {
        List<String> usersNames = new ArrayList<>();
        for (Users user : getUsersList()) {
            usersNames.add(user.getName());
        }
        return usersNames;
    }

    @Override
    public List<String> getUserNames() {
        return null;
    }

    @Override
    public boolean addRole(Roles roles) {
        rolesReposytory.addRole(roles);
        return true;
    }

    @Override
    public Roles getUser_role(String user_role) {
        return null;
    }

    @Override
    public Roles getRole_goup(String role_group) {
        return null;
    }

    @Override
    public Roles getUser_login(String user_login) {
        return null;
    }
/*

    private static Map<Integer, Integer> mapStatistic = new HashMap<>();
   // @PersistenceContext(name = "pUnit")
   // EntityManager entityManager;

    @Override

    public List<User> userList() {
        return UsersRepository.getRepository();
    }

    @Override
    @Interceptors(AddUserInterceptor.class)
    public Users addUser(Users user) {
        UsersRepository.getRepository().add(user);
        return null;
    }

    @Override
    public Users getUserById(int id) {
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }


    @Override
    public Users getUserByLogin(String login) {

        List<Users> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return (Users) user;
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
    }*/
}
