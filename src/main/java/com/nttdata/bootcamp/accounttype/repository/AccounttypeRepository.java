package com.nttdata.bootcamp.accounttype.repository;

import com.nttdata.bootcamp.accounttype.model.Accounttype;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccounttypeRepository extends ReactiveMongoRepository<Accounttype, String> {

}
