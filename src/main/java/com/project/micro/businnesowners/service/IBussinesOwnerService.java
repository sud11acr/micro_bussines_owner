package com.project.micro.businnesowners.service;

import com.project.micro.businnesowners.integration.BussinesOwnerRequest;
import com.project.micro.businnesowners.integration.BussinesOwnerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBussinesOwnerService {
    Mono<BussinesOwnerResponse> findById(String id);
    Flux<BussinesOwnerResponse> findAll();
    Mono<BussinesOwnerResponse>save(Mono<BussinesOwnerRequest>ownerRequestMono);
    Mono<BussinesOwnerResponse>update(Mono<BussinesOwnerRequest>ownerRequestMono,String id);
    Mono<Void>delete(String id);


}
