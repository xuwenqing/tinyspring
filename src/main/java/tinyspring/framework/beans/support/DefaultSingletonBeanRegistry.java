package tinyspring.framework.beans.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tinyspring.framework.beans.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    //单例bean实例容器
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

    //向容器中注册实例
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    //获取实例
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
}
