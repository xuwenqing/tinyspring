package tinyspring.framework.context;

import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.config.ConfigurableListableBeanFactory;

/**
 * Created by wenqing on 2016/4/11.
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    ConfigurableListableBeanFactory getBeanFactory();

    void refresh() throws BeansException;
}
