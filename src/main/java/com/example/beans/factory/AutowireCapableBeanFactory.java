package com.example.beans.factory;

import com.example.beans.BeanDefinition;
import com.example.BeanReference;
import com.example.beans.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws Exception{
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
            Field field = bean.getClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            Object value = propertyValue.getValue();
            if(value instanceof BeanReference){
                BeanReference beanReference = (BeanReference)value;
                value = getBean(beanReference.getName());
            }
            field.set(bean,value);
        }
    }
}
