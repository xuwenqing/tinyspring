package tinyspring.framework.aop.support;

import tinyspring.framework.aop.Pointcut;

/**
 * Created by wenqing on 2017/3/6.
 */
public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();
}
