package org.example.readerAndWriter;

import java.io.*;

/**
 * @author huangxb
 * @date 2023/7/7 14:13
 * @apiNote
 */
public class ReaderDemo {
    public static void main(String[] args) {
        test();
    }

    public static void  test(){
        File file = new File("D:\\"+File.separator+"x"+File.separator+"y"+File.separator+"test.txt");
        File file1 = new File("D:\\"+File.separator+"x"+File.separator+"z"+File.separator+"test.txt");

        Reader reader = null;
        BufferedReader bufferedReader = null;
        Writer writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            if(!file1.getParentFile().exists()){
                file1.getParentFile().mkdirs();
                if(file1.exists()){
                    file1.createNewFile();
                }
            }
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            writer = new FileWriter(file1);
            bufferedWriter = new BufferedWriter(writer);
            int read =0;
            //char[] chars =new char[1024];
            long a =System.currentTimeMillis();
            System.out.println(a);
            while((read = bufferedReader.read())!=-1){
                bufferedWriter.write(read);
            }
            /*while((read = reader.read())!=-1){
                writer.write(read);
            }*/
            System.out.println(System.currentTimeMillis()-a);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                writer.flush();
                bufferedWriter.flush();
                bufferedWriter.close();

                writer.close();
                bufferedReader.close();
                reader.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



    }

}
