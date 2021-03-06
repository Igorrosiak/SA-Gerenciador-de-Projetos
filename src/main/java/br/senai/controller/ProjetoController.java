package br.senai.controller;

import br.senai.model.Projeto;
import br.senai.service.FuncionarioServiceImpl;
import br.senai.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @GetMapping("/pos-login/projeto/list")
    public String findAll(Model model){
        model.addAttribute("projetos", projetoService.findAll());
        return "pos-login/projeto/list";
    }

    @GetMapping("/pos-login/projeto/add")
    public String add(Model model) {
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "pos-login/projeto/add";
    }

    @GetMapping("/pos-login/projeto/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("projeto", projetoService.findById(id));
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "pos-login/projeto/edit";
    }

    @PostMapping("/pos-login/projeto/save")
    public String save(Projeto projeto, Model model){
        try {
            Projeto saveProjeto = projetoService.save(projeto);
            model.addAttribute("projeto", saveProjeto);
            model.addAttribute("funcionarios", funcionarioService.findAll());
            model.addAttribute("isSaved", true);
            model.addAttribute("isError", false);
        } catch(Exception e){
            model.addAttribute("projeto", projeto);
            model.addAttribute("funcionarios", funcionarioService.findAll());
            model.addAttribute("isSaved", false);
            model.addAttribute("isError", true);
        }
        return "redirect:/pos-login/projeto/list";
    }

    @GetMapping("/pos-login/projeto/delete/{id}")
    public String delete(@PathVariable long id){
        try{
            projetoService.deleteById(id);
            return "redirect:/pos-login/projeto/list";
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return "redirect:/pos-login/projeto/list";
        }
    }
}
