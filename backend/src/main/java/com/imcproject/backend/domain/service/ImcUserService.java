package com.imcproject.backend.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imcproject.backend.domain.model.ImcUser;
import com.imcproject.backend.domain.repository.ImcUserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ImcUserService {

  private ImcUserRepository imcUserRepository;

  public List<ImcUser> getAll() {
    return imcUserRepository.findAll();
  }

  public Optional<ImcUser> getForId(Long id) {
    return imcUserRepository.findById(id);
  }

  public ImcUser registerUser(ImcUser user) {
    return imcUserRepository.save(user);
  }

  public ImcUser update(Long id, ImcUser user){
    
    user.setId(id);

    return imcUserRepository.save(user);
    
  }

   public void delete(Long id) {
    imcUserRepository.deleteById(id);
  }

}
