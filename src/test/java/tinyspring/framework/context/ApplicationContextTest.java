package tinyspring.framework.context;

import org.junit.Test;
import tinyspring.framework.beans.support.HelloBean;
import tinyspring.framework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wenqing on 2016/4/11.
 */
public class ApplicationContextTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloBean helloBean = (HelloBean) context.getBean("helloBean");
        helloBean.hello();
        //context.getBean("init");
    }
}
