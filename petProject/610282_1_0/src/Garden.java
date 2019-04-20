public class
Garden {
    //表示花坛，位置，大小，花坛设置类型，花坛里面的花
    int x;
    int y;
    int width;
    int heigth;
    int model;
    public int[] garden = new int[12];

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public Garden(int x, int y, int width, int heigth, int model, int[] garden) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.model = model;
        this.garden = garden;
    }

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

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int[] getGarden() {
        return garden;
    }

    public void setGarden(int[] garden) {
        this.garden = garden;
    }
}
