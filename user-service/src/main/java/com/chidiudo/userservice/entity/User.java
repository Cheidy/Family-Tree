package com.chidiudo.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "phonenumber")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String phonenumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clan_id", referencedColumnName = "id")
    private String clan;


    public User(String firstname,
                String lastname,
                String email,
                String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
    }
}
