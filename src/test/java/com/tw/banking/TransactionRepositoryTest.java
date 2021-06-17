package com.tw.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import org.junit.jupiter.api.Test;

class TransactionRepositoryTest {

    @Test
    void should_return_transaction_with_same_amount_when_invoke_addDeposit() {
        //given
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        int mockedAmount = 100;
        String string = "string";
        when(clock.todayAsString()).thenReturn(string);
        //when
        transactionRepository.addDeposit(mockedAmount);
        //then
        List<Transaction> result = transactionRepository.transactions;
        assertSame(1, result.size());
        assertEquals(string, result.get(0).date());
        assertEquals(mockedAmount, result.get(0).amount());
    }

    @Test
    void should_return_transaction_with_negative_amount_when_invoke_addWithdraw() {
        //given
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        int mockedAmount = 100;
        String string = "string";
        when(clock.todayAsString()).thenReturn(string);
        //when
        transactionRepository.addWithdraw(mockedAmount);
        //then
        List<Transaction> result = transactionRepository.transactions;
        assertSame(1, result.size());
        assertEquals(string, result.get(0).date());
        assertEquals(-1 * mockedAmount, result.get(0).amount());
    }

}