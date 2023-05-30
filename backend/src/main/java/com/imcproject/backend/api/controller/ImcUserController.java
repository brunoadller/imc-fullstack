package com.imcproject.backend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imcproject.backend.domain.model.ImcUser;
import com.imcproject.backend.domain.service.ImcUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/imcUsers")
public class ImcUserController {

  private ImcUserService imcUserService;

  @GetMapping
  public List<ImcUser> getAll() {
    return imcUserService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<ImcUser> getForId(@PathVariable Long id) {
    return imcUserService.getForId(id);
  }

  @PostMapping
  public ImcUser registerUser(@RequestBody ImcUser user) {
    return imcUserService.registerUser(user);
  }

  @PutMapping("/{id}")
  public ImcUser update(@PathVariable Long id, @RequestBody ImcUser user) {
    return imcUserService.update(id, user);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    imcUserService.delete(id);
  }
}
