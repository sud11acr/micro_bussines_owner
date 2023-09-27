package com.project.micro.businnesowners.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "bussinesOwner")
public class BussinesOwner {
    @Id
    private String idBussinesOwner;
    private String idAccount;
    private String holderName;
}
