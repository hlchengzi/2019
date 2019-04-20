package test.sheji.组合模式;

public class FileNode extends Node {
    public FileNode(String name){
        super(name);
    }

    @Override
    void display() {
        System.out.println("yezi"+name);
    }
}
