package presentation;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;


    /**
     * Petr Hunka (MiX-CZ)
     */
    @WebServlet(value = {"/*"}, asyncSupported = true)
    @VaadinServletConfiguration(
            productionMode = false,
            ui = RootUI.class)
    public class UIServlet extends VaadinServlet {

}