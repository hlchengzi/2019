package test.sheji.guanchazhe;


import java.util.Observable;
import java.util.Observer;

public class Subject1 extends Observable {
    String data;
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
        setChanged();    //设置数据更新标准
        notifyObservers();    //通知各个观察者更新数据
    }
}

