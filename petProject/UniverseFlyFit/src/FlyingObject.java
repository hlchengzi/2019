import java.awt.image.BufferedImage;

/**
 * 飞行物(三种小行星，外星飞船，我方飞机)，都是由图片组成，图片背景设成黑色
 */
public abstract class FlyingObject {
    protected int x;    //x坐标 
    protected int y;    //y坐标 
    protected int width;    //宽 
    protected int height;   //高
    protected int speed_x;
    protected int speed_y;
    protected BufferedImage image;   //图片 

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed_x() {
        return speed_x;
    }

    public void setSpeed_x(int speed_x) {
        this.speed_x = speed_x;
    }

    public int getSpeed_y() {
        return speed_y;
    }

    public void setSpeed_y(int speed_y) {
        this.speed_y = speed_y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * 检查是否出界
     * @return true 出界与否
     */
    public abstract boolean outOfBounds();

    /**
     * 飞行物移动一步
     */
    public abstract void step();

    /**
     * 检查当前飞行物体是否被子弹(x,y)击(shoot)中
     * @param Bullet 子弹对象
     * @return true表示被击中了
     */
    public boolean shootBy(Bullet bullet){
        int x = bullet.x;  //子弹横坐标 
        int y = bullet.y;  //子弹纵坐标 
        return !(this.x+this.width<x || x>this.x+width && this.y+this.height<y && y+bullet.height<this.y);
    }

}