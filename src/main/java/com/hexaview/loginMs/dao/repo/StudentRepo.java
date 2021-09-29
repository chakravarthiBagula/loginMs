package com.hexaview.loginMs.dao.repo;

import com.hexaview.loginMs.dao.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
