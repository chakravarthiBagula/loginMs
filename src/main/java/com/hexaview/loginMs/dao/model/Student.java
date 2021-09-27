package com.hexaview.loginMs.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
    @Id
    private int StudentId;

    @Column
    private String studentName;

}
