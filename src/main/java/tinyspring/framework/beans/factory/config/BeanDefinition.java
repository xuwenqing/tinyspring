package tinyspring.framework.beans.factory.config;

public interface BeanDefinition {
    Class<?> getBeanClass();

    String getBeanClassName();

    void setBeanClass(Class<?> beanClass);

    void setBeanClassName(String beanClassName);
}
