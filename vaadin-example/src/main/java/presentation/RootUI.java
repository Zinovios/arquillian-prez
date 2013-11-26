package presentation;

import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import presentation.HomeView.HomePresenter;
import presentation.HomeView.HomeView;
import presentation.LoginView.LoginPresenter;
import presentation.LoginView.LoginView;

/**
 * <p>
 * GEMALTO s.r.o., Prague, ICS <br/>
 * User: Petr Hunka #petr.hunka@gemalto.com <br/>
 * Date: 11/22/13 <br/>
 * Time: 4:29 PM <br/>
 * </p>
 */
@Title("Arquillian test")
public class RootUI extends UI {
    // view presenters
    private LoginPresenter loginPresenter;
    private HomePresenter homePresenter;
    // view shortcuts
    public static final String LOGIN_VIEW = "loginView";
    public static final String HOME_VIEW = "homeView";
    // app navigator
    protected Navigator navigator;


    protected void init(VaadinRequest request) {
        preparePresenters();
        createNavigator();
    }


    private void preparePresenters(){
        loginPresenter = new LoginPresenter(new LoginView());
        homePresenter = new HomePresenter(new HomeView());
    }

    private void createNavigator() {
        navigator = new Navigator(this, this);
        getCurrent().getNavigator().addView(LOGIN_VIEW, loginPresenter.getView());
        getCurrent().getNavigator().addView(HOME_VIEW, homePresenter.getView());
        navigator.navigateTo(LOGIN_VIEW);
    }

}
