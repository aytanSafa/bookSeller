package com.library.bookseller.balance;

import com.library.bookseller.exceptions.generic.BalanceServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService{

    private final BalanceRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public BalanceServiceImpl(BalanceRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }



    @Override
    public BalanceDto update(BalanceDto balanceDto) {
        BalanceDAO balanceDAO =repository.findBalanceDAOByUsers_Id(balanceDto.getId()).orElseThrow(() -> buildException(BalanceServiceException.Exception.BALANCE_NOT_FOUND));
        balanceDAO.setAmount(balanceDto.getAmount());
        return mapper.map(balanceDAO,BalanceDto.class);
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean deleteByName(String name) {
        return false;
    }

    private BookSellerException buildException(BalanceServiceException.Exception balanceServiceException){
        return new BalanceServiceException(balanceServiceException.getMessage(),balanceServiceException.getHttpStatus());
    }
}
