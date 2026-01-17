package com.jpmc.midascore;

import com.jpmc.midascore.component.TransactionProcessor;
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    private final TransactionProcessor processor;

    public TransactionListener(TransactionProcessor processor) {
        this.processor = processor;
    }

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core-group")
    public void listen(Transaction transaction) {
        processor.process(transaction);
    }
}
