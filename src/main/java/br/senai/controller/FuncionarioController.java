package br.senai.controller;

import br.senai.model.Funcionario;
import br.senai.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/pos-login/funcionario/list")
    public String findAll(Model model){
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "pos-login/funcionario/list";
    }

    @GetMapping("/pos-login/funcionario/add")
    public String add(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "pos-login/funcionario/add";
    }

    @GetMapping("/pos-login/funcionario/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("funcionario", funcionarioService.findById(id));
        return "pos-login/funcionario/edit";
    }

    @PostMapping("/pos-login/funcionario/save")
    public String save(Funcionario funcionario, Model model){
        try {
            funcionarioService.save(funcionario);
            model.addAttribute("funcionario", funcionario);
            model.addAttribute("isSaved", true);
            return "redirect:/pos-login/funcionario/list";
        } catch(Exception e){
            model.addAttribute("funcionario", funcionario);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "redirect:/pos-login/funcionario/list";
        }
    }

    @GetMapping("/pos-login/funcionario/delete/{id}")
    public String delete(@PathVariable long id){
        try{
            funcionarioService.deleteById(id);
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/pos-login/funcionario/list";
    }
}
