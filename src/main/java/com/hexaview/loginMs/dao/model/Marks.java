package com.hexaview.loginMs.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Marks {

    @Id
    private Integer studentId;

    @Column
    private int english;

    @Column
    private int telugu;

    @Column
    private int hindi;

    @Column
    private int maths;

    @Column
    private int science;

    @Column
    private int social;
}
