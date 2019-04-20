import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyJpanel extends JPanel {
    Image image=null;
    public  void  point(Graphics g){
        try{
            image = ImageIO.read(new File(""));
        }catch (Exception e){

        }
    }
//    Image image=null;
//            public void paint(Graphics g){
//        try {
//            image= ImageIO.read(new File("H:\\aa.jpg"));
//            g.drawImage(image, 0, 0, 550, 400, null);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
