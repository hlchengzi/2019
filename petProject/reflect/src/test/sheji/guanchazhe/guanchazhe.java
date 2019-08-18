package test.sheji.guanchazhe;


import javafx.beans.Observable;

import java.util.Vector;



public class guanchazhe {

    /**
     * 观察者接口
     */
    public interface IObserver{
        public void refresh(String data);
        }

    /**
     * 主题者接口
     */
    public interface ISubject{
        public void register(IObserver obs);       //注册观察者
        public void unregister(IObserver obs);  //撤销观察者
        public void notifyObserver();           //通知所有观察者
    }

    /**
     * 主题实现者
     */
    public static class Subject implements ISubject{

        private Vector<IObserver> vec = new Vector();
        private String data;

        public String getData(){
            return data;
        }

        public void setData(String data){
            this.data = data;
        }

        @Override
        public void register(IObserver obs) {
            vec.add(obs);
        }

        @Override
        public void unregister(IObserver obs) {
            if(vec.contains(obs)){
                vec.remove(obs);
            }
        }

        @Override
        public void notifyObserver() {
            for (int i=0;i<vec.size();i++){
                IObserver obs = vec.get(i);
                obs.refresh(data);
            }
        }
    }

    /**
     * 一个具体的观察者类
     */

    public static class Observer implements IObserver{
        private int a;
        Observer(int data){
            this.a=data;
        }
        public  void refresh(String data){
            System.out.println("fresh data"+"1:"+a+"2:"+data);
        }
    }

//    class spy extends Thread{
//        private  IObserver obs = new Observer(11);
//        Subject subject = new Subject();
//
//    }

    public static void main(String[] args){
        /**
         * 向主题当中添加观察者，主题当中的值发生变化时，在观察者里面随之就会改变
         */
        IObserver obs = new Observer(11);//观察者
        IObserver obs1 = new Observer(22);//观察者
        Subject subject = new Subject();//主题,既被观察者，当被观测者的状态发生变化时，相应的观察者应该也要做出一定的状态
        subject.register(obs);
        subject.register(obs1);
        subject.setData("hello");
        subject.notifyObserver();
        subject.setData("nihao");
        subject.notifyObserver();
    }

    /**
     * JDK当中提供的方法
     */


}
