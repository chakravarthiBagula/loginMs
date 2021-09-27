package com.hexaview.loginMs.dao.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    @Column
    private String username;
    @Column
    private String password;
}
