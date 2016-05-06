package tinyspring.framework.beans.support;

import tinyspring.framework.beans.InitializingBean;

/**
 * Created by wenqing on 2016/4/10.
 */
public class InitMethod implements InitializingBean {
    public void afterPropertiesSet() {
        System.out.println("invoke InitMethod afterPropertiesSet");
    }
}
