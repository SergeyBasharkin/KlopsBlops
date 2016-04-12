package mvc;

import com.springapp.mvc.controllers.CatalogController;
import com.springapp.mvc.controllers.LoginController;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

/**
 * Created by Admin on 11.04.2016.
 */
public class CatalogTest {
    @Test
    public void testHandleRequestView() throws Exception {
        LoginController loginController=new LoginController();
        String modelAndView = loginController.renderLoginPage(true);
        assertEquals("login/login", modelAndView);
    }
}
