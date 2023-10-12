package com.project.micro.businnesowners.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BussinesOwnerDto {
    private String idBussinesOwner;
    private String idAccount;
    private String holderName;

}
