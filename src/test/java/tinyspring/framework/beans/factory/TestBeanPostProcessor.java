package tinyspring.framework.beans.factory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.factory.config.BeanPostProcessor;

/**
 * Created by wenqing on 2016/4/10.
 */
public class TestBeanPostProcessor implements BeanPostProcessor{

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("postProcessBeforeInitialization"+bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("postProcessAfterInitialization" + bean);
        return bean;
    }
}
