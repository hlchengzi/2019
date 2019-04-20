package test.sheji.适配器;

/**
 * 适配器方法当中的主题，我们能不能既在开发当中使用第三方软件，又能用上所定义的Imath接口呢？
 */
public class shipeiqi {
    ThirdCompany third;
    public shipeiqi(ThirdCompany third){
        this.third = third;
    }

        //方法add只是起到一个转换器的作用，具体内容都是由第三方软件完成的
    public int add(int a,int b){
        return third.addCalc(a,b);
    }
}
