package searchengine.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Welcome")
public class WelcomeUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", req.getParameter("name"));
        req.getSession().setAttribute("sessionName", req.getParameter("name"));
        req.setAttribute("salary", req.getParameter("salary"));
        req.getSession().setAttribute("sessionSalary", req.getParameter("salary"));


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/welcome-user.jsp");
        requestDispatcher.forward(req, resp);

        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
       if(req.getParameter("name")==null){ resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);return;}

       resp.setContentType("text/html;charset=UTF-8");

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("Test imienia"+"    "+ name+ "!<br/>");
        writer.println("</body>");
        writer.println("</html>");


}}
