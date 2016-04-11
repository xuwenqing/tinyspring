package tinyspring.framework.context.support;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.support.DefaultListableBeanFactory;
import tinyspring.framework.beans.xml.XmlBeanDefinitionReader;
import tinyspring.framework.core.io.Resource;

/**
 * Created by wenqing on 2016/4/11.
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableConfigApplicationContext {

    public AbstractXmlApplicationContext() {
    }

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        // Create a new XmlBeanDefinitionReader for the given BeanFactory.
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        //设置ResourceLoader
        beanDefinitionReader.setResourceLoader(this);
        loadBeanDefinitions(beanDefinitionReader);
    }

    protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) throws BeansException {
        Resource[] configResources = getConfigResources();
        if (configResources != null) {
            reader.loadBeanDefinitions(configResources);
        }
        //AbstractRefreshableConfigApplicationContext父类中实现
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            reader.loadBeanDefinitions(configLocations);
        }
    }

    protected Resource[] getConfigResources() {
        //ClassPathXmlApplicationContext实现
        return null;
    }
}
