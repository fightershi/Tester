package com.zte.shi.Lucene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by SHI_ZX on 2016/11/14.
 */
public class RetrivePage {
    public static void main(String[] args) throws IOException {
       /* InetAddress remAdd;
        remAdd = InetAddress.getByName("http://www.baidu.com" );
        System.out.println(remAdd);*/
        System.out.println(RetrivePage.downloadPage("http://10.62.61.104:8080/").length());
    }

    private static String downloadPage(String path) throws IOException {
        URL pageURL = new URL(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pageURL.openStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line=bufferedReader.readLine())!=null){
            stringBuilder.append("\n").append(line);
        }
        return stringBuilder.toString();
    }
}
