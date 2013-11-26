package business.useradministration.control;

import business.useradministration.entity.NullUser;
import business.useradministration.entity.StoredUser;
import business.useradministration.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * <p>
 * GEMALTO s.r.o., Prague, ICS <br/>
 * StoredUser: Petr Hunka #petr.hunka@gemalto.com <br/>
 * Date: 11/18/13 <br/>
 * Time: 1:37 PM
 * <p/>
 *
 */
public class DBUserRepository implements UserRepository{

    @PersistenceContext
    EntityManager em;

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Override
    public void store(User newUser) {
        if(NullUser.class.isInstance(getUserByUsername(newUser.getUsername()))){
            em.persist(newUser);
        }
        else throw new IllegalArgumentException("User already in repository!");
    }

    @Override
    public User getUserByUsername(String username) {
        Query q = em.createNamedQuery(StoredUser.FIND_BY_USERNAME);
        q.setParameter(StoredUser.USERNAME, username);
        if(!q.getResultList().isEmpty()){
            return (StoredUser) q.getResultList().get(0);
        }
        else return new NullUser();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Query q = em.createNamedQuery(StoredUser.FIND_ALL);
        return  (List<User>) q.getResultList();
    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

}