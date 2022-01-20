package com.nttdata.bootcamp.accounttype.expose;

import com.nttdata.bootcamp.accounttype.business.AccounttypeService;
import com.nttdata.bootcamp.accounttype.model.Accounttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class AccounttypeController {
  @Autowired
  private AccounttypeService accounttypeService;

  @GetMapping("/api/accounttype/{id}")
  public Mono<Accounttype> findById(@PathVariable("id") String id) {
    log.info("<--findById-->");
    return accounttypeService.findById(id);
  }

  @GetMapping("/api/accounttype")
  public Flux<Accounttype> findAll() {
    log.info("<--findAll-->");
    return accounttypeService.findAll();
  }

  @PostMapping("/api/accounttype")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Accounttype> create(@RequestBody Accounttype accounttype) {
    log.info("<--create-->");
    return accounttypeService.create(accounttype);
  }

  @PutMapping("/api/accounttype")
  public Mono<Accounttype> update(@RequestBody Accounttype accounttype) {
    log.info("<--update-->");
    return accounttypeService.update(accounttype);
  }

  @PatchMapping("/api/accounttype")
  public Mono<ResponseEntity<Accounttype>> change(@RequestBody Accounttype accounttype) {
    log.info("<--change-->");
    return accounttypeService.change(accounttype).flatMap(atUpdate -> Mono.just(ResponseEntity.ok(atUpdate)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @DeleteMapping("/api/accounttype/{id}")
  public Mono<ResponseEntity<Accounttype>> delete(@PathVariable("id") String id) {
    log.info("<--delete-->");
    return accounttypeService.delete(id).flatMap(at -> Mono.just(ResponseEntity.ok(at)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }
}
