package test.sheji.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
    private  Object targer = null;

    public Object bind(Object targer){
        this.targer =targer;
        /**
         * 下面这句是建立代理对象和真实对象之间的关系。这里使用build方法完成的，方法里面首先使用类的属性targer保存了真实对象
         * 然后通过以下代码建立并生成代理对象。
         */
        return Proxy.newProxyInstance(targer.getClass().getClassLoader(),targer.getClass().getInterfaces(),this);
    }
    /**
     * 在jdk的动态代理当中，要实现代理逻辑类就必须去实现java.lang.reflect.InvocationHandler接口，它里面定义了一个方法invoke（）
     * 并提供接口数组用于挂代理对象。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        Object obj = method.invoke(targer,args);
        //相当于sayHelloWorld方法
        return obj;
    }
}
