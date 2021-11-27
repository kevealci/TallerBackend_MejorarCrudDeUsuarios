package com.example.tallerbackend.services;

import com.example.tallerbackend.models.UserDTO;
import com.example.tallerbackend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    IUserRepository IUserRepository;

    public ArrayList<UserDTO> getAllUsers() {
        return (ArrayList<UserDTO>) IUserRepository.findAll();
    }

    public UserDTO getUserById(Long id) {
        return IUserRepository.findById(id).get();
    }

    public UserDTO saveUser(UserDTO usuario) {
        return IUserRepository.save(usuario);
    }

    public void deleteUserById(Long id) {
        IUserRepository.deleteById(id);
    }

}
