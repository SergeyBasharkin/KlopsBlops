package mvc;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.controllers.CartController;
import com.springapp.mvc.controllers.CatalogController;
import com.springapp.mvc.controllers.GoodController;
import com.springapp.mvc.controllers.LoginController;
import com.springapp.mvc.repositories.CartRepository;
import com.springapp.mvc.repositories.CatalogRepository;
import com.springapp.mvc.repositories.GoodRepository;
import com.springapp.mvc.repositories.hibernate.CatalogRepositoryHibernate;
import com.springapp.mvc.repositories.hibernate.GoodRepositoryHibernate;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.CatalogService;
import com.springapp.mvc.services.GoodService;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import static org.mockito.Mockito.*;

/**
 * Created by Admin on 11.04.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CatalogTest {

    @Configuration
    static class TestContext{
        @Bean
        public GoodService goodService(){
            return new GoodService();
        }
        @Bean
        public CartService cartService(){
            return new CartService();
        }
        @Bean
        public GoodRepository goodRepository(){
            return Mockito.mock(GoodRepository.class);
        }
        @Bean
        public CartRepository cartRepository(){
            return Mockito.mock(CartRepository.class);
        }
        @Bean
        public CatalogService catalogService(){
            return new CatalogService();
        }
        @Bean
        public CatalogRepository catalogRepository(){
            return Mockito.mock(CatalogRepository.class);
        }

    }

    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    GoodRepository goodRepository;


    @Autowired
    CatalogService  catalogService;
    @Autowired
    GoodService goodService;

    @Before
    public void setup(){
        Mockito.when(cartRepository.getUserCarts(new UserInfo())).thenReturn(new ArrayList<CartInfo>());
        Mockito.when(goodRepository.getGoodById(anyLong())).thenReturn(new GoodInfo());
        Mockito.when(catalogRepository.getAllGoods()).thenReturn(new ArrayList<GoodInfo>());
        Mockito.when(goodService.getGood(anyLong())).thenReturn(new GoodInfo());
    }
    @Test
    public void testHandleRequestView() throws Exception {
        LoginController loginController=new LoginController();
        String modelAndView = loginController.renderLoginPage(true);
        assertEquals("login/login", modelAndView);
    }

    @Test
    public void testGoodService(){

        GoodInfo goodInfo= goodService.getGood(1L);
        assertNotNull(goodInfo);

    }

    @Test
    public void testCartService(){
        List<CartInfo> cartInfos= cartService.getUserCarts(new UserInfo());
        assertEquals(0,cartInfos.size());
    }

    @Test
    public void testCataog(){
        List<GoodInfo> goods=catalogService.getAllGoods();
        goods.add(new GoodInfo(BigDecimal.ONE));
        goods.add(new GoodInfo(BigDecimal.TEN));
        goods.add(new GoodInfo(BigDecimal.ZERO));
        catalogService.sortBy("price",goods);
        Object[] goodInfose= goods.toArray();
        Object[] goodses={new GoodInfo(BigDecimal.ONE),new GoodInfo(BigDecimal.TEN),new GoodInfo(BigDecimal.ZERO)};
        assertArrayEquals(goodInfose,goodses);
    }

}
