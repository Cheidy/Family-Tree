package com.chidiudo.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clans")
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

 /*   @OneToOne(mappedBy = "clan")
    private User user;
 */

}
