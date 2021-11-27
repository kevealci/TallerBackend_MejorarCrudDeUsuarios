package com.example.tallerbackend.services;

import com.example.tallerbackend.models.UsuarioModel;
import com.example.tallerbackend.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository IUsuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) IUsuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return IUsuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerUsuarioPorId(Long id) {
        return IUsuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(Integer prioridad) {
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
