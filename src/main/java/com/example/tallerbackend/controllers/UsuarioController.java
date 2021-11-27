package com.example.tallerbackend.controllers;

import com.example.tallerbackend.models.UserDTO;
import com.example.tallerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> listOfAllUsers = userService.getAllUsers();
        return new ResponseEntity<List<UserDTO>>(listOfAllUsers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userRetrieved = userService.getUserById(id);
        return new ResponseEntity<UserDTO>(userRetrieved,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        UserDTO addUser = userService.saveUser(user);
        return new ResponseEntity<UserDTO>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        UserDTO userUpdated = userService.saveUser(user);
        return new ResponseEntity<UserDTO>(userUpdated,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
