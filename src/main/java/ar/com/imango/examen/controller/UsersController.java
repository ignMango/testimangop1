package ar.com.imango.examen.controller;

import ar.com.imango.examen.model.Users;
import ar.com.imango.examen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable(value = "id") Long id){
        try {
            Optional<Users> result = repository.findById(id);
            return ResponseEntity.ok(result.get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody Users user){
        try {
            repository.saveAndFlush(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Creado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        try {
            Optional<Users> user = repository.findById(id);
            repository.delete(user.get());
            return ResponseEntity.ok().body("Usuario Eliminado.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
