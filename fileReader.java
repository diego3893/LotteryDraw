package com.lotteryDraw;
import java.io.*;
import java.util.*;

public class fileReader {
    File file;
    public Map<Integer, String> stu = new HashMap<>();
    int Index = 0;

    fileReader(String filePath){
        file = new File(filePath); // 创建File类对象
    }

    public void showPath(){
        File directory = new File("");//设定为当前文件夹

        try{
            System.out.println(directory.getCanonicalPath());//获取标准的路径

            System.out.println(directory.getAbsolutePath());//获取绝对路径

        }catch(Exception e){}
    }

    int getWordCount(String s)
    {
        s = s.replaceAll("[^\\x00-\\xff]", "**");
        int length = s.length();
        return length;
    }

    public void getInfo(){


        FileInputStream fis = null; // 创建FileInputStream类对象读取File

        InputStreamReader isr = null; // 创建InputStreamReader对象接收文件流

        BufferedReader br = null; // 创建reader缓冲区将文件流装进去

        try {
            br = new BufferedReader(new FileReader(file));

            String lineTxt = null;

            while ((lineTxt = br.readLine()) != null) {
                //System.out.println(lineTxt); // 逐行输出文件内容
                stu.put(++Index, lineTxt);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            if (br != null) {
                try {
                    br.close();

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

            if (isr != null) {
                try {
                    isr.close();

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

            if (fis != null) {
                try {
                    fis.close();

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        }

    }
}
