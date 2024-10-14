package com.practicaBasica.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicaBasica.demo.model.Usuario;
import com.practicaBasica.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario Guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    
    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findAll().stream()
                .filter(usuario -> usuario.getNombre().equalsIgnoreCase(nombre))
                .toList();
    }
    
    public List<Usuario> buscarPorEdad(Integer edad) {
        return usuarioRepository.findAll().stream()
                .filter(usuario -> usuario.getEdad().equals(edad))
                .toList();
    }
    
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
}
