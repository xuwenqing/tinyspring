package tinyspring.framework.beans.factory.config;

import org.junit.Assert;

/**
 * Created by wenqing on 2016/4/10.
 */
public class BeanDefinitionHolder {
    private final BeanDefinition beanDefinition;
    private final String beanName;

    public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName) {
        Assert.assertNotNull("BeanDefinition must not be null",beanDefinition);
        Assert.assertNotNull("Bean name must not be null",beanName);
        this.beanDefinition = beanDefinition;
        this.beanName = beanName;
    }

    public BeanDefinition getBeanDefinition() {
        return beanDefinition;
    }

    public String getBeanName() {
        return beanName;
    }
}

