package wsparcie;

import searchengine.dao.UsersRepositoryDaoRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Hello world!
 *
 */
public class App 
{
    UsersRepositoryDaoRemote repositoryDaoRemote;

    public static void main( String[] args ) throws NamingException {
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", "true");
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        properties.put(Context.SECURITY_PRINCIPAL, "akosala");
        properties.put(Context.SECURITY_CREDENTIALS, "7312Koska");
        Context context = new InitialContext(properties);
        UsersRepositoryDaoRemote generator =
                (UsersRepositoryDaoRemote)
                        context.lookup("search-engine/UsersRepositoryDaoBean!searchengine.dao.UsersRepositoryDaoRemote");

        for (int i=0; i<generator.getUserNames().size();i++) {
            System.out.println(generator.getUserNames().get(i));

        }

        System.out.println( generator.getUserNames() );

    }
}
