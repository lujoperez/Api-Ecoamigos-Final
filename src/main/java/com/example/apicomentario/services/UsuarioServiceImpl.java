package com.example.apicomentario.services;
import com.example.apicomentario.models.Usuario;
import com.example.apicomentario.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> listaDeUsuarios() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        return listaUsuario;
        }
    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Boolean existeUsuario = usuarioRepository.existsById(id);
        if (existeUsuario){
            Usuario usuarioEscogido = usuarioRepository.findById(id).get();
            return usuarioEscogido;
        }else {
            System.out.println("usuario invalido o inexistente");
            return null;
        }
    }
//preguntar ,método para buscar por nombres
    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {
        Usuario usuarioGuardado = usuarioRepository.save(usuarioNuevo);
        return usuarioGuardado;
    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);
        }

   /*@Override
    public Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado) {
            Boolean existeUsuario = usuarioRepository.existsById(id);
            if (existeUsuario){
                Usuario usuarioEscogido = usuarioRepository.findById(id).get();
                usuarioEscogido.setUsuarioNickname(usuarioActualizado.getUsuarioNickname());
                usuarioEscogido.setUsuarioEmail(usuarioActualizado.getUsuarioEmail());
                usuarioEscogido.setUsuarioNombre(usuarioActualizado.getUsuarioNombre());
                System.out.println("usuario actualizado");
                return usuarioRepository.save(usuarioEscogido);
            }else {
                System.out.println("usuario inexistente o invalido");
                return null;

            }
        }

    */


    }
