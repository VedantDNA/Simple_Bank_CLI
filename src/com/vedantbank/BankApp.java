package com.vedantbank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        // instantiating Scanner:
        Scanner sc = new Scanner(System.in);

        // create Bank Account:
        String accountHolder;
        double accountBalance = 0;
        System.out.println("----- Banking CLI App -----");

        System.out.print("Enter Account Holder's Name: ");
        accountHolder = sc.nextLine().trim();

        boolean flag = false;
        while (!flag){
            try {
                System.out.print("Enter Initial Account Balance: ");
                accountBalance = sc.nextDouble();
                sc.nextLine();
                flag = true;
            }catch (InputMismatchException e){
                System.out.println("Invalid Input: Balance should be a number !!!");
                sc.nextLine();
            }
        }

        // creating Bank Account by instantiating Account class using a static factory method:
        Account account = Account.create(accountHolder,accountBalance);


        int choice = 0;
        do{
            System.out.println("----- Banking CLI App -----");
            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Get Amount");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Invalid Input: Please Enter an Integer !!");
                sc.nextLine();
            }

            switch (choice){
                case 1 -> {
                    System.out.print("Please Enter Amount: ");
                    double amount = sc.nextDouble();
                    // consume line:
                    sc.nextLine();
                    account.depositMoney(amount);
                }
                case 2 -> {
                    System.out.print("Please Enter Withdrawal Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    account.withdraw(amount);
                }
                case 3 -> {
                    double currentBalance = account.getBalance();
                    System.out.println("Current Balance: " + currentBalance);
                }
                case 4 -> {
                    System.out.println("Thanks for using Bank CLI App !!!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid Input");
                }
            }
        }while (choice != 4);
    }
}
