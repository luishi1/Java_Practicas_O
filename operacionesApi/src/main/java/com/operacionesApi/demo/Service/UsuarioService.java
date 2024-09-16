package com.operacionesApi.demo.Service;

import com.operacionesApi.demo.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        // Inicialización con algunos usuarios
        usuarios.add(new Usuario("Juan", 30));
        usuarios.add(new Usuario("Ana", 25));
        usuarios.add(new Usuario("Pedro", 35));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Optional<Usuario> getUsuario(String nombre) {
        return usuarios.stream().filter(u -> u.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }

    public Usuario addUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario updateUsuario(String nombre, Usuario usuarioActualizado) {
        Usuario usuario = getUsuario(nombre).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setEdad(usuarioActualizado.getEdad());
        return usuario;
    }

    public void deleteUsuario(String nombre) {
        Usuario usuario = getUsuario(nombre).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarios.remove(usuario);
    }
}
