package com.project.micro.businnesowners.service.impl;

import com.project.micro.businnesowners.integration.BussinesOwnerRequest;
import com.project.micro.businnesowners.integration.BussinesOwnerResponse;
import com.project.micro.businnesowners.mapper.BussinesOwnerMapper;
import com.project.micro.businnesowners.model.BussinesOwner;
import com.project.micro.businnesowners.repo.IBussinesOwnerRepo;
import com.project.micro.businnesowners.service.IBussinesOwnerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class BussinesOwnerServiceImpl implements IBussinesOwnerService {

    @Autowired
    private IBussinesOwnerRepo repo;

    @Override
    public Mono<BussinesOwnerResponse> findById(String id) {
        return repo.findById(id).map(p-> BussinesOwnerMapper.toBussinesOwnerRespModel(p));
    }

    @Override
    public Flux<BussinesOwnerResponse> findAll() {
        return repo.findAll().map(p->BussinesOwnerMapper.toBussinesOwnerRespModel(p));
    }

    @Override
    public Mono<BussinesOwnerResponse> save(Mono<BussinesOwnerRequest> bussinesOwnerRequestMono) {
        return bussinesOwnerRequestMono.map(p-> BussinesOwnerMapper.toBussinesOwnerModelReq(p))
                .flatMap(
                        p->{
                            p.setRegistrationDate(new Date());
                            p.setModificationDate(new Date());
                            p.setStatus(true);
                            return repo.save(p);
                        })
                .map(p->BussinesOwnerMapper.toBussinesOwnerRespModel(p));
    }

    @Override
    public Mono<BussinesOwnerResponse> update(Mono<BussinesOwnerRequest> bussinesOwnerRequest, String id) {
        Mono<BussinesOwner> monoBody = bussinesOwnerRequest.map(p-> BussinesOwnerMapper.toBussinesOwnerModelReq(p));
        Mono<BussinesOwner> monoBD = repo.findById(id);

        return monoBD.zipWith(monoBody,(bd,pl)->{
                    bd.setModificationDate(new Date());
                    bd.setHolderName(pl.getHolderName());
                    bd.setIdAccount(pl.getIdAccount());
                    return bd;
                }).flatMap(p->repo.save(p))
                .map(c->BussinesOwnerMapper.toBussinesOwnerRespModel(c));
    }

    @Override
    public Mono<Void> delete(String id) {
        return repo.deleteById(id);
    }
}
