package presentation;

import business.useradministration.boundary.UserStorage;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * <p>
 * GEMALTO s.r.o., Prague, ICS <br/>
 * User: Petr Hunka #petr.hunka@gemalto.com <br/>
 * Date: 11/22/13 <br/>
 * Time: 4:29 PM <br/>
 * </p>
 *
 * Responsible for injecting EJB services into specific view presenter.
 * Reference on this Provider is passed via UI constructor and implementation
 * of a specific UIProvider.
 *
 */
@Singleton
public class InjectProvider {

    @Inject
    private UserStorage userStorage;

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    public UserStorage inject(){
        return this.userStorage;
    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================


    //==============================================================================
    //  GET & SET 
    //==============================================================================

}
