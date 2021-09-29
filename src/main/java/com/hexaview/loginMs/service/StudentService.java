package com.hexaview.loginMs.service;

import com.hexaview.loginMs.dao.model.Marks;
import com.hexaview.loginMs.dao.model.Student;
import com.hexaview.loginMs.dao.repo.MarksRepo;
import com.hexaview.loginMs.dao.repo.StudentRepo;
import com.hexaview.loginMs.request.StudentInfoListVO;
import com.hexaview.loginMs.request.StudentInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private MarksRepo marksRepo;
    public  StudentInfoListVO getAllStudents(){
        List<StudentInfoVO>  studentInfoVOList = new ArrayList<>();

        List<Student> studentList = studentRepo.findAll();
        if(studentList == null || studentList.isEmpty()){
            return new StudentInfoListVO();
        }
        for(Student student : studentList){
            // for each student fetch the marks
            Marks marks = marksRepo.getById(student.getStudentId());
            studentInfoVOList.add(convertToStudentInfoVO(student, marks));
        }
        StudentInfoListVO studentInfoListVO = new StudentInfoListVO();
        studentInfoListVO.setStudentInfoVOList(studentInfoVOList);
        return studentInfoListVO;

    }

    private StudentInfoVO convertToStudentInfoVO(Student student, Marks marks){
        StudentInfoVO studentInfoVO = new StudentInfoVO();
        studentInfoVO.setStudentId(student.getStudentId());
        studentInfoVO.setStudentName(student.getStudentName());
        studentInfoVO.setEnglishMarks(marks.getEnglish());
        studentInfoVO.setHindiMarks(marks.getEnglish());
        studentInfoVO.setTeluguMarks(marks.getTelugu());
        studentInfoVO.setMathsMarks(marks.getMaths());
        studentInfoVO.setScienceMarks(marks.getScience());
        studentInfoVO.setSocialMarks(marks.getSocial());
        int total = marks.getEnglish() + marks.getTelugu() + marks.getHindi() + marks.getMaths() + marks.getScience()
                + marks.getSocial();
        double average = total / 6.0;
        studentInfoVO.setTotalMarks(total);
        studentInfoVO.setAverageMarks(average);
        studentInfoVO.setRemarks(average > 40.0 ? "PASS" : " FAIL");

        return studentInfoVO;
    }

    public StudentInfoListVO getStudentByID(Integer studentId) {
        StudentInfoListVO studentInfoListVO = new StudentInfoListVO();
        Student student = studentRepo.getById(studentId);
        Marks marks = marksRepo.getById(studentId);
        List<StudentInfoVO> studentInfoVOList= new ArrayList<>();
        studentInfoVOList.add(convertToStudentInfoVO(student, marks));
        studentInfoListVO.setStudentInfoVOList(studentInfoVOList);
        return studentInfoListVO;
    }
}
