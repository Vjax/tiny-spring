package com.example;

import com.example.factory.BeanFactory;
import org.junit.Test;

public class test {

    @Test
    public void test(){
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorld());
        BeanFactory factory = new BeanFactory();
        factory.registerBeanDefinition("helloworld",beanDefinition);
        HelloWorld helloWorld = (HelloWorld)factory.getBean("helloworld");
        helloWorld.HelloWorld();
    }
}
