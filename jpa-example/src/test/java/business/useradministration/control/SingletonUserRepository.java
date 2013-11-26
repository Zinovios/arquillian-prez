package business.useradministration.control;

import business.useradministration.entity.NullUser;
import business.useradministration.entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Petr Hunka (MiX-CZ)
 */
@Singleton
@Lock(LockType.READ)
public class SingletonUserRepository implements UserRepository {
    private List<User> users;

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================
    public SingletonUserRepository() {
    }

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Override
    @Lock(LockType.WRITE)
    public void store(User newUser) {
        if (!users.contains(newUser)){
            users.add(newUser);
        }
        else throw new IllegalArgumentException("User already there!");
    }

    @Override
    public User getUserByUsername(String username){
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return new NullUser();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================
    @PostConstruct
    private void init(){
        users = new ArrayList<User>();
    }


    //==============================================================================
    //  GET & SET 
    //==============================================================================

}
