package com.example.tallerbackend.repositories;

import com.example.tallerbackend.models.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IUserRepository extends CrudRepository<UserDTO, Long> {
}
