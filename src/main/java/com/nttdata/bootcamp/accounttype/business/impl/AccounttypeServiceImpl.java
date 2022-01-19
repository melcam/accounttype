package com.nttdata.bootcamp.accounttype.business.impl;

import com.nttdata.bootcamp.accounttype.business.AccounttypeService;
import com.nttdata.bootcamp.accounttype.model.Accounttype;
import com.nttdata.bootcamp.accounttype.repository.AccounttypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class AccounttypeServiceImpl implements AccounttypeService {
  @Autowired
  private AccounttypeRepository accounttypeRepository;

  @Override
  public Flux<Accounttype> findAll() {
    return accounttypeRepository.findAll();
  }
}
