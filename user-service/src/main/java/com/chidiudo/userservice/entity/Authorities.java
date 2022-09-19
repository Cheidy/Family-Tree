package com.chidiudo.userservice.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
@Data
public class Authorities {

    @Id
    private Long id;

    private String email;

    private String authority;
}
