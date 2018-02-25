package com.example.beans.factory;

import com.example.beans.BeanDefinition;

public interface BeanFactory {

    public Object getBean(String name) throws Exception;

}
