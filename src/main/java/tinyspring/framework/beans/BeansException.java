package tinyspring.framework.beans;

/**
 * Created by wenqing on 2016/4/10.
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg,cause);
    }
}
