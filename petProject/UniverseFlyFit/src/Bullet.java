/**
 * 子弹类:是飞行物
 */
public class Bullet extends FlyingObject {
    private int speed = 3;  //移动的速度

    /** 初始化数据 */
    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
        this.image = ShootGame.bullet;
    }

    /** 移动 */
    /**
     * 在本案当中，子弹移动是x，y方向都同时移动的
     */
    @Override
    public void step(){
        y-=speed;
    }

    /** 越界处理 */
    @Override
    public boolean outOfBounds() {
        return y<-height;
    }

}