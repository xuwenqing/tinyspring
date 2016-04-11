package tinyspring.framework.beans.xml;

import org.w3c.dom.Document;
import tinyspring.framework.beans.support.BeanDefinitionRegistry;

/**
 * Created by wenqing on 2016/4/10.
 */
public interface BeanDefinitionDocumentReader {
    void registerBeanDefinitions(Document doc, BeanDefinitionRegistry beanDefinitionRegistry);
}
