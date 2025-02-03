package com.example.finance;

public class Categor {
    private String name;
    private Double money;

    Categor(String name, Double money){
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money += money;
    }

    @Override
    public String toString() {
        return name + "," + money;
    }

}
