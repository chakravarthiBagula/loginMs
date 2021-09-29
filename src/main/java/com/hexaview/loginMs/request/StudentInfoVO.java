package com.hexaview.loginMs.request;

import lombok.Data;

@Data
public class StudentInfoVO {

    private Integer StudentId;

    private String StudentName;

    private int englishMarks;

    private int teluguMarks;

    private int hindiMarks;

    private int mathsMarks;

    private int scienceMarks;

    private int socialMarks;

    private int totalMarks;

    private double averageMarks;

    private String remarks; // Pass or fail average > 40
}
