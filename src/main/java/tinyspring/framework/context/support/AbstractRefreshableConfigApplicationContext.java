package tinyspring.framework.context.support;

/**
 * Created by wenqing on 2016/4/11.
 */
public abstract class AbstractRefreshableConfigApplicationContext extends AbstractRefreshableApplicationContext {
    //资源路径集合
    private String[] configLocations;

    public AbstractRefreshableConfigApplicationContext() {
    }

    public void setConfigLocation(String location) {
        setConfigLocations(new String[]{location});
    }

    public void setConfigLocations(String[] locations) {
        if (locations != null) {
            this.configLocations = new String[locations.length];
            for (int i = 0; i < locations.length; i++) {
                this.configLocations[i] = locations[i].trim();
            }
        } else {
            this.configLocations = null;
        }
    }

    protected String[] getConfigLocations() {
        return (this.configLocations != null ? this.configLocations : getDefaultConfigLocations());
    }

    protected String[] getDefaultConfigLocations() {
        return null;
    }
}
