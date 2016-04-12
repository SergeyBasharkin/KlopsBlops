package mvc;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.controllers.CatalogController;
import com.springapp.mvc.controllers.LoginController;
import com.springapp.mvc.repositories.CatalogRepository;
import com.springapp.mvc.repositories.hibernate.CatalogRepositoryHibernate;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.CatalogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    @Test
    public void testCatalogService(){


    }

}
