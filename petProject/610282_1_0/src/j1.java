////import javax.swing.*;
////import java.awt.*;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////
////public class mainWindow extends JFrame {
////    public Garden[] gardens = new Garden[12];
////    int gardenNUm=4;
////    public void init(){
////        int[] a={0,0,0,0,0,0,0,0,0,0};
////        int[] b={1,1,1,1,1,1,1,1,1,1};
////        int[] c={2,2,2,2,2,2,2,2,2,2};
////        int[] d={0,1,2,0,1,2,0,1,2,0,1,2};
////        gardens[0]= new Garden(100,100,0,a);
////        gardens[1]= new Garden(100,400,0,b);
////        gardens[2]= new Garden(400,100,0,c);
////        gardens[3]= new Garden(400,400,1,d);
////    }
////    JLabel jlab= new JLabel("园林管理系统",JLabel.CENTER);
////    JPanel jp1 = new JPanel(new GridLayout(6, 1,200,50));
////    JPanel jp = new JPanel();
////    public mainWindow() throws HeadlessException {
////
////        //word style
////        init();
////        final Font font = new Font("宋体", Font.BOLD, 32);
////        final Font font1 = new Font("宋体", Font.BOLD, 18);
////        final Font font2 = new Font("宋体", Font.BOLD, 15);
////        BorderLayout layout = new BorderLayout();
////        //this.setSize(1000,800);
//////    //流式布局
//////    this.setLayout(layout);
////        //最上边的标题
////        this.setLayout(null);
////        jlab.setSize(1000,100);
////        jlab.setFont(font);
////        //  中间的花坛
////        addGardenImage();
////
////        //现在写左边的菜单
////        JLabel lab = new JLabel("园林管理");
////        lab.setFont(font1);
////
////        JLabel lab1 = new JLabel("添加花圃：1");
////        lab1.setFont(font2);
////
////        JLabel lab2 = new JLabel("移除花圃：2");
////        lab2.setFont(font2);
////
////        JLabel lab21 = new JLabel("退出：3");
////        lab21.setFont(font2);
////
////        JLabel lab3 = new JLabel("选择：");
////
////        JTextField textField = new JTextField();
//////        //textField.setBounds(120, 20, 190, 22);
//////        textField.setSize(200,60);
//////        textField.setVisible(true);
////        jp1.add(lab);
////        //jp1.add(new JLabel(" "));
////        jp1.add(lab1);
////        jp1.add(lab2);
////        jp1.add(lab21);
////        jp1.add(lab3);
////        jp1.add(textField);
////        jp1.setSize(200,600);
////        jp1.setBackground(Color.GREEN);
////        //设置显示主窗口
////        //this.add( new JButton("花坛"),BorderLayout.CENTER);
////        jlab.setBounds(0,0,1000,100);
//////    this.add(jlab,BorderLayout.NORTH);
////        this.add(jlab);
////        jp1.setBounds(0,100,100,600);
////        this.add(jp1);
////        jp.setBounds(100,100,900,700);
////        this.add(jp);
//////    this.add(jp1,BorderLayout.WEST);
////        this.add(jp,BorderLayout.CENTER);
////        this.setSize(1000, 800);
////        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        this.setVisible(true);
////        textField.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                //textText
////                if(textField.getText().equals("1")){
////                    //添加花坛
////                    //addGarden();
////                    addGarden();
////                }
////                else if(textField.getText().equals("2")){
//////                addInfo("输入2");
////                    deleteGarden();
////                }
////                else if(textField.getText().equals("3")){
////                    addInfo("输入3");
////                }
////                else {
////                    //表示不是合理的输入
//////                final mainWindow myFrame = new mainWindow();
//////                myFrame.addInfo("输入错误");
////                    addInfo("输入错误");
////                }
////            }
////        });
////
////
////
////    }
////    //构造函数结束
////
////    public void addG(){
////
////    }
////
////
////    //删除花坛
////    public void deleteGarden(){
////        //删除花坛还删除花坛的保存文件
////        jp.removeAll();
////        repaint();
////        System.out.println("删除结束");
////    }
////    //添加错误信息 string为提示的错误信息类型
////    public void addInfo(final String string) {
////        final JFrame f = new JFrame("提示");
////        f.setLayout(null);
////        f.setBounds(1000, 200, 300, 100);
////        f.setVisible(true);
////        final JLabel label = new JLabel(string);
////        label.setBounds(30, 20, 250, 20);
////        final Font f1 = new Font("宋体", Font.BOLD, 12);
////        label.setFont(f1);
////        f.add(label);
//////        JTextField textField = new JTextField();
//////        textField.setBounds(120, 20, 190, 22);
//////        //textField.setSize(40,10);
//////        textField.setVisible(true);
//////        f.add(textField);
////
////    }
////
////    //添加花坛处理
//////    public boolean addGardenImage(int x,int y,int model,int shuzu[]){
////    public boolean addGardenImage(){
////        if(true){
//////            重新创建一个组件，然后将其加到中间去，
////            //读取文件信息，判断要写几个组件,还未写
////
////            //测试,写一个组件
////            ImageIcon img1 = new ImageIcon("IMAGE\\sunFlower.jpg");// 创建图片对象
////            ImageIcon img2 = new ImageIcon("IMAGE\\tea.jpg");// 创建图片对象
////            ImageIcon img3 = new ImageIcon("IMAGE\\rose.jpg");// 创建图片对象
////            jp.removeAll();
////            jp.setLayout(null);
////            JPanel jpp = new JPanel();
//////            JPanel[] jpp=new JPanel[12];
//////        for (int kk=0;kk<gardenNUm;kk++){
//////            System.out.print(kk);
//////            int x=gardens[kk].x;
//////            int y=gardens[kk].y;
//////            int model=gardens[kk].model;
//////            System.out.print(x);
//////            System.out.print(y);
//////            System.out.println(model);
//////            jpp[kk] = new JPanel();
//////            jpp[kk].setLayout(null);
//////            JLabel[] labels = new JLabel[120];
//////            jpp[kk].setBounds(0+x,0+y,240,200);
//////            int t=0;
//////            int[] shuzu= new int[12];
//////            for (int i = 0; i < labels.length; i++) {
//////                labels[i] = new JLabel();
//////                if(model==0) {
//////                        t=(int)(i/12);
//////                        for(int tt=0;tt<10;tt++) {
//////                            shuzu[tt] = gardens[kk].garden[tt];
//////                        }
//////                    }
//////                else{
//////                    t=(int)(i%12);
//////                    for(int tt=0;tt<12;tt++) {
//////                        shuzu[tt] = gardens[kk].garden[tt];
//////                    }
//////                }
//////                switch (shuzu[t]) {
//////                    case 0: labels[i].setIcon(img1);break;
//////                    case 1: labels[i].setIcon(img2);break;
//////                    case 2: labels[i].setIcon(img3);break;
//////                    default:labels[i].setIcon(img1);break;
//////                }
////////                labels[i].setSize(20, 20);
//////                labels[i].setBounds(20 * (int) (i / 12), 20 * (int) (i % 12), 20, 20);
//////                jpp[kk].add(labels[i]);
//////            }
//////
//////            }
//////            for(int i=0;i<gardenNUm;i++){
//////                jp.add(jpp[i]);
//////            }
//////            jp.revalidate();
//////            jp.repaint();
////            JLabel[] labels = new JLabel[120];
////            int model=0;
////            int t=0;
////            int x=100;
////            int y=100;
////            jpp.setBounds(0+x,0+y,240,200);
////            int[] shuzu= {0,1,2,1,2,1,2,1,2,1};
////            for (int i = 0; i < labels.length; i++) {
////                labels[i] = new JLabel();
////                if(model==0) {
////                    t=(int)(i/12);
////                    for(int tt=0;tt<10;tt++) {
////                        shuzu[tt] = shuzu[tt];
////                    }
////                }
////                else{
////                    t=(int)(i%12);
////                    for(int tt=0;tt<12;tt++) {
////                        shuzu[tt] = shuzu[tt];
////                    }
////                }
////                switch (shuzu[t]) {
////                    case 0: labels[i].setIcon(img1);break;
////                    case 1: labels[i].setIcon(img2);break;
////                    case 2: labels[i].setIcon(img3);break;
////                    default:labels[i].setIcon(img1);break;
////                }
////                labels[i].setSize(20, 20);
////                labels[i].setBounds(20 * (int) (i / 12), 20 * (int) (i % 12), 20, 20);
////                jpp.add(labels[i]);
////            }
////
////            jp.removeAll();
////            jpp.setBounds(100,100,240,200);
////            jp.add(jpp);
//////            jp.updateUI();
//////            jp.validate();
////            jp.revalidate();
////            jp.repaint();
////            System.out.println("添加花坛成功");
////
////
////        }
////        else {
////            return false;
////        }
////        return true;
////    }
////
////    public void addGarden(){
////        final JFrame f = new JFrame("添加花坛");
////        BorderLayout layout = new BorderLayout();
////        f.setLayout(layout);
////
////        f.setBounds(1000, 0, 400, 200);
////        f.setVisible(true);
////        JPanel jp1 = new JPanel(new GridLayout(5, 2,150,5));
////        final Font f1 = new Font("宋体", Font.BOLD, 12);
////
////        final JLabel label1 = new JLabel("位置 X:");
////        label1.setFont(f1);
////        JTextField textField1 = new JTextField();
////        textField1.setVisible(true);
////        jp1.add(label1);jp1.add(textField1);
////
////        final JLabel label2 = new JLabel("位置 Y:");
////        label2.setFont(f1);
////        JTextField textField2 = new JTextField();
////        textField2.setVisible(true);
////        jp1.add(label2);jp1.add(textField2);
////
////
////        final JLabel label5 = new JLabel("花坛样式 横0/竖1:");
////        label1.setFont(f1);
////        JTextField textField5 = new JTextField();
////        textField5.setVisible(true);
////        jp1.add(label5);jp1.add(textField5);
////
////        final JLabel label6 = new JLabel("花色横10竖12：");
////        label1.setFont(f1);
////        JTextField textField6 = new JTextField();
////        textField5.setVisible(true);
////        jp1.add(label6);jp1.add(textField6);
////
////        final  JButton jb1= new JButton("确定");
////        jp1.add(jb1);
////
////        f.add(jp1,BorderLayout.CENTER);
////        jb1.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                //为按钮创建监听器
////                int color[];
////                String s1 = textField1.getText();
////                int x = Integer.parseInt(s1);
////                String s2 = textField2.getText();
////                int y = Integer.parseInt(s2);
////                String s5 = textField5.getText();
////                int model = Integer.parseInt(s5);
////                String s6 = textField6.getText();
////                int shuzu[];
////                if (model==0){
////                    shuzu=new int[10];
////                    //表示横着设置颜色将其取出来转为数组
////                    for(int i=0;i<10;i++)
////                    {
////                        char j=s6.charAt(i);
////                        String str = String.valueOf(j);
////                        shuzu[i]=Integer.parseInt(str);
////                    }
////                }
////                else{
////                    shuzu=new int[12];
////                    //表示横着设置颜色将其取出来转为数组
////                    for(int i=0;i<12;i++)
////                    {
////                        char j=s6.charAt(i);
////                        String str = String.valueOf(j);
////                        shuzu[i]=Integer.parseInt(str);
////                    }
////
////                }
//////                System.out.println(x);
//////                System.out.println(y);
//////                System.out.println(model);
//////                System.out.println(shuzu[9]);
////                gardens[gardenNUm]=new Garden(x,y,model,shuzu);
////                addGardenImage();
////                //能获取表示没问题
////                f.dispose();
////            }
////        });
////
////        //检查并获取几个文本框的内容，然后返回文本框的内容
//////        textField1.addActionListener(new ActionListener() {
//////            @Override
//////            public void actionPerformed(ActionEvent e) {
//////                try {
//////                    String s = textField1.getText();
//////                    int width = Integer.parseInt(s);
//////                    if(200<width && width<1000){
//////                    }
//////                    else {
//////                        final mainWindow myFrame = new mainWindow();
//////                        myFrame.addGarden();
//////                        myFrame.addInfo("输入的不是数字，请重新输入");
//////                    }
//////                }catch (ClassCastException e1){
//////                    //输入的不是数字
//////                    final mainWindow myFrame = new mainWindow();
//////                    myFrame.addGarden();
//////                    myFrame.addInfo("输入的不是数字，请重新输入");
//////                    throw e1;
//////                }
//////            }
//////        });
////
////    }
////
////
////
////}
//
//
////if(true){
//////            System.out.print(x);
//////            System.out.print(y);
//////            System.out.println(model);
////        JPanel jpp = new JPanel();
////        jpp.setLayout(null);
////        JLabel[] labels = new JLabel[120];
////        jp.removeAll();
////        jpp.setBounds(0+100,0+100,240,200);
//////            int t=0;
////        for (int i = 0; i < labels.length; i++) {
////        labels[i] = new JLabel();
////        labels[i].setIcon(img1);
////        labels[i].setSize(20,20);
////        labels[i].setBounds(20 * (int) (i %12), 20 * (int) (i /12), 20, 20);
////        jpp.add(labels[i]);
////        }
//////            jp.removeAll();
//////            jp.repaint();
//////            jp.setLayout(null);
////        jp.add(jpp);
////        jp.revalidate();
////        jp.repaint();
////        System.out.print("succefful");
////        }
//0,0,0,0,0,0,0,0,0,0};
//        int[] b={1,1,1,1,1,1,1,1,1,1};
//        int[] c={2,2,2,2,2,2,2,2,2,2};
//        int[] d={0,1,2,0,1,2,0,1,2,0,1,2
//100,100,0,0000000000
//100,400,0,1111111111
//500,100,0,2222222222
//500,400,1,120120120120