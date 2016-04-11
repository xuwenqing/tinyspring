package tinyspring.framework.beans.config;

/**
 * Created by wenqing on 2016/4/9.
 */
public class BeanReference {
    private String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
