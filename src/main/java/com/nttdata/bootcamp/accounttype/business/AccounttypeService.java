package com.nttdata.bootcamp.accounttype.business;

import com.nttdata.bootcamp.accounttype.model.Accounttype;

import reactor.core.publisher.Flux;

public interface AccounttypeService {
  Flux<Accounttype> findAll();
}
