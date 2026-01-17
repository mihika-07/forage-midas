package com.jpmc.midascore.entity;

import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    private int userId;

    private double balance;

    public Account() {}

    public Account(int userId, double balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}