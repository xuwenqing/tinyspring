package tinyspring.framework.aop.support;

import tinyspring.framework.aop.framework.AdvisedSupport;
import tinyspring.framework.aop.framework.AopProxy;
import tinyspring.framework.aop.framework.CglibAopProxy;

/**
 * Created by wenqing on 2017/3/6.
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    protected final AopProxy createAopProxy() {
        return new CglibAopProxy(this);
    }
}