package com.example.tallerbackend.services;

import com.example.tallerbackend.models.UsuarioDTO;
import com.example.tallerbackend.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository IUsuarioRepository;

    public ArrayList<UsuarioDTO> obtenerUsuarios() {
        return (ArrayList<UsuarioDTO>) IUsuarioRepository.findAll();
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuario) {
        return IUsuarioRepository.save(usuario);
    }

    public Optional<UsuarioDTO> obtenerUsuarioPorId(Long id) {
        return IUsuarioRepository.findById(id);
    }

    public ArrayList<UsuarioDTO> obtenerUsuarioPorPrioridad(Integer prioridad) {
        return IUsuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            IUsuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }

    }

}
