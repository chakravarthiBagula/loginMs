package com.hexaview.loginMs.dao.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
}
