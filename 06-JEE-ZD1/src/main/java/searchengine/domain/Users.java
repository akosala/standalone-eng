package searchengine.domain;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.wildfly.security.authz.Roles;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table (name = "users")
@DiscriminatorValue ("users")
@NamedQueries(value = {
        @NamedQuery(name = "getUserByLogin", query = "from Users u where u.login=:login"),
        @NamedQuery(name = "getAll", query = "from Users")
        // @NamedQuery(name = "insertUser", query = "insert into Users  where u.login=:login"),
})
public class Users  implements Serializable {
    public Users() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
