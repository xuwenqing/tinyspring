package tinyspring.framework.aop.support;


public class OutputServiceImpl implements OutputService {
    public void output(String text){
        System.out.println(text);
    }

}
