package test.sheji.组合模式;

import java.util.ArrayList;

public class DirectNode extends Node {
    private ArrayList<Node> nodeList = new ArrayList();

    public DirectNode(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println("direct"+name);
        for(int i=0;i<nodeList.size();i++){
            nodeList.get(i).display();
        }
    }
}

