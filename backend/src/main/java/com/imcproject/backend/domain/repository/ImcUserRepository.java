package com.imcproject.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imcproject.backend.domain.model.ImcUser;

@Repository
public interface ImcUserRepository extends JpaRepository<ImcUser, Long> {

}
