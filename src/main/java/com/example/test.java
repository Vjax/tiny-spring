package com.example;

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
            HelloWorld helloWorld = (HelloWorld)applicationContext.getBean("helloworld");
            helloWorld.HelloWorld();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
