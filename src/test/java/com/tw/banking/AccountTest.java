package com.tw.banking;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

}