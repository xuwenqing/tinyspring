package tinyspring.framework.aop.support;

import org.aopalliance.aop.Advice;
import tinyspring.framework.aop.Pointcut;

/**
 * Created by wenqing on 2017/3/6.
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor{
    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public Advice getAdvice() {
        return advice;
    }
}
