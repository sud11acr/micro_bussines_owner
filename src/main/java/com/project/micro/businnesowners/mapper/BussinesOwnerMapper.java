package com.project.micro.businnesowners.mapper;

import com.project.micro.businnesowners.integration.BussinesOwnerRequest;
import com.project.micro.businnesowners.integration.BussinesOwnerResponse;
import com.project.micro.businnesowners.model.BussinesOwner;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class BussinesOwnerMapper {
    public static BussinesOwner toBussinesOwnerModelReq(BussinesOwnerRequest bussinesOwnerRequest){
        BussinesOwner bussinesOwner=new BussinesOwner();
        BeanUtils.copyProperties(bussinesOwnerRequest,bussinesOwner);
        return bussinesOwner;
    }

    public static BussinesOwnerResponse toBussinesOwnerRespModel(BussinesOwner bussinesOwner){
        BussinesOwnerResponse bussinesOwnerResponse=new BussinesOwnerResponse();
        BeanUtils.copyProperties(bussinesOwner,bussinesOwnerResponse);
        return bussinesOwnerResponse;
    }

}
