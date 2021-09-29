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

    private String username;

    private String password;
}
