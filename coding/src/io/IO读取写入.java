package io;

import java.io.*;

/**
 * @Author: ly
 * @Date: 2020/7/22 22:01
 * @Version 1.0
 */
public class IO读取写入 {
    private void readFile(String path){
        try(FileReader reader=new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
        ){
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void writeFile(String path){
        try{
            File writeName = new File("path");
            writeName.createNewFile();
            try(FileWriter writer = new FileWriter(writeName);
                BufferedWriter out = new BufferedWriter(writer);
            ){
                out.write("hello\r\n"); // \r\n为换行
                out.flush(); // 刷写缓冲
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
