package com.nttdata.bootcamp.accounttype.business.impl;

import com.nttdata.bootcamp.accounttype.business.AccounttypeService;
import com.nttdata.bootcamp.accounttype.model.Accounttype;
import com.nttdata.bootcamp.accounttype.repository.AccounttypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccounttypeServiceImpl implements AccounttypeService {
  @Autowired
  private AccounttypeRepository accounttypeRepository;

  @Override
  public Mono<Accounttype> findById(String id) {
    return accounttypeRepository.findById(id);
  }

  @Override
  public Flux<Accounttype> findAll() {
    return accounttypeRepository.findAll();
  }

  @Override
  public Mono<Accounttype> create(Accounttype accounttype) {
    accounttype.setStatus(true);
    return accounttypeRepository.save(accounttype);
  }

  @Override
  public Mono<Accounttype> update(Accounttype accounttype) {
    return accounttypeRepository.findById(accounttype.getId()).map(at -> accounttype)
        .flatMap(this.accounttypeRepository::save);
  }

  @Override
  public Mono<Accounttype> change(Accounttype accounttype) {
    return accounttypeRepository.findById(accounttype.getId()).flatMap(at -> {
      return create(accounttype);
    }).switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Accounttype> delete(String id) {
    return accounttypeRepository.findById(id)
        .flatMap(at -> accounttypeRepository.deleteById(at.getId()).thenReturn(at));
  }
}
