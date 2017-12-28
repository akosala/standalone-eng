package searchengine.servlets;

import searchengine.dao.UsersRepositoryDao;
import searchengine.domain.Gender;
import searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static searchengine.domain.Gender.MEN;

@WebServlet("/AddUserInSteps")
public class AddNewUserByServletInSteps extends HttpServlet {

    @EJB
    UsersRepositoryDao dao;

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addUser(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addUser(req,resp);
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        if (req.getParameter("step").equals("1")) {
            req.getSession().setAttribute("id", req.getParameter("id"));

            req.getSession().setAttribute("login", req.getParameter("login"));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add-user2.jsp");
            requestDispatcher.forward(req, resp);
           return;
        } else if (req.getParameter("step").equals("2")) {
            req.getSession().setAttribute("name", req.getParameter("name"));

            req.getSession().setAttribute("surname", req.getParameter("surname"));

            req.getSession().setAttribute("age", req.getParameter("age"));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add-user3.jsp");
            requestDispatcher.forward(req, resp);
            return;
        } else if (req.getParameter("step").equals("3")) {

    req.getSession().setAttribute("gender", req.getParameter("gender"));
            user.setId(Integer.parseInt((String) req.getSession().getAttribute("id")));
            user.setLogin((String) req.getSession().getAttribute("login"));
            user.setName((String) req.getSession().getAttribute("name"));
            user.setSurname((String) req.getSession().getAttribute("surname"));
            user.setAge(Integer.parseInt((String) req.getSession().getAttribute("age")));
            user.setGender((Gender) req.getSession().getAttribute(String.valueOf(MEN)));
/*
          if(MEN.equals(req.getParameter("gender"))){
                user.setGender((Gender) req.getSession().getAttribute(String.valueOf(MEN)));
            }else {
                user.setGender((Gender) req.getSession().getAttribute(String.valueOf(Gender.WOMEN)));
            }*/
            dao.addUser(user);
            req.setAttribute("okMessage", "User with ID " + user.getId() + " has been added.");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index1.jsp");
            requestDispatcher.forward(req, resp);


//return;

            //req.setAttribute();
           // req.getSession().invalidate();

        }


    }}
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
