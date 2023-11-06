package com.wanandaodao.zoo;

public class InsufficientBalanceException extends RuntimeException{
    public double balance;

    public InsufficientBalanceException(double  balance) {
        this.balance = balance;
    }

    public void printError(){
        System.out.println("余额不足，您当前的余额为: "+balance);
    }
}
