package searchengine.dao;


import searchengine.domain.Gender;
import searchengine.domain.User;
import searchengine.domain.Users;
import searchengine.servlets.AddNewUserByServletInSteps;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Stateless
public class UsersRepository {
    private static List<User> usersRepository = new ArrayList<>();
//Users users;
    public static List<User> getRepository() {
        if (usersRepository.size() == 0) {
            fillRepositoryWithDefaults();
        }
        return usersRepository;
    }

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;
    public boolean addUser(Users users) {

        users.setLogin("4");
        users.setName("2");
        users.setSurname("3");
        users.setPassword("4");
        entityManager.persist(users);
       // System.out.println("User " + users + " added");


        return true;
    }

    public Users getUserById(int id) {
        return entityManager.find(Users.class, id);
    }

    public Users getUserByLogin(String login) {
        return (Users) entityManager.createNamedQuery("getUserByLogin")
                .setParameter("login", login)
                .getSingleResult();
    }

    public List<Users> getUsersList() {
        return entityManager.createNamedQuery("getAll")
                .getResultList();
    }
    private static void fillRepositoryWithDefaults() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Jan");
        user1.setSurname("Kowalski");
        user1.setLogin("janko");
        user1.setAge(21);
        user1.setGender(Gender.MEN);
        usersRepository.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("Adam");
        user2.setSurname("Nowak");
        user2.setLogin("ano");
        user2.setAge(20);
        user2.setGender(Gender.MEN);
        usersRepository.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Anna");
        user3.setSurname("Michalczuk");
        user3.setLogin("anmi");
        user3.setAge(20);
        user3.setGender(Gender.WOMEN);
        usersRepository.add(user3);

        User user4 = new User();
        user4.setId(4);
        user4.setName("Adam");
        user4.setSurname("Kosala");
        user4.setLogin("Krolik");
        user4.setAge(40);
        user4.setGender(Gender.MEN);
        usersRepository.add(user4);
    }
}
