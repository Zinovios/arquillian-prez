package presentation;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import presentation.HomeView.HomePresenter;
import presentation.HomeView.HomeView;
import presentation.HomeView.HomeViewHandler;
import presentation.LoginView.LoginPresenter;
import presentation.LoginView.LoginView;
import presentation.LoginView.LoginViewHandler;
import presentation.RootUI;
import presentation.UIServlet;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Petr Hunka (MiX-CZ)
 */
@RunWith(Arquillian.class)
public class LoginScreenFT {

    static WebArchive microdeploy;

    // create micro-deploy archive (vaadin.war)
    @Deployment(testable = false)
    public static WebArchive createDeployment() {

        // vaadin framework must be present in archive
        Collection<String> dependencies = Arrays.asList(new String[]{
                "com.vaadin:vaadin-server",
                "com.vaadin:vaadin-client-compiled",
                "com.vaadin:vaadin-shared",
                "com.vaadin:vaadin-themes"
        });

        File[] libs = Maven.resolver()
                // path is dependend on mvn or IDE (mvn is without vaadin-example)
                .loadPomFromFile("pom.xml")
                .resolve(dependencies)
                .withTransitivity().asFile();

        microdeploy =  ShrinkWrap.create(WebArchive.class, "vaadin.war")
                .addClasses(RootUI.class, UIServlet.class,
                        LoginView.class, LoginPresenter.class, LoginViewHandler.class,
                        HomeView.class, HomePresenter.class, HomeViewHandler.class)
                .addAsLibraries(libs);

        return microdeploy;

    }

    @Drone
    private WebDriver browser;

    @ArquillianResource
    private URL deploymentUrl;


    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy
    WebElement loginButt;

    @FindBy
    WebElement revealButt;

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Test
    @InSequence
    public void isDeployed(){
        Assert.assertThat(browser, notNullValue());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("==== Functional test is deployed " +
                "on" + browser +
                " under: " + deploymentUrl +
                 " ====");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(microdeploy.toString(true));
    }

    @Test
    @InSequence
    public void clickOnLoginFormAndNavigateToHome() throws InterruptedException {
        // init app by browser url
        browser.get(deploymentUrl.toExternalForm());
        Graphene.waitForHttp(deploymentUrl.toExternalForm());
//        Graphene.waitGui().until().element(username).is().visible();

        // fill login form
        username.sendKeys("demo");
        password.sendKeys("demo");

        // click on sign in butt (Login screen)
        Graphene.guardAjax(loginButt).click();

        // click on reveal me butt (Home screen)
        Graphene.guardAjax(revealButt).click();
        Assert.assertThat(username.getText(), is("demo"));


    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

}
