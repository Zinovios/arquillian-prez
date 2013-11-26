package presentation.LoginView;

import com.vaadin.ui.UI;
import presentation.RootUI;

/**
 * <p>
 * GEMALTO s.r.o., Prague, ICS <br/>
 * User: Petr Hunka #petr.hunka@gemalto.com <br/>
 * Date: 11/22/13 <br/>
 * Time: 4:29 PM <br/>
 * </p>
 */
public class LoginPresenter implements LoginViewHandler{

    private LoginView view;


    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================


    public LoginPresenter(LoginView view) {
        this.view = view;
        view.addViewHandler(this);
    }

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Override
    public void signIn() {
        UI.getCurrent().getNavigator().navigateTo(RootUI.HOME_VIEW);
    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

    public LoginView getView() {
        return view;
    }
}
