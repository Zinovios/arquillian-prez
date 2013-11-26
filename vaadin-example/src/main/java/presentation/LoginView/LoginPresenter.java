package presentation.LoginView;

import com.vaadin.ui.UI;
import presentation.RootUI;

/**
 * Petr Hunka (MiX-CZ)
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
