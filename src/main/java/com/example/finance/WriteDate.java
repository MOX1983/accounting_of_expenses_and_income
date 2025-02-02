package com.example.finance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.finance.ReadDate.readDateCSV;

public class WriteDate {

    public static void writeDateCSV(String filePath, String categoryExpenses, String money){
        try{
            ArrayList<String> date = readDateCSV(filePath);
            FileWriter file = new FileWriter(filePath);
            BufferedWriter bufferIn = new BufferedWriter(file);
            String str = categoryExpenses + "," + money;
            date.add(str);

            for(String s : date){
                bufferIn.write(s);
                bufferIn.newLine();
            }

            bufferIn.close();
        }
        catch (IOException e){
            System.out.println("Ошибка чтения");
            e.printStackTrace();
        }
    }
}
