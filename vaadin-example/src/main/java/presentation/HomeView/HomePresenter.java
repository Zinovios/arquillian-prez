package presentation.HomeView;

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
