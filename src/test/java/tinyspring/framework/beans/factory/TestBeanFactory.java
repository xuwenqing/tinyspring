package tinyspring.framework.beans.factory;

import org.junit.Test;
import tinyspring.framework.beans.factory.config.BeanDefinition;
import tinyspring.framework.beans.factory.support.BeanDefinitionRegistry;
import tinyspring.framework.beans.factory.support.DefaultListableBeanFactory;
import tinyspring.framework.beans.factory.support.RootBeanDefinition;

public class TestBeanFactory {

    @Test
    public void initBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanDefinitionRegistry(beanFactory);
        HelloBean helloBean = (HelloBean) beanFactory.getBean("helloBean");
        helloBean.hello();
    }

    public void beanDefinitionRegistry(BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = new RootBeanDefinition(HelloBean.class);
        registry.registerBeanDefinition("helloBean", beanDefinition);
    }
}
