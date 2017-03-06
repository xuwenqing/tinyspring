package tinyspring.framework.aop.support;

import org.aopalliance.aop.Advice;

/**
 * Created by wenqing on 2017/3/6.
 */
public interface Advisor {
    Advice getAdvice();
}
