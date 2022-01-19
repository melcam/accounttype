package com.nttdata.bootcamp.accounttype.expose;

import com.nttdata.bootcamp.accounttype.business.AccounttypeService;
import com.nttdata.bootcamp.accounttype.model.Accounttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class AccounttypeController {
  @Autowired
  private AccounttypeService accounttypeService;

  @GetMapping("/api/accounttypes")
  public Flux<Accounttype>findAll(){
    log.info("findAll>>>>>>");
    return accounttypeService.findAll();
  }
}
