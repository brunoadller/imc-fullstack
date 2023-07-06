package com.imcproject.backend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imcproject.backend.domain.exception.RegisterException;
import com.imcproject.backend.domain.exception.VerifyException;
import com.imcproject.backend.domain.model.ImcUser;
import com.imcproject.backend.domain.service.ImcUserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/imcUsers")
@CrossOrigin(origins = "*")
public class ImcUserController {

  private ImcUserService imcUserService;

  @GetMapping
  public List<ImcUser> getAll() {
    return imcUserService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ImcUser> getForId(@PathVariable Long id) throws VerifyException {
    return imcUserService.getForId(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ImcUser registerUser(@Valid @RequestBody ImcUser user) {
    return imcUserService.registerUser(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ImcUser> update(@PathVariable Long id, @Valid @RequestBody ImcUser user) {
    return imcUserService.update(id, user);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    imcUserService.delete(id);
  }
}
