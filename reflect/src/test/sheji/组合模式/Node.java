package test.sheji.组合模式;

/**
 * 定义抽象节点类node
 */
abstract class Node {
    protected String name;
    public Node(String name){
        this.name = name;
    }
    public  void addNode(Node node)throws Exception{
        throw new Exception("Invalid exception");
    }
    abstract void display();
}
