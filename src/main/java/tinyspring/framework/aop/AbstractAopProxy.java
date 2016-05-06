package tinyspring.framework.aop;

/**
 * Created by wenqing on 2016/5/5.
 */
public abstract class AbstractAopProxy implements AopProxy{
    private AdvisedSupport advisorSupport;

    public AbstractAopProxy(AdvisedSupport advisorSupport) {
        this.advisorSupport = advisorSupport;
    }

    public AdvisedSupport getAdvisorSupport() {
        return advisorSupport;
    }
}
