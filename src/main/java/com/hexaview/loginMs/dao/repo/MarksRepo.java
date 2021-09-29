package com.hexaview.loginMs.dao.repo;

import com.hexaview.loginMs.dao.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MarksRepo extends JpaRepository<Marks, Integer> {
}
