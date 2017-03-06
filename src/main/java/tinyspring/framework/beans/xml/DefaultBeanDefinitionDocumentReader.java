package tinyspring.framework.beans.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tinyspring.framework.beans.config.BeanDefinitionHolder;
import tinyspring.framework.beans.support.BeanDefinitionRegistry;

/**
 * Created by wenqing on 2016/4/10.
 */
public class DefaultBeanDefinitionDocumentReader implements BeanDefinitionDocumentReader {
    public static final String BEAN_ELEMENT = BeanDefinitionParserDelegate.BEAN_ELEMENT;
    public static final String NESTED_BEANS_ELEMENT = "beans";
    protected final Log logger = LogFactory.getLog(getClass());
    private BeanDefinitionParserDelegate delegate;
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public void registerBeanDefinitions(Document doc, BeanDefinitionRegistry beanDefinitionRegistry) {
        logger.info("Loading bean definitions");
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        Element root = doc.getDocumentElement();
        doRegisterBeanDefinitions(root);
    }

    protected void doRegisterBeanDefinitions(Element root) {
        this.delegate = createDelegate();
        //preProcessXml(root); 未实现
        parseBeanDefinitions(root, this.delegate);
        //postProcessXml(root);未实现
    }

    protected BeanDefinitionParserDelegate createDelegate() {
        return new BeanDefinitionParserDelegate();
    }

    protected void parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate) {
        NodeList nl = root.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if(node instanceof  Element) {
                Element ele = (Element) node;
                parseDefaultElement(ele,delegate);
            }
        }
    }

    private void parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) {
        //默认有import,alias,只实现bean和beans
        if (delegate.nodeNameEquals(ele, BEAN_ELEMENT)) {
            //解析bean
            processBeanDefinition(ele, delegate);
        }
        else if (delegate.nodeNameEquals(ele, NESTED_BEANS_ELEMENT)) {
             //递归注册beans
            doRegisterBeanDefinitions(ele);
        }
    }

    protected void processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate) {
        BeanDefinitionHolder bdHolder = delegate.parseBeanDefinitionElement(ele);
        if (bdHolder != null) {
            //这里将BeanDefinition注册到BeanFactory中
            beanDefinitionRegistry.registerBeanDefinition(bdHolder.getBeanName(),bdHolder.getBeanDefinition());
        }
    }
}
