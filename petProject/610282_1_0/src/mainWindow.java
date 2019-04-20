import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class mainWindow extends JFrame {
    public Garden[] gardens = new Garden[12];
    int gardenNUm=0;
    JLabel jlab= new JLabel("Garden Design SYstem",JLabel.CENTER);
    JPanel jp1 = new JPanel(new GridLayout(6, 1,100,25));
    JPanel jp = new JPanel();
    public mainWindow() throws HeadlessException {

        //word style
        readFile();
        System.out.print("个数");
        System.out.println(gardenNUm);
        final Font font = new Font("宋体", Font.BOLD, 32);
        final Font font1 = new Font("宋体", Font.BOLD, 18);
        final Font font2 = new Font("宋体", Font.BOLD, 15);
        int[] a={0,0,0,0,0,0,0,0,0,0,0,0};
        for(int i=0;i<12;i++){
            gardens[i]= new Garden(0,0,240,200,0,a);
        }
        BorderLayout layout = new BorderLayout();
        //this.setSize(1000,800);
//    //流式布局
//    this.setLayout(layout);
        //最上边的标题
        this.setLayout(null);
        jlab.setSize(1000,100);
        jlab.setFont(font);
        //  中间的花坛
//        addGardenImage(100,100,0,a);
//
        if(gardenNUm==0){
            System.out.println("ADDIMAGE（）");
            addGardenImage();
        }
        else {
            System.out.println("ADD（）");
            ADD();
        }

        //现在写左边的菜单
        JLabel lab = new JLabel("园林管理");
        lab.setFont(font1);

        JLabel lab1 = new JLabel("添加花圃：1");
        lab1.setFont(font2);

        JLabel lab2 = new JLabel("移除花圃：2");
        lab2.setFont(font2);

        JLabel lab21 = new JLabel("保存&退出：3");
        lab21.setFont(font2);

        JLabel lab3 = new JLabel("选择：");

        JTextField textField = new JTextField();
//        //textField.setBounds(120, 20, 190, 22);
//        textField.setSize(200,60);
//        textField.setVisible(true);
        jp1.add(lab);
        //jp1.add(new JLabel(" "));
        jp1.add(lab1);
        jp1.add(lab2);
        jp1.add(lab21);
        jp1.add(lab3);
        jp1.add(textField);
        jp1.setSize(100,700);
        jp1.setBackground(Color.pink);
        //设置显示主窗口
        //this.add( new JButton("花坛"),BorderLayout.CENTER);
        jlab.setBounds(0,0,1000,100);
//    this.add(jlab,BorderLayout.NORTH);
        this.add(jlab);
        jp1.setBounds(0,100,100,700);
        this.add(jp1);
        jp.setBounds(100,100,900,700);
        jp.setBackground(Color.green);
        this.add(jp);
//    this.add(jp1,BorderLayout.WEST);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //textText
                if(textField.getText().equals("1")){
                    //添加花坛
                    addGarden();
                }
                else if(textField.getText().equals("2")){
//                addInfo("输入2");
                    deleteGarden();
                }
                else if(textField.getText().equals("3")){
                    System.exit(0);
                }
                else {
                    //表示不是合理的输入
//                final mainWindow myFrame = new mainWindow();
//                myFrame.addInfo("输入错误");
                    addInfo("输入错误");
                }
            }
        });



    }
    //构造函数结束



    //删除花坛
    public void deleteGarden(){
        File f = new File("src\\gardenText.txt");
        if(f.exists()) {
            try {
             if(!f.exists()) {
             f.createNewFile();
             }
             FileWriter fileWriter =new FileWriter(f);
             fileWriter.write("");
             fileWriter.flush();
             fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            gardenNUm=0;
        }
        //删除花坛还删除花坛的保存文件
        jp.removeAll();
        repaint();
        System.out.println("删除结束");
    }
    //添加错误信息 string为提示的错误信息类型
    public void addInfo(final String string) {
        final JFrame f = new JFrame("提示");
        f.setLayout(null);
        f.setBounds(1000, 200, 300, 100);
        f.setVisible(true);
        final JLabel label = new JLabel(string);
        label.setBounds(30, 20, 250, 20);
        final Font f1 = new Font("宋体", Font.BOLD, 12);
        label.setFont(f1);
        f.add(label);
//        JTextField textField = new JTextField();
//        textField.setBounds(120, 20, 190, 22);
//        //textField.setSize(40,10);
//        textField.setVisible(true);
//        f.add(textField);

    }
    public void readFile() {
        try {
            String file = "src\\gardenText.txt";
            String str=null;
            str = new String();
            gardenNUm=0;
            FileReader fr = new FileReader(file);
            BufferedReader bre = new BufferedReader(fr);//此时获取到的bre就是整个文件的缓存流
            while ((str = bre.readLine()) != null) // 判断最后一行不存在，为空结束循环
            {
                System.out.print("read:");
                String[] s =str.split(",");
                gardens[gardenNUm].x=Integer.parseInt(s[0]);
                gardens[gardenNUm].y=Integer.parseInt(s[1]);
                gardens[gardenNUm].width=Integer.parseInt(s[2]);
                gardens[gardenNUm].heigth=Integer.parseInt(s[3]);
                gardens[gardenNUm].model=Integer.parseInt(s[4]);
                String s6 = s[5];
                if (gardens[gardenNUm].model==0){
                    //表示横着设置颜色将其取出来转为数组
                    for(int i=0;i<(int)(gardens[gardenNUm].heigth/20);i++)
                    {
                        char j=s6.charAt(i);
                        String str1 = String.valueOf(j);
                        gardens[gardenNUm].garden[i]=Integer.parseInt(str1);
                    }
                }
                else{
                    //表示横着设置颜色将其取出来转为数组
                    for(int i=0;i<(int)(gardens[gardenNUm].width/20);i++)
                    {
                        char j=s6.charAt(i);
                        String str1 = String.valueOf(j);
                        gardens[gardenNUm].garden[i]=Integer.parseInt(str1);
                    }

                }
                System.out.print("X");
                System.out.println(s[0]);
                gardenNUm+=1;
            }
            bre.close();
            fr.close();
        }catch (Exception e){

        }

    }

    public void writeFile(){
        //写之前进行删除
        System.out.println("gardNum"+String.valueOf(gardenNUm));
        try{
//        File file = new File("src\\gardenText.txt");
        BufferedWriter bw= new BufferedWriter(new FileWriter("src\\gardenText.txt"));
        for(int i=0;i<gardenNUm;i++) {
            String x = String.valueOf(gardens[i].x);
            String y = String.valueOf(gardens[i].y);
            String width = String.valueOf(gardens[i].width);
            String height = String.valueOf(gardens[i].heigth);
            String model = String.valueOf(gardens[i].model);
            String shuzu = new String();

            for (int j = 0; j < gardens[i].garden.length; j++) {
//                System.out.print(gardens[i].garden[j]);
                shuzu += String.valueOf(gardens[i].garden[j]);
            }
            String buf = new String(x + ',' + y + ','+width+','+height+',' + model + ',' + shuzu);
            System.out.println(buf);
            bw.write(buf);
            bw.newLine();
            System.out.println(" add ok");
            }
            bw.flush();
        bw.close();
        }
        catch (Exception e){

        }
    }

    public void ADD(){
        //根据全部的加到图片上
        readFile();
        System.out.print(gardenNUm);
        ImageIcon img1 = new ImageIcon("src\\IMAGE\\sunFlower.jpg");// 创建图片对象
        ImageIcon img2 = new ImageIcon("src\\IMAGE\\tea.jpg");// 创建图片对象
        ImageIcon img3 = new ImageIcon("src\\IMAGE\\rose.jpg");// 创建图片对象

        JPanel[] jpp= new JPanel[12];
        jp.removeAll();
        for(int ii=0;ii<gardenNUm;ii++) {
            int xx=(int)(gardens[ii].width/20);
            int yy=(int)(gardens[ii].heigth/20);
            jpp[ii] = new JPanel();
            jpp[ii].setLayout(null);
            JLabel[] labels = new JLabel[xx*yy];
            jp.setLayout(null);
            for (int i = 0; i < labels.length; i++) {
                labels[i] = new JLabel();
                labels[i].setSize(20, 20);
                labels[i].setBounds(20 * (int) (i % xx), 20 * (int) (i / xx), 20, 20);
                jpp[ii].add(labels[i]);
                if(gardens[ii].model==0){
                    //添加图片时候是按花色横着来着
                    switch (gardens[ii].garden[(int)(i/xx)]){
                        case 0:labels[i].setIcon(img1);labels[i].setBackground(Color.BLUE);break;
                        case 1:labels[i].setIcon(img2);break;
                        case 2:labels[i].setIcon(img3);break;
                        default:labels[i].setIcon(img1);
                    }

                }
                else {
                    switch (gardens[ii].garden[(int)(i%xx)]){
                        case 0:labels[i].setIcon(img1);break;
                        case 1:labels[i].setIcon(img2);break;
                        case 2:labels[i].setIcon(img3);break;
                        default:labels[i].setIcon(img1);
                    }
                }
            }
            System.out.println(ii);
            System.out.print(gardens[ii].x);
            System.out.print(gardens[ii].y);
            jpp[ii].setBounds(gardens[ii].x, gardens[ii].y, xx*20, yy*20);
            jp.add(jpp[ii]);
        }
//        jp.setLayout(null);
//        jpp[0].setBounds(100, 100, 240, 200);
//        jpp[1].setBounds(100, 400, 240, 200);
//        jpp[2].setBounds(500, 100, 240, 200);
//        jpp[3].setBounds(500, 400, 240, 200);


        jp.revalidate();
        jp.repaint();
        System.out.print("succefful");

    }
    //添加花坛处理
//    public boolean addGardenImage(int x,int y,int model,int shuzu[]){
    public boolean addGardenImage(){
        ImageIcon img1 = new ImageIcon("src\\IMAGE\\sunFlower.jpg");// 创建图片对象
        ImageIcon img2 = new ImageIcon("src\\IMAGE\\tea.jpg");// 创建图片对象
        ImageIcon img3 = new ImageIcon("src\\IMAGE\\rose.jpg");// 创建图片对象
        if(true){
//            System.out.print(x);
//            System.out.print(y);
//            System.out.println(model);

            JPanel[] jpp= new JPanel[12];
            jp.removeAll();
            for(int ii=0;ii<4;ii++) {
                jpp[ii] = new JPanel();
                jpp[ii].setLayout(null);
                JLabel[] labels = new JLabel[120];
//            int t=0;
                for (int i = 0; i < labels.length; i++) {
                    labels[i] = new JLabel();
                    if(ii<3){
                    switch (ii) {
                        case 0:labels[i].setIcon(img1);break;
                        case 1:labels[i].setIcon(img2);break;
                        case 2:labels[i].setIcon(img3);break;
                        default:break;
                        }
                    }
                    else{
                        int[] a={0,1,2,0,1,2,0,1,2,0,1,2};
                        switch (a[(int) (i % 12)]) {
                            case 0:
                                labels[i].setIcon(img1);
                                break;
                            case 1:
                                labels[i].setIcon(img2);
                                break;
                            case 2:
                                labels[i].setIcon(img3);
                                break;
                            default:
                                labels[i].setIcon(img1);
                        }
                    }
                    labels[i].setSize(20, 20);
                    labels[i].setBounds(20 * (int) (i % 12), 20 * (int) (i / 12), 20, 20);
                    jpp[ii].add(labels[i]);
                }
            }

            jp.setLayout(null);
            jpp[0].setBounds(100, 100, 240, 200);
            jpp[1].setBounds(100, 400, 240, 200);
            jpp[2].setBounds(500, 100, 240, 200);
            jpp[3].setBounds(500, 400, 240, 200);

            jp.add(jpp[0]);
            jp.add(jpp[1]);
            jp.add(jpp[2]);
            jp.add(jpp[3]);

            jp.revalidate();
            jp.repaint();
            System.out.print("succefful");
        }
        else {
            return false;
        }
        return true;
    }

    public void addGarden(){
        final JFrame f = new JFrame("添加花坛");
        ADD();

        BorderLayout layout = new BorderLayout();
        f.setLayout(layout);

        f.setBounds(1000, 0, 400, 200);
        f.setVisible(true);
        JPanel jp1 = new JPanel(new GridLayout(7, 2,150,5));
        final Font f1 = new Font("宋体", Font.BOLD, 12);

        final JLabel label1 = new JLabel("Garden X:");
        label1.setFont(f1);
        JTextField textField1 = new JTextField();
        textField1.setVisible(true);
        jp1.add(label1);jp1.add(textField1);

        final JLabel label2 = new JLabel("Garden Y:");
        label2.setFont(f1);
        JTextField textField2 = new JTextField();
        textField2.setVisible(true);
        jp1.add(label2);jp1.add(textField2);

        final JLabel label3 = new JLabel("Garden width:");
        label2.setFont(f1);
        JTextField textField3 = new JTextField();
        textField3.setVisible(true);
        jp1.add(label3);jp1.add(textField3);
        final JLabel label4 = new JLabel("Garden heigth:");
        label2.setFont(f1);
        JTextField textField4 = new JTextField();
        textField4.setVisible(true);
        jp1.add(label4);jp1.add(textField4);

        final JLabel label5 = new JLabel("Design model 0/1:");
        label1.setFont(f1);
        JTextField textField5 = new JTextField();
        textField5.setVisible(true);
        jp1.add(label5);jp1.add(textField5);

        final JLabel label6 = new JLabel("flower style：");
        label1.setFont(f1);
        JTextField textField6 = new JTextField();
        textField5.setVisible(true);
        jp1.add(label6);jp1.add(textField6);

        final  JButton jb1= new JButton("Submit");
        jp1.add(jb1);

        f.add(jp1,BorderLayout.CENTER);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //为按钮创建监听器
                int color[];
                String s1 = textField1.getText();
                int x = Integer.parseInt(s1);
                String s2 = textField2.getText();
                int y = Integer.parseInt(s2);
                String s3 = textField3.getText();
                int width = Integer.parseInt(s3);
                String s4 = textField4.getText();
                int heigth = Integer.parseInt(s4);
                String s5 = textField5.getText();
                int model = Integer.parseInt(s5);
                String s6 = textField6.getText();
                int shuzu[];
                if (model==0){
                    shuzu=new int[12];
                    //表示横着设置颜色将其取出来转为数组
                    for(int i=0;i<(int)(heigth/20);i++)
                    {
                        char j=s6.charAt(i);
                        String str = String.valueOf(j);
                        shuzu[i]=Integer.parseInt(str);
                    }
                }
                else{
                    shuzu=new int[(int)(width/20)];
                    //表示横着设置颜色将其取出来转为数组
                    for(int i=0;i<(int)(width/20);i++)
                    {
                        char j=s6.charAt(i);
                        String str = String.valueOf(j);
                        shuzu[i]=Integer.parseInt(str);
                    }

                }
                if(x<0 || x>900){
                    addInfo("input 'x' is error");
                } else if(y<0||y>700){
                    addInfo("input 'y' is error");
                }else if(width<900 ||heigth<700){
                    //要判断是不是位置时空
                    if(width>900||heigth>700){
                        addInfo("garden not fit");
                    }else if((model==0 &&((int)(heigth/20)!=shuzu.length))||(model==1 &&((int)(width/20)!=shuzu.length))){
                        addInfo("garden design length not true");
                    }
                    else {
                        gardens[gardenNUm] = new Garden(x, y, width, heigth, model, shuzu);
                        gardenNUm += 1;
                        writeFile();
//                System.out.println(gardens[0]);
                        ADD();
                        //能获取表示没问题
                        f.dispose();
                    }
                }
                else {
                    addInfo("garden not fit");
                }
//                System.out.println(x);
//                System.out.println(y);
//                System.out.println(model);
//                System.out.println(shuzu[9]);
            }
        });



    }



}
