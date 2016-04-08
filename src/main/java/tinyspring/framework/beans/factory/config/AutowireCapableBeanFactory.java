package tinyspring.framework.beans.factory.config;

import tinyspring.framework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {
    <T> T createBean(Class<T> beanClass);
}
