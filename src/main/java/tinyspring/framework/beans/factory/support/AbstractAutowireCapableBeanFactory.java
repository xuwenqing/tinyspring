package tinyspring.framework.beans.factory.support;

import tinyspring.framework.beans.factory.config.AutowireCapableBeanFactory;
import tinyspring.framework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
        implements AutowireCapableBeanFactory {

    public <T> T createBean(Class<T> beanClass) {
        RootBeanDefinition mbd = new RootBeanDefinition(beanClass);
        return (T) createBean(beanClass.getName(), mbd);
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition mbd) {
        Class<?> beanClass = mbd.getBeanClass();
        Object bean = null;
        try {
            bean = beanClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }


}
