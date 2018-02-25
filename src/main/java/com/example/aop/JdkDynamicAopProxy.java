package com.example.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicAopProxy implements AopProxy,InvocationHandler {

    private AdvicedSupport adviced;

    public JdkDynamicAopProxy(AdvicedSupport adviced){
        this.adviced = adviced;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{adviced.getTargetSource().getTargetClass()},this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = adviced.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(adviced.getTargetSource().getTarget(),method,args));
    }
}
