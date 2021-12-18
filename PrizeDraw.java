package com.lotteryDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PrizeDraw implements ActionListener{

    JTextField randomNum1;//全局变量，随机数1
    JTextField randomNum2;//全局变量，随机数2

    JButton prizedraw;//抽奖按钮
    fileReader filereader;

    int num;

    PrizeDraw(fileReader filereader){
        this.filereader = filereader;
        Font font = new Font("宋体",Font.PLAIN,15);//字体
        JFrame frame = new JFrame("随机点杀");//创建窗口
        JPanel p1 = new JPanel();//创建面板1
        JPanel p2 = new JPanel();//创建面板2
        JPanel p3 = new JPanel();
        JLabel label1 = new JLabel("学号:");//标签1
        label1.setFont(font);
        label1.setForeground(Color.blue);//设置按钮颜色
        randomNum1 = new JTextField(10);//输入框
        JLabel label2 = new JLabel("姓名:");
        label2.setFont(font);
        label2.setForeground(Color.blue);//设置按钮颜色
        randomNum2 = new JTextField(10);
        JLabel label3 = new JLabel("MADE BY Diego");
        label3.setFont(font);
        label3.setForeground(Color.black);
        JLabel label4 = new JLabel("View src at https://github.com/diego3893/LotteryDraw");
        prizedraw = new JButton("随机抽取一名幸运观众");//查询按钮
        prizedraw.setFont(font);
        prizedraw.setForeground(Color.blue);
        prizedraw.addActionListener(this);
        //将组件添加到面板1
        p1.add(label1);
        p1.add(randomNum1);
        p1.add(label2);
        p1.add(randomNum2);
        p1.add(prizedraw);
        //p1.add(label3);
        JTextArea getArea = new JTextArea(20,45);//多行文本输入框
        getArea.setEditable(false);//设置多行文本输入框属性为只读
        p2.add(getArea);
        p3.add(label3);
        p3.add(label4);
        frame.add("North",p1);
        frame.add("Center",p2);
        frame.add("South",p3);
        frame.setBackground(Color.lightGray);//设置背景颜色
        frame.setResizable(false);//设置窗口不可以改变大小
        frame.setVisible(true);//设置可视性
        frame.pack();//自动调整窗口大小
        frame.setSize(510,400);;//设置窗口大小
    }
    public void actionPerformed(ActionEvent e){
        Random rom = new Random();
        if(e.getSource() == prizedraw){
            num = rom.nextInt(42)+1;
            randomNum1.setText(num+"");
            randomNum2.setText(filereader.stu.get(num));
        }
    }
}