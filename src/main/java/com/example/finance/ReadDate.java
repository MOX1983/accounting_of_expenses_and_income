package com.example.finance;

import java.io.*;
import java.util.ArrayList;

import static com.example.finance.SumC.sumCategor;

public class ReadDate {

    public static ArrayList<Categor> readDateCSV(String filePath){
        ArrayList<Categor> date = null;
        try{
            FileReader file = new FileReader(filePath);
            BufferedReader bufferIn = new BufferedReader(file);

            date = new ArrayList<>();

            String line;
            while((line = bufferIn.readLine()) != null){
                String[] l = line.split(",");
                date.add(new Categor(l[0], Double.parseDouble(l[1])));
            }
            bufferIn.close();
        }
        catch (IOException e){
            System.out.println("Ошибка чтения");
            e.printStackTrace();
        }
        return sumCategor(date);
    }

}
