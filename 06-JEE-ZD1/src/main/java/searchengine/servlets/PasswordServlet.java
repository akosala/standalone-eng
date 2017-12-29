package searchengine.servlets;

import org.jboss.crypto.CryptoUtil;
import org.jboss.security.auth.spi.Users;
import org.wildfly.security.authz.Roles;
import searchengine.dao.UsersRepositoryDao;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hash-password")
public class PasswordServlet extends HttpServlet {
    private Users user;

    @EJB
    UsersRepositoryDao dao;
    //UsersRepositoryDao usersRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String hashedPassword = CryptoUtil.createPasswordHash("MD5", "hex", null, null, req.getParameter("password"));
        resp.getWriter().println(hashedPassword);
    }
//FIXME doesn't compile
/*
private void addUserToDB(HttpServletRequest req, Users user) {

    Roles role = new Roles();
    role. ("normal");
    role.setRoleGroup("normal");
    role.setUser(user);
    user.setRole(role);

    try {

        dao.addUser(user);
        //rolesRepositoryDao.addRoles(role);
    } catch (Exception e) {
        log("problem z dodaniem uzytkownika " + e);
    }
    req.getSession().setAttribute(registrationLevel, 4);
}
*/

    /*
       private void password(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


           String hashedPassword = CryptoUtil.createPasswordHash("MD5", "hex", null, null, req.getParameter("j_password"));
            resp.getWriter().println(hashedPassword);

       }*/
/*
    public  String has ( String ar[])   throws Exception
    {


        //String clearTextPassword=ar[0]+":ManagementRealm:"+ar[1];     //---> This is how JBoss Encrypts password

        String clearTextPassword=ar[0] ;
        String hashedPassword=CryptoUtil.createPasswordHash("MD5", "hex", null, null, clearTextPassword);
        //System.out.println("clearTextPassword: "+clearTextPassword);
        //System.out.println("hashedPassword: "+hashedPassword);
    return hashedPassword;
    }*/
}








