package com.project.micro.businnesowners.controller;

import com.project.micro.businnesowners.integration.BussinesOwnerRequest;
import com.project.micro.businnesowners.integration.BussinesOwnerResponse;
import com.project.micro.businnesowners.service.IBussinesOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/bussinesowner")
public class BussinesOwnerController {

    @Autowired
    private IBussinesOwnerService service;

    @GetMapping("/findById/{id}")
    public Mono<ResponseEntity<BussinesOwnerResponse>> findByid(@PathVariable String id){
        return service.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());

    }
    @GetMapping("/findAll")
    public Mono<ResponseEntity<Flux<BussinesOwnerResponse>>> findAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.findAll()));
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<BussinesOwnerResponse>>save(@Validated @RequestBody  Mono<BussinesOwnerRequest> bussinesOwnerRequest){
        return service.save(bussinesOwnerRequest)
                .map(p -> ResponseEntity.created(URI.create("/create".concat("/").concat(p.getIdBussinesOwner())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p));
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<BussinesOwnerResponse>>update(@PathVariable String id,@RequestBody Mono<BussinesOwnerRequest> bussinesOwnerRequest ){
        return service.update(bussinesOwnerRequest,id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return service.delete(id).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
    }
}
