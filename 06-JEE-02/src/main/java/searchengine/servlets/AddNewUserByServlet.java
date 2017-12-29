package searchengine.servlets;

import searchengine.dao.UsersRepositoryDao;
import searchengine.dao.UsersRepositoryDaoBean;
import searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddUser")
public class AddNewUserByServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        if (verification(req, resp)) {
            //UsersRepositoryDaoBean.newUserStatistic(Integer.valueOf(req.getParameter("id")));
        } else {
            getUrlParametrs(req, resp);
        }
    }

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


    private void UserExist(HttpServletResponse resp, String name, String surname, int age, int id, String login) {
        try {
            PrintWriter writer = resp.getWriter();
            if (dao.getUserById(id) == null) {
                addNewUser(name, surname, age, id, login);
                writer.println("<!DOCTYPE html>");
                writer.println("<html>");
                writer.println("<body>");
                writer.printf("Dodales Uzytkownika :" + "    " + "<br/>" + "id: " + id + " " + "<br/>" + "imie: " + name + " <br/>" + "nazwisko: " + surname + "<br/>" + "wiek: " + age + "<br/>" + "login: " + login + "<br/>");
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

    public void addNewUser(String name, String surname, int age, int id, String login) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setId(id);
        user.setAge(age);
        user.setLogin(login);
        dao.addUser(user);

    }

    public void getUrlParametrs(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        UserExist(resp, name, surname, age, id, login);
    }
}





