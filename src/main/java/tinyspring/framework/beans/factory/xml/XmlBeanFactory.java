package tinyspring.framework.beans.factory.xml;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.factory.support.DefaultListableBeanFactory;
import tinyspring.framework.core.io.Resource;

/**
 * Created by wenqing on 2016/4/10.
 */
public class XmlBeanFactory extends DefaultListableBeanFactory {
    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);

    public XmlBeanFactory(Resource resource) throws BeansException {
        this.reader.loadBeanDefinitions(resource);
    }
}
