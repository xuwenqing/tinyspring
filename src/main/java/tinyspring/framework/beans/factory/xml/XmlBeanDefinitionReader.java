package tinyspring.framework.beans.factory.xml;

import org.junit.Assert;
import tinyspring.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import tinyspring.framework.beans.BeansException;
import tinyspring.framework.beans.factory.support.AbstractBeanDefinitionReader;
import tinyspring.framework.beans.factory.support.BeanDefinitionRegistry;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wenqing on 2016/4/10.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    private DocumentLoader documentLoader = new DefaultDocumentLoader();
    private Class<?> documentReaderClass = DefaultBeanDefinitionDocumentReader.class;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public void loadBeanDefinitions(Resource resource) throws BeansException {
        Assert.assertNotNull(resource);
        try {
            //从Resource中获取inputStream
            InputStream inputStream = resource.getInputStream();
            try {
                InputSource inputSource = new InputSource(inputStream);
                doLoadBeanDefinitions(inputSource, resource);    //真正的逻辑核心
            }
            finally {
                inputStream.close();    //关闭inputStream
            }
        }
        catch (IOException ex) {
            throw new BeansException("IOException parsing XML document from " + resource, ex);
        }
    }

    /**
     * 真正的核心处理部分
     * 如果不考虑冗余的代码，其实只做三件事：
     *  1.获取XML文件的验证模式
     *  2.加载XML，并获取Document.
     *  3.返回的Document，注册Bean
     *  这里不实现验证
     */
    protected void doLoadBeanDefinitions(InputSource inputSource, Resource resource) {
        // 取得XML文件的Document对象, 这个解析过程由DefaultDocumentLoader完成
        Document doc = null;
        try {
            doc = doLoadDocument(inputSource, resource);
        } catch (Exception e) {
            throw new BeansException("获取document失败",e);
        }
        // 启动对BeanDefinition解析的详细过程, 解析过程中会使用到Spring的Bean配置规则
        try {
            registerBeanDefinitions(doc, resource);
        } catch (Exception e) {
            throw new BeansException("解析document失败",e);
        }
    }

    protected Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
        //loadDocument直接用于注册Document，getValidationModeForResource方法作用于XML的加载
        return this.documentLoader.loadDocument(inputSource);
    }

    public void registerBeanDefinitions(Document doc, Resource resource) throws Exception {
        BeanDefinitionDocumentReader documentReader = createBeanDefinitionDocumentReader();
        documentReader.registerBeanDefinitions(doc,getRegistry());
    }

    protected BeanDefinitionDocumentReader createBeanDefinitionDocumentReader() throws IllegalAccessException, InstantiationException {
        return BeanDefinitionDocumentReader.class.cast(this.documentReaderClass.newInstance());
    }
}
