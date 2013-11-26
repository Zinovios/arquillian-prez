package business.useradministration.control;

import business.useradministration.entity.User;

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
public interface UserRepository {
    /**
     * Save user object to DB
     */
    public void store(User user);

    /**
     * Find StoredUser object with specified username. If username is
     * not find, NullUser is return.
     *
     * @param username String
     * @return StoredUser or NullUser (if it's find or not)
     */
    public User getUserByUsername(String username);

    /**
     * Get all User objects from repository
     * @return List<User>
     */
    public List<User> getAllUsers();
}
