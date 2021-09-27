package com.hexaview.loginMs.dao.repo;

import lombok.Data;

@Data
public class StudentInfoVO {
    private Integer studentId;

    private String studentName;

    private MarksVO marksVO;

    private Double average;

    private Double percentage;
}
