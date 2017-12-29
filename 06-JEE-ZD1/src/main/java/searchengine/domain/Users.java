package searchengine.domain;


import org.wildfly.security.authz.Roles;

import javax.persistence.*;
@Entity

@NamedQueries({
        @NamedQuery(name = "getUserByLogin", query = "from Users u where u.login=:login"),
        @NamedQuery(name = "getAll", query = "from Users")
})
class Users   {
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
}
