package com.example;

import com.example.factory.AutowireCapableBeanFactory;
import com.example.factory.BeanFactory;
import com.example.io.ResourceLoader;
import com.example.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class test {

    @Test
    public void test(){
        try {
            XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
            xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml");

            BeanFactory factory = new AutowireCapableBeanFactory();
            for (Map.Entry<String,BeanDefinition>beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
                factory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
            }
            HelloWorld helloWorld = (HelloWorld)factory.getBean("helloworld");
            helloWorld.HelloWorld();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
