package searchengine.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;


@WebFilter(
        filterName = "SalarIncremetFilter",
        urlPatterns = "/Welcome",
        initParams = {
                @WebInitParam(name = "newSalary", value = "150.0")

        }
)


public class SalarIncremetFilter implements javax.servlet.Filter {
    double newSalary = 1.0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        newSalary = Double.parseDouble(filterConfig.getInitParameter("newSalary"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String reqSalary = request.getParameter("salary");
        if (reqSalary == null || reqSalary.isEmpty()) {
            reqSalary = "0.0";
        }
        double salary = Double.parseDouble(reqSalary);
        if (salary < 100.0) {
            salary = newSalary;
        }
        request.setAttribute("salary", salary);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        newSalary = 0.0;
    }
}
