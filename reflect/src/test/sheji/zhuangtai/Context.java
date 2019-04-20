package test.sheji.zhuangtai;

public class Context {
    private Istate istate;
    public void setState(Istate state){
        this.istate = state;
    }

    public void manage(){
        istate.getState();
    }
}
