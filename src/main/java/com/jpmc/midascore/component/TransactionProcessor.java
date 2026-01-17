package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.*;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.*;
import org.springframework.stereotype.Component;

@Component
public class TransactionProcessor {

    private final AccountRepository accountRepo;
    private final TransactionRecordRepository txRepo;

    public TransactionProcessor(AccountRepository accountRepo,
                                TransactionRecordRepository txRepo) {
        this.accountRepo = accountRepo;
        this.txRepo = txRepo;
    }

    public void process(Transaction tx) {

        Account sender =
            accountRepo.findById((int) tx.getSenderId()).orElse(null);

        Account recipient =
            accountRepo.findById((int) tx.getRecipientId()).orElse(null);

        if (sender == null || recipient == null) return;
        if (sender.getBalance() < tx.getAmount()) return;

        sender.setBalance(sender.getBalance() - tx.getAmount());
        recipient.setBalance(recipient.getBalance() + tx.getAmount());
        
        accountRepo.save(sender);
        accountRepo.save(recipient);

        txRepo.save(
            new TransactionRecord(
                (int) tx.getSenderId(),
                (int) tx.getRecipientId(),
                tx.getAmount()
            )
        );

    }
}