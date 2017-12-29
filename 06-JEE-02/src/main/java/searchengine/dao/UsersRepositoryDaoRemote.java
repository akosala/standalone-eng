package searchengine.dao;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UsersRepositoryDaoRemote {
    public List<String>  getUserNames() ;
}
