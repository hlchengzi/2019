package test.sheji.组合模式;

import java.io.File;

public class zuheTest {
    public static void createTree(Node node) throws Exception {
        File f = new File(node.name);
        File f2[] = f.listFiles();
        for(int i=0;i<f2.length;i++){
            if(f2[i].isFile()){
                Node node2 = new FileNode(f2[i].getAbsolutePath());
                node.addNode(node2);
            }
            if(f2[i].isDirectory()){
                Node node2 = new FileNode(f2[i].getAbsolutePath());
                node.addNode(node2);
                createTree(node2);
            }
        }

    }
    public static void main(String[] args) throws Exception {
        Node start = new DirectNode("E://data");
        createTree(start);
        start.display();
    }
}
