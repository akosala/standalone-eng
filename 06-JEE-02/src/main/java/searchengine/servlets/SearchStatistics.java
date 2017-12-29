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

@WebServlet("/statistics")
public class SearchStatistics extends HttpServlet {
    @EJB
    UsersRepositoryDao dao;


    @Override
protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if( req.getParameter("id")==null){

            UsersRepositoryDaoBean.startStistic();



        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
writer.printf("Stystayka dla wszystkich logowań");
        for(User user : dao.userList()){



            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<body>");
            writer.println(user.getId() + "<br />");
            writer.println(user.getName() + "<br />");
            writer.println(user.getSurname() + "<br />");
            writer.print(user.getGender()+"<br />");
            writer.println("Statystyka logowania usera: " +
                   UsersRepositoryDaoBean.getHasMapStatis().get(user.getId()) + "<br />");
            writer.println("</body>");
            writer.println("</html>");






        }



}
 }}