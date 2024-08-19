package com.merteld.sigorta.customerservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "customer")
@Data
public class Customer {

    @Id
    private String id; // MongoDB'de ID genellikle String olarak kullanılır

    private String identificationNumber;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String city;
    private String district;

    @Field(name = "created_at")
    private LocalDateTime createdAt;

//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//    }


}
