package com.library.bookseller.balance;


import com.library.bookseller.model.ResponseType;
import com.library.bookseller.service.Services;

public interface BalanceService  extends Services {

    BalanceDAO getAmount(long id);
    ResponseType save (BalanceDto balanceDto);

}
