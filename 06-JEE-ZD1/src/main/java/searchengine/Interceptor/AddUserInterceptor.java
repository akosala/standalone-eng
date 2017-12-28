package searchengine.Interceptor;

import searchengine.domain.Gender;
import searchengine.domain.User;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;


public class AddUserInterceptor {
    Logger logger = Logger.getLogger(AddUserInterceptor.class.getName());
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        Object[] parameters = context.getParameters();
        User user = (User) parameters[0];
        if(user.getGender()==null){
            user.getName().endsWith("a");
            user.setGender(Gender.WOMEN);



        }else{
            user.setGender(Gender.MEN);
        }
return context.proceed();
    }

}

