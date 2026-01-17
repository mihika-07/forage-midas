package com.jpmc.midascore.entity;

import jakarta.persistence.*;

@Entity
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int senderId;
    private int recipientId;
    private double amount;

    public TransactionRecord() {}

    public TransactionRecord(int senderId, int recipientId, double amount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
    }

    public int getSenderId() {
    return senderId;
}

public int getRecipientId() {
    return recipientId;
}

public double getAmount() {
    return amount;
}

}