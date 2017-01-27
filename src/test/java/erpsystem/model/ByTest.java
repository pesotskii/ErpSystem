package erpsystem.model;


import erpsystem.config.AppConfig;
import erpsystem.config.application.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class,})
public class ByTest {
    @Autowired
    Bye bye;

//    @Before
//    public void something(){
//
//    }

    @Test
    public void getByeTest() {
        assertEquals("Something going wrong", "bye", bye.getBye());
    }

}
