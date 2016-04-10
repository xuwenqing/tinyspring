package tinyspring.springframework.core.io;

/**
 * Created by wenqing on 2016/4/10.
 */
public interface ResourceLoader {
    Resource getResource(String location);
    ClassLoader getClassLoader();
}
