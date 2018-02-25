package com.example;

import com.example.aop.AdvicedSupport;
import com.example.aop.JdkDynamicAopProxy;
import com.example.aop.TargetSource;
import com.example.beans.BeanDefinition;
import com.example.beans.factory.AutowireCapableBeanFactory;
import com.example.beans.io.ResourceLoader;
import com.example.beans.xml.XmlBeanDefinitionReader;
import com.example.context.ApplicationContext;
import com.example.context.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.util.Map;

public class test {

    @Test
    public void test(){
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
            HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
            helloWorldService.helloWorld();

            AdvicedSupport advicedSupport = new AdvicedSupport();
            TargetSource targetSource = new TargetSource(helloWorldService,HelloWorldService.class);
            advicedSupport.setTargetSource(targetSource);

            TimerInterceptor timerInterceptor = new TimerInterceptor();
            advicedSupport.setMethodInterceptor(timerInterceptor);

            JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy((advicedSupport));
            HelloWorldService helloWorldServiceProxy = (HelloWorldService)jdkDynamicAopProxy.getProxy();
            helloWorldServiceProxy.helloWorld();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
