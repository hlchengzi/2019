

public class DpLaplace {

    /**
     * laplace  指数机制，根据全局敏感度和隐私参数确定所添加的噪音大小
     * @param sensity 全局敏感度
     * @param eps  隐私参数
     * @return
     */
    public static double dpLaplace(double sensity,double eps){
        double beta = sensity/eps;
        double u1 =Math.random();
        double u2 =Math.random();
        if(u1< 0.5)
            return (-1 * beta * Math.log(1.0 - u2));
        else
            return (-1*beta*Math.log(u2));
    }

}
