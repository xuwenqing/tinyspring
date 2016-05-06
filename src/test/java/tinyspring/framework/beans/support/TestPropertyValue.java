package tinyspring.framework.beans.support;

import tinyspring.framework.beans.BeanWrapper;
import tinyspring.framework.beans.BeanWrapperImpl;
import tinyspring.framework.beans.PropertyValue;
import tinyspring.framework.beans.PropertyValues;
import tinyspring.framework.beans.support.HelloBean;
import tinyspring.framework.beans.support.RootBeanDefinition;

/**
 * Created by wenqing on 2016/4/9.
 */
public class TestPropertyValue {

    public void testPropertyValue() {
        PropertyValues values = new PropertyValues();
        values.addPropertyValue(new PropertyValue("string", new String()));
        values.getPropertyValues();
        RootBeanDefinition beanDefinition = new RootBeanDefinition(HelloBean.class);
        beanDefinition.setPropertyValues(values);

        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        BeanWrapper beanWrapper = new BeanWrapperImpl(new HelloBean());
        beanWrapper.setPropertyValues(propertyValues);

    }

}
