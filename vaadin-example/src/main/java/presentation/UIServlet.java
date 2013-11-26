package presentation;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

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

}