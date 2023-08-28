package com.wnxy.day15.file_demo;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;

public class MyApp {
    public static void main(String[] args) {
        demo04();
    }


    //写入多行,会清空文件中的所有内容
    //如果不希望清空，而是希望在文件最后追加新的内容，我们需要调用另一个构造函数
    public static void demo04() {
        ArrayList<String> items = new ArrayList<>();
        items.add("老六，注意你的背后");
        items.add("你屎淋到头了！");

        try (FileWriter fileWriter = new FileWriter("C:\\ziyuan\\resource\\B\\b.txt", true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String item : items) {
                bufferedWriter.write(item + "\n");
            }
            bufferedWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //缓冲流，逐行读取b.txt的内容
    public static void demo03() {
        //1.先创建字符流，根据字符流创建缓冲流
        try (FileReader fileReader = new FileReader("C:\\ziyuan\\resource\\B\\b.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //拷贝图片文件
    public static void demo2() {


        try (InputStream inputStream = new FileInputStream("C:\\ziyuan\\resource\\A\\1.gif");
             OutputStream outputStream = new FileOutputStream("C:\\ziyuan\\resource\\B\\残忍.png")) {
            byte[] wan = new byte[1024];
            int len;
            while ((len = inputStream.read(wan)) > 0) {
                outputStream.write(wan, 0, len);
            }
            outputStream.flush();
            System.out.println("拷贝成功了老六！");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SneakyThrows
    public static void demo01() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("C:/ziyuan/resource/a.txt");//创建文件输入流
            fileWriter = new FileWriter("C:/ziyuan/resource/b.txt");//创建文件输出流
            //文件流中读取内容，FileReader文件流中都是char字符
            char[] wan = new char[1024];
            int len = 0;
            while (true) {
                len = fileReader.read(wan);//len就是一次拿上来多少个字符，如果len<=0，
                // 说明已经把文件的全部内容都读完了
                if (len <= 0) {
                    break;
                }
                //如果len>0说明现在读到了len个字符，那么我们就将这些字符写到C:/ziyuan/resource/b.txt
                fileWriter.write(wan, 0, len);
            }
            //刷新输出流，确保内容写入到目标文件
            fileWriter.flush();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();

            }
        }
    }
}

