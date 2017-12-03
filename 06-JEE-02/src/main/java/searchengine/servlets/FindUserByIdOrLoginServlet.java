package searchengine.servlets;

import searchengine.dao.MaxPlus;
import searchengine.dao.MaxPulsBean;
import searchengine.dao.UsersRepositoryDao;
import searchengine.dao.UsersRepositoryDaoBean;
import searchengine.domain.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdOrLoginServlet extends  HelloServlet  {
    @EJB UsersRepositoryDao dao;
    @Inject
    MaxPlus max;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((req.getParameter("id")==null)){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);return;
        }

        UsersRepositoryDaoBean.startStistic();
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        User user = dao.getUserById(Integer.valueOf(id));
        UsersRepositoryDaoBean.increamentUserStatistics(user.getId());

        if(user==null){ resp.setStatus(HttpServletResponse.SC_NOT_FOUND);return;}
        resp.setContentType("text/html;charset=UTF-8");
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("Imie z bazy dla numeru :   " +id+"    "+ user.getName() + "   "+user.getSurname()+"  "+ user.getLogin()+"   "+ "  "+"   puls"+max.puls(user.getAge(),user.getGender()) +"<br/>");

        writer.println(user.getName()+"  "+user.getSurname() + "<br />");
        writer.println("Statystyka dla usera: " +
              UsersRepositoryDaoBean.getHasMapStatis().get(user.getId()) + "<br />");
        writer.println("</body>");
        writer.println("</html>");


    }


}
