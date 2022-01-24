package com.library.bookseller.balance;

import com.library.bookseller.exceptions.generic.BalanceServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import com.library.bookseller.model.ResponseType;
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
    public BalanceDAO getAmount(long id) {
        return repository.findBalanceDAOById(id);
    }

    @Override
    public ResponseType save(BalanceDto balanceDto) {
        repository.save(mapper.map(balanceDto,BalanceDAO.class));
        return new ResponseType("saved");

    }

    @Override
    public ResponseType delete(long id) {
        if(repository.findById(id) == null){
            throw buildException(BalanceServiceException.Exception.BALANCE_NOT_FOUND);
        }
        return new ResponseType("deleted");
    }



    @Override
    public ResponseType delete(String name) {
        return null;
    }

    private BookSellerException buildException(BalanceServiceException.Exception balanceServiceException){
        return new BalanceServiceException(balanceServiceException.getMessage(),balanceServiceException.getHttpStatus());
    }
}
