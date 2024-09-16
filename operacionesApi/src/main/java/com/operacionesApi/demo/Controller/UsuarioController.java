package com.operacionesApi.demo.Controller;

import com.operacionesApi.demo.Model.Usuario;
import com.operacionesApi.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET: Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    // GET: Obtener un usuario por nombre
    @GetMapping("/{nombre}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String nombre) {
        Optional<Usuario> usuario = usuarioService.getUsuario(nombre);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Agregar un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = usuarioService.addUsuario(usuario);
        return ResponseEntity.status(201).body(usuarioCreado);
    }

    // PUT: Actualizar un usuario existente
    @PutMapping("/{nombre}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String nombre, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.updateUsuario(nombre, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // DELETE: Eliminar un usuario por nombre
    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String nombre) {
        usuarioService.deleteUsuario(nombre);
        return ResponseEntity.noContent().build();
    }
}
