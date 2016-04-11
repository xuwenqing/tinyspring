package tinyspring.framework.beans.config;

import tinyspring.framework.beans.PropertyValues;

public interface BeanDefinition {
    Class<?> getBeanClass();

    String getBeanClassName();

    void setBeanClass(Class<?> beanClass);

    void setBeanClassName(String beanClassName);

    PropertyValues getPropertyValues();

    void setPropertyValues(PropertyValues pvs);
}
