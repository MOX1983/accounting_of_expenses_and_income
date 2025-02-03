package com.example.finance;

import java.util.ArrayList;

public class SumC {
    public static ArrayList<Categor> sumCategor(ArrayList<Categor> arr){
        ArrayList<Categor> newArr = new ArrayList<>(arr);
        for(int i = 0; i < newArr.size(); i++){
            for(Categor j : arr){
                if(newArr.get(i).getName().equals(j.getName()) && newArr.get(i) != j){
                    newArr.get(i).setMoney(j.getMoney());
                    newArr.remove(j);
                }
            }
        }
        return newArr;
    }
}
