package com.taskManager.taskmanager.services;

import com.taskManager.taskmanager.entities.Usuario;
import com.taskManager.taskmanager.repositories.UsuarioRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUser(Usuario newUser){
        return usuarioRepository.save(newUser);

    }

    public  Usuario findUsuarioByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

        public Usuario getOrCreateUser(Map<String,Object> userData){
        String email = (String) userData.get("email");
        Usuario user = findUsuarioByEmail(email);
        if(user == null){
            String name = (String) userData.get("nickname");
            String image = (String)  userData.get("picture");
            String auth0Id = (String)  userData.get("sub");
            Usuario newUser = new Usuario();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setImage(image);
            newUser.setAuth0Id(auth0Id);
            return  createUser(newUser);
        }
        return user;
    }

}
