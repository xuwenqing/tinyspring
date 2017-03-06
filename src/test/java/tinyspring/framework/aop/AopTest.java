package tinyspring.framework.aop;

import org.junit.Test;
import tinyspring.framework.aop.support.HelloWorldService;
import tinyspring.framework.context.ApplicationContext;
import tinyspring.framework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wenqing on 2017/3/6.
 */
public class AopTest {
    @Test
    public void testInterceptor() throws Exception {
        // --------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
