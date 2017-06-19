package com.zlikun.jee;

import org.junit.Test;

import java.io.*;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/19 10:23
 */
public class DecoratorInJdkTest {

    @Test
    public void test() throws IOException {

        // 文件输入流
        FileInputStream fis = new FileInputStream("./src/test/java/com/zlikun/jee/DecoratorInJdkTest.java") ;

        // 使用缓冲输入流装饰文件输入流
        BufferedInputStream bis = new BufferedInputStream(fis) ;

        // 使用数据输入流装饰缓冲输入流
        DataInputStream dis = new DataInputStream(bis) ;

        byte [] data = new byte[dis.available()] ;
        dis.read(data) ;

        dis.close();
//        bis.close();
//        fis.close();

        System.out.println(new String (data));

    }

}
