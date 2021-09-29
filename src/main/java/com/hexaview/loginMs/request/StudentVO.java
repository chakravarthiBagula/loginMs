package com.hexaview.loginMs.request;

import lombok.Data;

@Data
public class StudentVO {
    private Integer studentId;

    private String studentName;

    private Double average;

    private Double percentage;
}
