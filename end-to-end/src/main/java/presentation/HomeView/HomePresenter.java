package presentation.HomeView;

import business.useradministration.boundary.UserStorage;
import com.vaadin.ui.UI;
import presentation.RootUI;

import javax.inject.Inject;

/**
 * <p>
 * GEMALTO s.r.o., Prague, ICS <br/>
 * User: Petr Hunka #petr.hunka@gemalto.com <br/>
 * Date: 11/22/13 <br/>
 * Time: 4:29 PM <br/>
 * </p>
 */
public class HomePresenter implements HomeViewHandler{

    private HomeView view;
    private UserStorage model;

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    @Inject
    public HomePresenter(HomeView view, UserStorage model) {
        this.view = view;
        this.model = model;
        view.addViewHandler(this);
    }

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Override
    public void whoAmI() {
        System.out.println("SIGN OUT");
        view.setUsername(((RootUI) UI.getCurrent()).getCurrUser().toString());
    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

    public HomeView getView() {
        return view;
    }
}
