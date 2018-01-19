package searchengine.dao;

import searchengine.domain.Roles;
import searchengine.domain.Users;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RolesReposytory {
    boolean addRole(Roles roles);
    Roles getUser_role(String user_role);
    Roles getRole_goup(String role_group);
    Roles getUser_login(String user_login);


}
