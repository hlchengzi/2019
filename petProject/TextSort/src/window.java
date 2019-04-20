import com.sun.xml.internal.ws.handler.HandlerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class window extends JFrame {
    public window() throws HandlerException {
        final Font font1 = new Font("宋体", Font.BOLD, 22);
        final Font font2 = new Font("宋体", Font.BOLD, 18);
        JLabel jb = new JLabel("miRNA长度：");
        jb.setFont(font1);
        JPanel jp = new JPanel();
        jp.setFont(font2);
        this.setLayout(null);
        this.setSize(200,100);
        jb.setSize(200,100);
        jb.setBounds(0,0,200,100);

        jp.setSize(200,100);
        jp.setBounds(0,100,400,200);

        JButton jb1 = new JButton("20NT");
        JButton jb2 = new JButton("21NT");
        JButton jb3 = new JButton("22NT");
        JButton jb4 = new JButton("23NT");
        JButton jb5 = new JButton("24NT");
        jb1.setBounds(0,300,10050,30);
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb5);

        this.add(jb);
        this.add(jp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src\\save20.txt");
                if((!file.exists()) || file.length()==0) {
                    readFile("src\\SLY_only_sort.txt", 20);
                    readFile("src\\NTA_only_sort.txt", 20);
                }
                else {
                    addInfo("文件已好");
                }


            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src\\save21.txt");
                if((!file.exists()) || file.length()==0) {
                    readFile("src\\SLY_only_sort.txt", 21);
                    readFile("src\\NTA_only_sort.txt", 21);
                }
                else {
                    addInfo("文件已好");
                }
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src\\save22.txt");
                if((!file.exists()) || file.length()==0) {
                    readFile("src\\SLY_only_sort.txt", 22);
                    readFile("src\\NTA_only_sort.txt", 22);
                }
                else {
                    addInfo("文件已好");
                }
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src\\save23.txt");
                if((!file.exists()) || file.length()==0) {
                    readFile("src\\SLY_only_sort.txt", 23);
                    readFile("src\\NTA_only_sort.txt", 23);
                }
                else {
                    addInfo("文件已好");
                }
            }
        });
        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src\\save24.txt");
                if((!file.exists()) || file.length()==0) {
                    readFile("src\\SLY_only_sort.txt", 24);
                    readFile("src\\NTA_only_sort.txt", 24);
                }
                else {
                    addInfo("文件已好");
                }
            }
        });
    }
    public  void readFile(String filename, int num) {
        try {
            String file = filename;
            String str=null;
            str = new String();
            int countNUm=0;
            FileReader fr = new FileReader(file);
            BufferedReader bre = new BufferedReader(fr);//此时获取到的bre就是整个文件的缓存流
            while ((str = bre.readLine()) != null) // 判断最后一行不存在，为空结束循环
            {
                String str1= replaceBlank(str);
                String[] s =str1.split("::");
                String information = s[1];
                int startNumm = 10;
                if(Character.isDigit(information.charAt(9))) {
                    startNumm=9;
                }
                char j10=information.charAt(startNumm);
                String str10 = String.valueOf(j10);
                char j11=information.charAt(startNumm+=1);
                String str11 = String.valueOf(j11);
                int thisNum = Integer.parseInt(str10)*10+Integer.parseInt(str11);

                if(thisNum == num){
//                    System.out.println(thisNum);
                    String out = "src\\save"+String.valueOf(thisNum)+".txt";
                    writeFile(out,str);
                    countNUm+=1;
                }
            }
            System.out.print("总数");
            System.out.println(countNUm);
            bre.close();
            fr.close();
        }catch (Exception e){

        }

    }
    public  String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s+|\t|\\.+");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("::");
        }
        return dest;
    }
    public void writeFile(String filename,String buf){
        //写之前进行删除
        try{
//        File file = new File("src\\gardenText.txt");
            BufferedWriter bw= new BufferedWriter(new FileWriter(new File(filename),true));
                bw.write(buf);
                bw.newLine();
            bw.flush();
            bw.close();
        }
        catch (Exception e){

        }
    }
    public void addInfo(final String string) {
        final JFrame f = new JFrame("提示");
        f.setLayout(null);
        f.setBounds(400, 100, 200, 100);
        f.setVisible(true);
        final JLabel label = new JLabel(string);
        label.setBounds(30, 20, 250, 20);
        final Font f1 = new Font("宋体", Font.BOLD, 12);
        label.setFont(f1);
        f.add(label);


    }
}
