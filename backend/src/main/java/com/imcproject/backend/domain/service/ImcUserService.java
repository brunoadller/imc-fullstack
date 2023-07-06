package com.imcproject.backend.domain.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.imcproject.backend.domain.exception.RegisterException;
import com.imcproject.backend.domain.exception.VerifyException;
import com.imcproject.backend.domain.model.ImcUser;
import com.imcproject.backend.domain.repository.ImcUserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ImcUserService {

  private ImcUserRepository imcUserRepository;

  public List<ImcUser> getAll() {
    return imcUserRepository.findAll();
  }

  public ResponseEntity<ImcUser> getForId(Long id) throws VerifyException {
    return imcUserRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new VerifyException("Id do Usuário não encontrado"));
  }

  @Transactional
  public ImcUser registerUser(ImcUser user) {
    return imcUserRepository.save(user);
  }

  public ResponseEntity<ImcUser> update(Long id, ImcUser user) {

    if (!imcUserRepository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    user.setId(id);
    imcUserRepository.save(user);
    return ResponseEntity.ok(user);
  }

  @Transactional
  public ResponseEntity<Void> delete(Long id) {
    if (!imcUserRepository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    imcUserRepository.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
