package tinyspring.framework.context.support;

import tinyspring.framework.core.io.ClassPathResource;
import tinyspring.framework.core.io.Resource;

/**
 * Created by wenqing on 2016/4/11.
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    private Resource[] configResources;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String... configLocations) {
        //加载资源
        setConfigResources(configLocations);
        //调用AbstractApplicationContext中的refresh
        refresh();
    }

    public void setConfigResources(String[] locations) {
        this.configResources = new Resource[locations.length];
        for (int i = 0; i < locations.length; i++) {
            this.configResources[i] = new ClassPathResource(locations[i]);
        }
    }

    @Override
    protected Resource[] getConfigResources() {
        return this.configResources;
    }
}
