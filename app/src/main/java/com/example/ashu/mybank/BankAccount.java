package com.example.ashu.mybank;

/**
 * Created by Ashu on 08/04/15.
 */
public class BankAccount {

    private double balance;
    private static double overdraftfee = 30;



    public void withdraw(double amount){

        balance -= amount;

        if(balance < 0 ){
            balance -= overdraftfee;
        }
    }

    public void deposit(double amount){

        balance += amount;

    }

    public double getBalance(){
        return balance;
    }

}

