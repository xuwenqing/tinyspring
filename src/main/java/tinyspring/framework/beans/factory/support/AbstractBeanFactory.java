package tinyspring.framework.beans.factory.support;

import tinyspring.framework.beans.factory.config.BeanDefinition;
import tinyspring.framework.beans.factory.config.ConfigurableBeanFactory;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    public Object getBean(String name) {
        return doGetBean(name);
    }

    protected Object doGetBean(String name) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null)
            return sharedInstance;
        final BeanDefinition mbd = getBeanDefinition(name);
        Object bean = createBean(name, mbd);
        //将新创建的bean注册到单例容器中，spring源码采用ObjectFactory的方式
        super.registerSingleton(name, bean);
        return bean;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition mbd);
}
