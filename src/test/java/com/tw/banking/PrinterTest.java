package com.tw.banking;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class PrinterTest {

    @Test
    void should_return_a_copy_of_transactions_when_invoke_printStatementLines() {
        Console console = mock(Console.class);
        Printer printer = new Printer(console);

        List<Transaction> transactions = getShuffleTransactions();

        printer.print(transactions);

        verify(console, times(4)).printLine(anyString());
    }

    private List<Transaction> getShuffleTransactions() {
        Transaction firstTransaction = new Transaction("1/1/2021", 1000);
        Transaction secondTransaction = new Transaction("1/1/2021", -500);
        Transaction thirdTransaction = new Transaction("1/1/2021", 200);
        List<Transaction> transactions = Arrays.asList(firstTransaction, secondTransaction, thirdTransaction);
        Collections.shuffle(transactions);
        return transactions;
    }
}