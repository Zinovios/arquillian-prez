package business.useradministration.entity;

/**
 * <p>
 * GEMALTO s.r.o., Prague, ICS <br/>
 * StoredUser: Petr Hunka #petr.hunka@gemalto.com <br/>
 * Date: 11/18/13 <br/>
 * Time: 1:37 PM
 * <p/>
 *
 * Implementation of User interface (NullObject pattern). This class should be utilized as
 * return value instead of null.
 */
public class NullUser implements User{
    private String username;
    private String password;
    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================
    public NullUser() {
        username = "NULL";
        password = "NULL";
    }


    //==============================================================================
    //  PUBLIC  
    //==============================================================================

    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================
    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
