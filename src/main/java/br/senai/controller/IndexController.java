package br.senai.controller;

import br.senai.model.Usuario;
import br.senai.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/pre-login/login")
    public String login() {
        return "pre-login/login";
    }

    @GetMapping("/pre-login/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "pre-login/cadastro";
    }

    @GetMapping("/pre-login/contato")
    public String contato() {
        return "pre-login/contato";
    }

    @PostMapping("/pre-login/cadastro/save")
    public String save(Usuario usuario, Model model) {
        try {
            usuarioService.save(usuario);
            model.addAttribute("usuario", usuario);
            model.addAttribute("isSave", true);
            return "redirect:/pre-login/login";
        } catch (Exception e) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "pre-login/cadastro";
        }
    }
}
