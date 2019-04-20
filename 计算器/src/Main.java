
import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.StringTokenizer;



import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JTextField;



public class Main extends JFrame{

    JPanel panel;

    JTextField text;

    JButton jb0,jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;	//0~9四个数字（可写成数组）

    JButton bot,add,sub,mul,div,equ;	//加减乘除以及小数点五个符号

    public Main(){

        this.setBounds(300, 200, 400, 300);	//窗体大小

        this.setTitle("计算器");	//窗体名称

        this.setLayout(new BorderLayout());	//设置计算机窗体的布局方式



        text = new JTextField(15);		//计算区域



        //新建数字按钮

        jb0 = new JButton("0");

        jb1 = new JButton("1");

        jb2 = new JButton("2");

        jb3 = new JButton("3");

        jb4 = new JButton("4");

        jb5 = new JButton("5");

        jb6 = new JButton("6");

        jb7 = new JButton("7");

        jb8 = new JButton("8");

        jb9 = new JButton("9");



        //新建符号按钮

        bot = new JButton(".");

        add = new JButton("+");

        sub = new JButton("-");

        mul = new JButton("*");

        div = new JButton("/");

        equ = new JButton("=");



        //新建计算器数字及符号所在区域面板

        panel = new JPanel();

        panel.setLayout(new GridLayout(4,4));	//设置面板的布局方式



        //将各按钮组件放入面板（panel）中

        //第一行

        panel.add(jb7);

        panel.add(jb8);

        panel.add(jb9);

        panel.add(div);

        //第二行

        panel.add(jb4);

        panel.add(jb5);

        panel.add(jb6);

        panel.add(mul);

        //第三行

        panel.add(jb1);

        panel.add(jb2);

        panel.add(jb3);

        panel.add(sub);

        //第四行

        panel.add(bot);

        panel.add(jb0);

        panel.add(equ);

        panel.add(add);





        this.add(text,BorderLayout.NORTH);

        this.add(panel);



        MyEvent();	//事件处理



        this.setVisible(true);	//设置窗体显示

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置窗体可关闭

    }



    public void MyEvent(){

		/*将以下内容封装到Text方法中

		 * jb0.addActionListener(new ActionListener(){



			@Override

			public void actionPerformed(ActionEvent arg0) {

				// TODO Auto-generated method stub

//				text.setText("0");

				String str = jb0.getText();

				System.out.println(str);

			}



		});*/

        //为各按钮添加事件处理

        Text(jb0);

        Text(jb1);

        Text(jb2);

        Text(jb3);

        Text(jb4);

        Text(jb5);

        Text(jb6);

        Text(jb7);

        Text(jb8);

        Text(jb9);

        Text(bot);

        Text(add);

        Text(sub);

        Text(mul);

        Text(div);



        //“=”按钮的事件处理

        equ.addActionListener(new ActionListener(){



            @Override

            public void actionPerformed(ActionEvent e) {

                // TODO Auto-generated method stub



                text.setText(text.getText()+equ.getText());



                if(text.getText().contains("+")){//做加法运算

//					String[] str1 = text.getText().split("+");		//错误语句

                    StringTokenizer st1 = new StringTokenizer(text.getText(),"+");

//					System.out.println("str1======"+st1.nextToken());

                    double d1,d2 = 0;

                    d1 = Double.parseDouble(st1.nextToken());

                    while(st1.hasMoreTokens()){

                        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"=");

//						System.out.println("str2======"+st2.nextToken());

                        d2 = Double.parseDouble(st2.nextToken());

                    }



                    text.setText(text.getText()+" "+(d1+d2));

                }else if(text.getText().contains("-")){//做减法运算

                    StringTokenizer st1 = new StringTokenizer(text.getText(),"-");

                    double d1,d2 = 0;

                    d1 = Double.parseDouble(st1.nextToken());

                    while(st1.hasMoreTokens()){

                        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"=");

                        d2 = Double.parseDouble(st2.nextToken());

                    }



                    text.setText(text.getText()+" "+(d1-d2));

                }else if(text.getText().contains("*")){//做乘法运算

                    StringTokenizer st1 = new StringTokenizer(text.getText(),"*");

                    double d1,d2 = 0;

                    d1 = Double.parseDouble(st1.nextToken());

                    while(st1.hasMoreTokens()){

                        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"=");

                        d2 = Double.parseDouble(st2.nextToken());

                    }



                    text.setText(text.getText()+" "+(d1*d2));

                }else if(text.getText().contains("/")){//做除法运算

                    StringTokenizer st1 = new StringTokenizer(text.getText(),"/");

                    double d1,d2 = 0;

                    d1 = Double.parseDouble(st1.nextToken());

                    while(st1.hasMoreTokens()){

                        StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"=");

                        d2 = Double.parseDouble(st2.nextToken());

                    }



                    text.setText(text.getText()+" "+(d1/d2));	//将运算结果放到text区域

                }

            }



        });

    }



    //各按钮的事件处理方法

    public void Text(JButton button){

        button.addActionListener(new ActionListener(){



            @Override

            public void actionPerformed(ActionEvent arg0) {

                // TODO Auto-generated method stub

//				text.setText("0");

                String str = button.getText();

//				System.out.println(str);

                text.setText(text.getText()+str);

            }



        });

//		return button.getText();

    }



    //主函数

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        new Main();

    }



}
