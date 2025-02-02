package com.example.finance;

import java.io.*;
import java.util.ArrayList;

public class ReadDate {

    public static ArrayList<String> readDateCSV(String filePath){
        ArrayList<String> date = null;
        try{
            FileReader file = new FileReader(filePath);
            BufferedReader bufferIn = new BufferedReader(file);

            date = new ArrayList<>();

            String line;
            while((line = bufferIn.readLine()) != null){
                date.add(line);
            }
            bufferIn.close();
        }
        catch (IOException e){
            System.out.println("Ошибка чтения");
            e.printStackTrace();
        }
        return date;
    }

}
