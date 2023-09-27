package com.project.micro.businnesowners.repo;

import com.project.micro.businnesowners.model.BussinesOwner;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBussinesOwnerRepo extends ReactiveMongoRepository<BussinesOwner,String> {
}
