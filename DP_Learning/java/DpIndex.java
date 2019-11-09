

import java.util.LinkedList;
import java.util.List;

public class DpIndex {

    /**
     *指数机制 给定一个打分数组，然后从其中按照指数机制公式输出其的索引
     * @param score
     * @param sensity
     * @param eps
     * @return
     */
    public static int dpIndex(List<Double> score,Double sensity, Double eps){
        int m = score.size();
        double r= Math.random();
        List<Double> exponents_list = new LinkedList();
        exponents_list.add(Math.log(0.5*(score.get(0)*eps/sensity)));
        for(int i=1;i<m;i++){
            exponents_list.add(Math.log(0.5*(score.get(i)*eps/sensity)));
        }

        double sum=exponents_list.stream().mapToDouble(Double::doubleValue).sum();
        for(int i=0;i<m;i++)
            exponents_list.set(i,exponents_list.get(i)/sum);
        double sum_exp=0;
        int j=0;
        for(;;j++)
        {
            sum_exp=sum_exp+exponents_list.get(j);
            if(sum_exp>r)
                break;
        }
       return j;
    }
}
