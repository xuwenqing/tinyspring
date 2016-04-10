package tinyspring.framework.beans.factory.support;

import tinyspring.framework.beans.PropertyValues;
import tinyspring.framework.beans.factory.config.BeanDefinition;

public class RootBeanDefinition implements BeanDefinition {
    private volatile Object beanClass;
    //bean属性
    private PropertyValues propertyValues;

    public RootBeanDefinition(String beanClass) {
        super();
        propertyValues = new PropertyValues();
        setBeanClassName(beanClass);
    }

    public RootBeanDefinition(Class<?> beanClass) {
        super();
        propertyValues = new PropertyValues();
        setBeanClass(beanClass);
    }



    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClass = beanClassName;
        try {
            beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return this.propertyValues;
    }

    public void setPropertyValues(PropertyValues pvs) {
        this.propertyValues = pvs;
    }

    public Class<?> getBeanClass() {
        Object beanClassObject = this.beanClass;
        return (Class<?>) beanClassObject;
    }

    public String getBeanClassName() {
        Object beanClassObject = this.beanClass;
        if (beanClassObject instanceof Class) {
            return ((Class<?>) beanClassObject).getName();
        } else {
            return (String) beanClassObject;
        }
    }

}
