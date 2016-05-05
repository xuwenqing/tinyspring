package tinyspring.framework.aop;

/**
 * Created by wenqing on 2016/5/5.
 */
public abstract class AbstractAopProxy implements AopProxy{
    private AdvisorSupport advisorSupport;

    public AbstractAopProxy(AdvisorSupport advisorSupport) {
        this.advisorSupport = advisorSupport;
    }

    public AdvisorSupport getAdvisorSupport() {
        return advisorSupport;
    }
}
