package com.vedantbank;

public class Account {
    private String name;
    private double balance = 0;

    // constructor with only name:
    private Account(String name){
        this.setName(name);
    }

    // constructor with both name and balance:
    private Account(String name,double balance){
        this.setName(name);
        this.setBalance(balance);
    }

    // getters and setters for private fields with validation:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isBlank()){
            this.name = name;
        }else {
            System.out.println("Warning: Name blank");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 0){
        this.balance = balance;
        }else {
            System.out.println("Warning: Cannot have Negative Balance !!!");
        }
    }


    // factory method for account creation:
    public static Account create(String name, double balance){
        return new Account(name,balance);
    }

    // Money deposit method:
    public void depositMoney(double deposit){
        if(deposit > 0){
            this.balance += deposit;
            System.out.println("Deposit Successfull !!");
            System.out.printf("Deposit Amount: ₹%.2f Current Balance: ₹%.2f%n", deposit, this.getBalance());
        }else {
            System.out.println("Warning: Invalid Deposit Amount !!!");
        }
    }

    // Money Withdrawal method:
    public void withdraw(double amount){
        if(amount > 0 && amount <= this.getBalance()){
            this.balance -= amount;
            System.out.println("Withdrawal Successfull !!");
            System.out.println("Amount withdrawn: " + amount + " Current balance: " + this.getBalance());
            return;
        }
        System.out.println("Error: Withdrawal Failed !!!");
    }
}
