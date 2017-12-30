package searchengine.servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.jboss.crypto.CryptoUtil;
import searchengine.dao.UsersRepositoryDao;
import searchengine.domain.Users;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/AddUserInSteps")
public class AddNewUserByServletInSteps extends HttpServlet {
    @PersistenceContext(name = "pUnit")
    EntityManager entityManager;
    @EJB
    UsersRepositoryDao dao;


    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addUser(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addUser(req, resp);
    }
   // @Stateless
    @Transactional
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = new Users();
        if (req.getParameter("step").equals("1")) {
            req.getSession().setAttribute("id", req.getParameter("id"));

            req.getSession().setAttribute("login", req.getParameter("login"));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add-user2.jsp");
            requestDispatcher.forward(req, resp);
            return;
        } else if (req.getParameter("step").equals("2")) {
            req.getSession().setAttribute("name", req.getParameter("name"));

            req.getSession().setAttribute("surname", req.getParameter("surname"));

            req.getSession().setAttribute("password", CryptoUtil.createPasswordHash("MD5", "hex", null, null, req.getParameter("password")));

            user.setId(Integer.parseInt((String) req.getSession().getAttribute("id")));
            user.setLogin((String) req.getSession().getAttribute("login"));
            user.setName((String) req.getSession().getAttribute("name"));
            user.setSurname((String) req.getSession().getAttribute("surname"));
            user.setPassword((String) req.getSession().getAttribute("password"));

            String login = String.valueOf(req.getSession().getAttribute("login"));
            String name = String.valueOf(req.getSession().getAttribute("name"));
            String surname = String.valueOf(req.getSession().getAttribute("surname"));
            String password = String.valueOf(req.getSession().getAttribute("password"));

            //enti


            //getSf(name, surname, login, password);
           // dao.addUser(user);
            req.setAttribute("okMessage", "User with ID " + user.getId() + " has been added.");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index1.jsp");
            requestDispatcher.forward(req, resp);


            entityManager.getTransaction().begin();

            Users users = new Users();

            users.setName(name);
            users.setSurname(surname);
            users.setLogin(login);
            users.setPassword(password);
            entityManager.persist(users);
            entityManager.getTransaction().commit();

//return;

            //req.setAttribute();
            // req.getSession().invalidate();

        }


    }

    /*public SessionFactory getSf(String name,String surname,String login,String password ) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session s = sf.openSession()) {

            Transaction tx = s.beginTransaction();
            Users o = new Users();
            o.setName(name);
            o.setSurname(surname);
            o.setLogin(login);
            o.setPassword(password);
            s.save(o);
            tx.commit();
            s.close();
        }
        return sf;

    }*/

}
/*

 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (verification(req, resp)) {
            //UsersRepositoryDaoBean.newUserStatistic(Integer.valueOf(req.getParameter("id")));
        } else {
            getUrlParametrs(req, resp);
        }


    }

    public boolean verification(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] newData = {"id", "name", "surname", "age", "login"};
        PrintWriter writer = resp.getWriter();
        for (int i = 0; i < newData.length; i++) {
            if (req.getParameter(newData[i]) == null) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.println("<!DOCTYPE html>");
                writer.println("<html>");
                writer.println("<body>");
                writer.printf("Dodajesz uzytkownika ktoremu brakuje danych" + "   <br/>" + newData[i] + "  is    " + req.getParameterValues(newData[i]) + " !<br/>");
                writer.println("</body>");
                writer.println("</html>");

                return true;
            }
        }
        return false;
    }


    private void UserExist(HttpServletResponse resp, String name, String surname, int age, int id, String login,Gender gender) {
        try {
            PrintWriter writer = resp.getWriter();
            if (dao.getUserById(id) == null) {
                addNewUser(name, surname, age, id, login, gender);
                writer.println("<!DOCTYPE html>");
                writer.println("<html>");
                writer.println("<body>");
                writer.printf("Dodales Uzytkownika :" + "    " + "<br/>" + "id: " + id + " " + "<br/>" + "imie: " + name + " <br/>" + "nazwisko: " + surname + "<br/>" + "wiek: " + age + "<br/>" + "login: " + login + "<br/>"+ "gender: " + gender + "<br/>");
                writer.println("</body>");
                writer.println("</html>");
            } else {
                writer.print("Uzytkownik juz dodany");
                resp.setStatus(HttpServletResponse.SC_CONFLICT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewUser(String name, String surname, int age, int id, String login, Gender gender) {

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setId(id);
        user.setAge(age);
        user.setLogin(login);
        user.setGender(gender);
        dao.addUser(user);

    }

    public void getUrlParametrs(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        Gender gender = null;
        UserExist(resp, name, surname, age, id, login,gender);
    }
}




*/
