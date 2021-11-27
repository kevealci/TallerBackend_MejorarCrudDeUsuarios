package com.example.tallerbackend.controllers;

import com.example.tallerbackend.models.UsuarioDTO;
import com.example.tallerbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioRESTController {
    @Autowired
    UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity saveUser(@RequestBody UsuarioDTO user) {
        return
    }


}
