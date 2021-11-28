package com.example.tallerbackend.controllers;

import com.example.tallerbackend.models.UserDTO;
import com.example.tallerbackend.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Obtener todos los usuarios.")
    @ApiResponse(responseCode = "200",
            description = "Se obtuvieron todos los usuarios.",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class))})
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> listOfAllUsers = userService.getAllUsers();
        return new ResponseEntity<List<UserDTO>>(listOfAllUsers,HttpStatus.OK);
    }

    @Operation(summary = "Obtener usuario por id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Se obtuvo el usuario por Id",
            content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "404",
            description = "No existe un usuario con el id indicado.",
            content = @Content(mediaType = "String",
            schema = @Schema(defaultValue = "String")))
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@Parameter(description = "id del usuario buscado.") @PathVariable Long id) {
        UserDTO userRetrieved = userService.getUserById(id);
        return new ResponseEntity<UserDTO>(userRetrieved,HttpStatus.OK);
    }

    @Operation(summary = "Guardar un usuario en la base de datos.")
    @ApiResponse(responseCode = "201",
            description = "Se guardo con éxito el usuario.",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class))})
    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        UserDTO addUser = userService.saveUser(user);
        return new ResponseEntity<UserDTO>(addUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un usuario en la base de datos.")
    @ApiResponse(responseCode = "201",
            description = "Se actualizó con éxito el usuario.",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class))})
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        UserDTO userUpdated = userService.saveUser(user);
        return new ResponseEntity<UserDTO>(userUpdated,HttpStatus.CREATED);
    }

    @Operation(summary = "Borrar usuario por id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se borro el usuario por Id"),
            @ApiResponse(responseCode = "404",
                    description = "No existe un usuario con el id indicado.",
                    content = @Content(mediaType = "String",
                            schema = @Schema(defaultValue = "String")))
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
