package tinyspring.framework.beans;

import org.junit.Test;
import tinyspring.framework.beans.config.*;
import tinyspring.framework.beans.support.*;
import tinyspring.framework.beans.xml.XmlBeanFactory;
import tinyspring.framework.beans.xml.XmlBeanDefinitionReader;
import tinyspring.framework.core.io.DefaultResourceLoader;

public class TestBeanFactory {

    @Test
    public void testXmlBeanFactory() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new DefaultResourceLoader().getResource("beans.xml"));
        addBeanPostProcessor(beanFactory);
        //xmlBeanDefinitionRegistry(beanFactory);
        beanFactory.getBean("aware");
        beanFactory.getBean("init");
        HelloBean helloBean = (HelloBean) beanFactory.getBean("helloBean");
        helloBean.hello();
    }

    @Test
    public void testXmlDefaultBeanFactory() throws Exception{
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        addBeanPostProcessor(beanFactory);
        xmlBeanDefinitionRegistry(beanFactory);
        beanFactory.getBean("aware");
        beanFactory.getBean("init");
        HelloBean helloBean = (HelloBean) beanFactory.getBean("helloBean");
        helloBean.hello();
    }

    public void xmlBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions(new DefaultResourceLoader().getResource("beans.xml"));
    }

    @Test
    public void testCodeBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
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
