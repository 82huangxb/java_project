package org.example.inputAndOutput;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author huangxb
 * @date 2023/6/21 15:41
 * @apiNote
 */
public class FileDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test(){
        File file = new File("D:\\"+File.separator+"x"+File.separator+"y"+File.separator+"test.txt");
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream;
        try {
            inputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[1024];
            int read;
            while((read = bufferedInputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,read));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void test1(){
        File file = new File("D:\\"+File.separator+"x"+File.separator+"y"+File.separator+"test.txt");
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            outputStream = new FileOutputStream(file,true);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            String s = "安吉拉法兰多发了";
            bufferedOutputStream.write("\\n".getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.write(s.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                outputStream.flush();
                bufferedOutputStream.flush();
                outputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
