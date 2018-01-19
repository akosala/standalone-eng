package searchengine.domain;



import javax.persistence.*;



@Entity
@Table (name="roles")
public class Roles  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "user_role")
    private String user_role;

    @Column(name = "role_group")
    private String role_group;

    @Column(name = "user_login")
    private String user_login;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String userRole) {
        this.user_role = userRole;
    }

    public String getRole_group() {
        return role_group;
    }

    public void setRole_group(String roleGroup) {
        this.role_group = roleGroup;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

