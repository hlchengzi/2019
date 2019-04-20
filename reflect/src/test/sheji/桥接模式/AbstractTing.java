package test.sheji.桥接模式;

abstract class AbstractTing {
    private Ipost ipost;
    public AbstractTing(Ipost ipost){
        this.ipost = ipost;
    }
    public void post(){
        ipost.post();
    }
}
