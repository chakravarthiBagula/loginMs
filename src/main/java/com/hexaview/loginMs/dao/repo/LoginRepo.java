package com.hexaview.loginMs.dao.repo;

import com.hexaview.loginMs.dao.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<Login, Integer> {
    Optional<Login> findByUsername(String username);

}
