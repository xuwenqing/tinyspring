package tinyspring.framework.beans.factory.support;

import tinyspring.framework.beans.PropertyValue;
import tinyspring.framework.beans.factory.config.BeanDefinition;
import tinyspring.framework.beans.factory.config.BeanReference;
import tinyspring.framework.beans.factory.config.TypedStringValue;

/**
 * Created by wenqing on 2016/4/10.
 */
public class BeanDefinitionValueResolver {
    private final AbstractBeanFactory beanFactory;

    public BeanDefinitionValueResolver(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveValueIfNecessary( Object value) {
        //省略对list,map,set等类型的属性值解析,省略对TypedStringValue的类型转换
        //只解析ref和value
        if(value instanceof BeanReference) {
            value = beanFactory.getBean(((BeanReference) value).getName());
        }
        else if(value instanceof TypedStringValue) {
            value = ((TypedStringValue) value).getVaule();
        }
       return value;
    }

}
