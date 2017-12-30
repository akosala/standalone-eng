package searchengine.dao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import searchengine.domain.Users;



@Stateless
public class UsersRepositoryDb {

    @PersistenceContext(unitName = "pUnit")
        private EntityManager entityManager;

        public boolean addUser(Users users) {
            entityManager.persist(users);
            System.out.println("User " + users + " added");


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
    }