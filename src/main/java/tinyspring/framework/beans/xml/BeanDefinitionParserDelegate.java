package tinyspring.framework.beans.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tinyspring.framework.beans.PropertyValue;
import tinyspring.framework.beans.config.BeanDefinition;
import tinyspring.framework.beans.config.BeanDefinitionHolder;
import tinyspring.framework.beans.config.BeanReference;
import tinyspring.framework.beans.config.TypedStringValue;
import tinyspring.framework.beans.support.RootBeanDefinition;

/**
 * Created by wenqing on 2016/4/10.
 * BeanDefinition解析代理
 */
public class BeanDefinitionParserDelegate {
    public static final String BEAN_ELEMENT = "bean";
    public static final String BEAN_id = "id";
    public static final String BEAN_CLASS = "class";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String VALUE_ELEMENT = "value";
    public static final String REF_ELEMENT = "ref";

    /**
     * 解析bean
     * @param ele
     * @return
     */
    public BeanDefinitionHolder parseBeanDefinitionElement(Element ele) {
        String name = ele.getAttribute(BEAN_id);
        String className = ele.getAttribute(BEAN_CLASS);
        BeanDefinition beanDefinition = new RootBeanDefinition(className);
        processProperty(ele, beanDefinition);
        BeanDefinitionHolder bdHolder = new BeanDefinitionHolder(beanDefinition,name);
        return bdHolder;
    }

    /**
     * 解析bean中的property
     */
    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName(PROPERTY_ELEMENT);
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute(NAME_ATTRIBUTE);
                String value = propertyEle.getAttribute(VALUE_ELEMENT);
                if (value != null && value.length() > 0) {
                    //name,value
                    TypedStringValue typevalue = new TypedStringValue(value);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, typevalue));
                } else {
                    //name,ref
                    String ref = propertyEle.getAttribute(REF_ELEMENT);
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }

    public boolean nodeNameEquals(Node node, String desiredName) {
        return desiredName.equals(node.getNodeName()) || desiredName.equals(getLocalName(node));
    }
    public String getLocalName(Node node) {
        return node.getLocalName();
    }
}
