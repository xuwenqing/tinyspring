package tinyspring.framework.beans.factory;

import org.junit.Test;
import tinyspring.framework.beans.PropertyValue;
import tinyspring.framework.beans.PropertyValues;
import tinyspring.framework.beans.factory.config.*;
import tinyspring.framework.beans.factory.support.BeanDefinitionRegistry;
import tinyspring.framework.beans.factory.support.DefaultListableBeanFactory;
import tinyspring.framework.beans.factory.support.RootBeanDefinition;

public class TestBeanFactory {

    @Test
    public void initBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        registryAware(beanFactory);
        registryInit(beanFactory);
        addBeanPostProcessor(beanFactory);
        beanDefinitionRegistry(beanFactory);
        beanFactory.getBean("aware");
        beanFactory.getBean("init");
        HelloBean helloBean = (HelloBean) beanFactory.getBean("helloBean");
        helloBean.hello();
    }

    public void addBeanPostProcessor(ConfigurableBeanFactory factory) {
        BeanPostProcessor beanPostProcessor = new TestBeanPostProcessor();
        factory.addBeanPostProcessor(beanPostProcessor);
    }

    public void registryInit(BeanDefinitionRegistry registry) {
        BeanDefinition bd_init = new RootBeanDefinition(InitMethod.class);
        registry.registerBeanDefinition("init", bd_init);
    }

    public void registryAware(BeanDefinitionRegistry registry) {
        BeanDefinition bd_aware = new RootBeanDefinition(BeanAware.class);
        registry.registerBeanDefinition("aware",bd_aware);
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
