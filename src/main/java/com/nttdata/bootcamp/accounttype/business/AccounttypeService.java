package com.nttdata.bootcamp.accounttype.business;

import com.nttdata.bootcamp.accounttype.model.Accounttype;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccounttypeService {
  Mono<Accounttype> findById(String id);

  Flux<Accounttype> findAll();

  Mono<Accounttype> create(Accounttype accounttype);

  Mono<Accounttype> update(Accounttype accounttype);

  Mono<Accounttype> change(Accounttype accounttype);

  Mono<Accounttype> delete(String id);
}
