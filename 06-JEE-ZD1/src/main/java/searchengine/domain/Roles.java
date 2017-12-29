package searchengine.domain;



import javax.persistence.*;



@Entity
@Table 
class Roles  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "user_role")
    private String user_role;

    @Column(name = "role_group")
    private String role_group;


    @OneToOne
    @JoinColumn(name = "login")
    private Users user_login;

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

    public Users getUser_login() {
        return user_login;
    }

    public void setUser_login(Users user) {
        this.user_login = user;
    }
}

