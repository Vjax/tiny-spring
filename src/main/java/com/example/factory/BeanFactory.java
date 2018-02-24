package com.example.factory;

import com.example.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    public Object getBean(String name);

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition) throws Exception;
}
