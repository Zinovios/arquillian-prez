package presentation;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

    /**
    * <p>
    * GEMALTO s.r.o., Prague, ICS <br/>
    * User: Petr Hunka #petr.hunka@gemalto.com <br/>
    * Date: 11/22/13 <br/>
    * Time: 4:29 PM <br/>
    * </p>
    */
    @WebServlet(value = {"/*"}, asyncSupported = true)
    @VaadinServletConfiguration(
            productionMode = false,
            ui = RootUI.class)
    public class UIServlet extends VaadinServlet {


    @Inject
    private InjectProvider injectProvider;

    /** CDI Workaround -> CDI don't work in Vaadin beans, only in
        Vaadin servlet, which extend classic Servlet. So
        reference of InjectProvider is passed via CustomUIProvider.
        -> responsible for instantiating of UI objects. Reference
        is passed via UI constructor
     */
    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new SessionInitListener() {
            @Override
            public void sessionInit(SessionInitEvent sessionInitEvent) throws ServiceException {
                sessionInitEvent.getSession().addUIProvider(
                        new CustomUIProvider(injectProvider)
                );
            }
        });
    }
}