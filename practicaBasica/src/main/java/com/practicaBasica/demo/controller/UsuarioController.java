package com.practicaBasica.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.practicaBasica.demo.model.Usuario;
import com.practicaBasica.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar")
    public String guardarUsuario(@RequestParam("nombre") String nombre, 
                                 @RequestParam("edad") Integer edad) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEdad(edad);
        usuarioService.Guardar(usuario);
        
        return "redirect:/usuarios";
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<Usuario>> buscarUsuarioPorNombre(@RequestParam String nombre) {
        List<Usuario> usuarios = usuarioService.buscarPorNombre(nombre);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/buscar/edad")
    public ResponseEntity<List<Usuario>> buscarUsuarioPorEdad(@RequestParam Integer edad) {
        List<Usuario> usuarios = usuarioService.buscarPorEdad(edad);
        return ResponseEntity.ok(usuarios);
    }
    
    @GetMapping("/traer")
    public ResponseEntity<List<Usuario>> traerUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios); 
    }
}
