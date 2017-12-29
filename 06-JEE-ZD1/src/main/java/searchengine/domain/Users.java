package searchengine.domain;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import javax.persistence.*;
@Entity
@Table (name = "users")
@NamedQueries({
        @NamedQuery(name = "getUserByLogin", query = "from Users u where u.login=:login"),
        @NamedQuery(name = "getAll", query = "from Users")
})
public class Users extends User {
    public Users() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    private String name;
    private String surname;
    private String login;
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public SessionFactory getSf(String name,String surname,String login,String password ) {


        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        Transaction tx = s.beginTransaction();
        Users o= new Users();
        o.setName(name);
        o.setSurname(surname);
        o.setLogin( login);
        o.setPassword(password);
        s.save(o);
        tx.commit();
        s.close();
       return sf;

    }





    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password=" + password +
                '}';
    }

}
