package com.codegym.demo.repository;

import com.codegym.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepo extends CrudRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
