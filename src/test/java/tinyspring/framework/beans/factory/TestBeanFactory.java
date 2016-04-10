package tinyspring.framework.beans.factory;

import org.junit.Test;
import tinyspring.framework.beans.PropertyValue;
import tinyspring.framework.beans.PropertyValues;
import tinyspring.framework.beans.factory.config.BeanDefinition;
import tinyspring.framework.beans.factory.config.BeanReference;
import tinyspring.framework.beans.factory.config.TypedStringValue;
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
        BeanDefinition bd_hello = new RootBeanDefinition(Hello.class);

        BeanDefinition bd_HelloBean = new RootBeanDefinition(HelloBean.class);
        PropertyValue hello_pv = new PropertyValue("hello",new BeanReference("hello"));
        PropertyValue string_pv = new PropertyValue("stringbean",new TypedStringValue("stringbeanvalue"));
        PropertyValues pvs = new PropertyValues();
        pvs.addPropertyValue(hello_pv);
        pvs.addPropertyValue(string_pv);
        bd_HelloBean.setPropertyValues(pvs);

        registry.registerBeanDefinition("hello",bd_hello);
        registry.registerBeanDefinition("helloBean", bd_HelloBean);
    }
}
