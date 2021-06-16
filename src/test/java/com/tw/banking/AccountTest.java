package com.tw.banking;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AccountTest {

    @Test
    public void should_call_transactionRepository_when_deposit(){

        // given
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        TransactionRepository spyTransactionRepository = Mockito.spy(transactionRepository);
        Account account = new Account(spyTransactionRepository,new Printer(new Console()));
        int amount = 10;
        // when
        account.deposit(amount);
        // then
        verify(spyTransactionRepository).addDeposit(amount);
    }

    @Test
    public void should_call_addWithdraw_when_withdraw(){

        // given
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        TransactionRepository spyTransactionRepository = Mockito.spy(transactionRepository);
        Account account = new Account(spyTransactionRepository,new Printer(new Console()));
        int amount = 10;
        // when
        account.withdraw(amount);
        // then
        verify(spyTransactionRepository).addWithdraw(amount);
    }

    @Test
    public void should_call_addWithdraw_when_printStatement(){

        // given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);

        Printer printer = mock(Printer.class);

        Account account = new Account(transactionRepository,printer);

        List<Transaction> transactions = Collections.singletonList(new Transaction("date", 10));
        // when
        when(transactionRepository.allTransactions()).thenReturn(transactions);
        account.printStatement();

        // then
//        verify(spyTransactionRepository).allTransactions();
        verify(printer).print(transactions);
    }
}