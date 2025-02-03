package com.example.finance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.finance.ReadDate.readDateCSV;
import static com.example.finance.SumC.sumCategor;

public class WriteDate {

    public static void writeDateCSV(String filePath, Categor categor){
        try{
            ArrayList<Categor> date = readDateCSV(filePath);
            FileWriter file = new FileWriter(filePath);
            BufferedWriter bufferIn = new BufferedWriter(file);
            date.add(categor);
            date = sumCategor(date);

            for(Categor s : date){
                bufferIn.write(s.toString());
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
