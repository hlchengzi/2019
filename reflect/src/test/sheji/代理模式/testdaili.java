package test.sheji.代理模式;

public class testdaili {
    public  static void main(String args[]) {
        JdkProxyExample jdk = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }

}
