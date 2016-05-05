package tinyspring.framework.aop;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by wenqing on 2016/5/5.
 */
public class CglibAopProxy extends AbstractAopProxy {

    public CglibAopProxy(AdvisorSupport advisorSupport) {
        super(advisorSupport);
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        TargetSource targetSource = getAdvisorSupport().getTargetSource();
        enhancer.setSuperclass(targetSource.getTargetClass());
        enhancer.setInterfaces(targetSource.getInterfaceClasses());
        enhancer.setCallback(new CglibDynamicMethodIntercetor(getAdvisorSupport()));
        return enhancer.create();
    }
}
