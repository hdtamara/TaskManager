package com.taskManager.taskmanager.controllers;

import com.taskManager.taskmanager.entities.Task;
import com.taskManager.taskmanager.entities.Usuario;
import com.taskManager.taskmanager.services.TaskServices;
import com.taskManager.taskmanager.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class frontController {
    @Autowired
    private TaskServices taskServices;

    @Autowired
    private UsuarioService usuarioService;

    //Metodo para la autenticacion  con Auth0
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal  != null) {
            Usuario user = usuarioService.getOrCreateUser(principal.getClaims());
            System.out.println(user);
            model.addAttribute("user",user);
        }
        return "index";
    }



}
