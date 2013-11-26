package business.useradministration.boundary;

import business.useradministration.control.UserRepository;
import business.useradministration.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Stateless
public class Storage {

    @Inject
    private UserRepository userRepository;

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    //==============================================================================
    //  PUBLIC  
    //==============================================================================

    /**
     * Async call for storing StoredUser object into repository
     * @param newUser
     */
//    @Asynchronous
    public void store(User newUser){
        userRepository.store(newUser);
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

}
