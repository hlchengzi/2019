package test.sheji.guanchazhe;

import java.util.Observable;
import java.util.Observer;

public class oneObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Subject1 subject = (Subject1)o;
        System.out.println("现在主题类的数据是："+subject.getData());
    }
}
