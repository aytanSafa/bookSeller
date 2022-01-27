package com.library.bookseller.balance;


import com.library.bookseller.model.ResponseType;
import com.library.bookseller.service.Services;

public interface BalanceService  extends Services {

    BalanceDto getAmount(long id);
    BalanceDto getAmountByUserId();
    BalanceDto update(BalanceDto balanceDto);
    ResponseType save (BalanceDto balanceDto);


}
