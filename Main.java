package com.lotteryDraw;

public class Main{
    public static void main(String[] args) {
        //PrizeDraw pw = new PrizeDraw();
        fileReader filereader = new fileReader("./out/production/lotteryDraw/data.in");
        filereader.getInfo();
        PrizeDraw prizedraw = new PrizeDraw(filereader);
    }
}