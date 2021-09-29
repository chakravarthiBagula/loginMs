package com.hexaview.loginMs.dao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Student {
    @Id
    private int StudentId;

    @Column
    private String studentName;

}
