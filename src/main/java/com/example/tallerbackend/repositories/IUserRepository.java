package com.example.tallerbackend.repositories;

import com.example.tallerbackend.models.UsuarioDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioDTO, Long> {
    public abstract ArrayList<UsuarioDTO> findByPrioridad(Integer prioridad);
}
