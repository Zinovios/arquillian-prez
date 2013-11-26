package presentation.HomeView;

/**
 * Petr Hunka (MiX-CZ)
 */
public class HomePresenter implements HomeViewHandler{

    private HomeView view;

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================


    public HomePresenter(HomeView view) {
        this.view = view;
        view.addViewHandler(this);
    }

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Override
    public void whoAmI() {
        view.getUsername().setValue("demo");
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
