package br.senai.controller;

import br.senai.model.Financeiro;
import br.senai.service.FinanceiroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FinanceiroController {

    @Autowired
    FinanceiroServiceImpl financeiroService;
    @GetMapping("/pos-login/financeiro/list")
    public String findAll(Model model){
        model.addAttribute("financeiros", financeiroService.findAll());
        return "pos-login/financeiro/list";
    }

    @GetMapping("/pos-login/financeiro/add")
    public String add(Model model) {
        model.addAttribute("financeiro", new Financeiro());
        return "pos-login/financeiro/add";
    }

    @GetMapping("/pos-login/financeiro/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("financeiro", financeiroService.findByIdOperacao(id));
        return "pos-login/financeiro/edit";
    }

    @PostMapping("/pos-login/financeiro/save")
    public String save(Financeiro financeiro, Model model){
        try {
            financeiroService.save(financeiro);
            model.addAttribute("financeiro", financeiro);
            model.addAttribute("isSaved", true);
            return "redirect:/pos-login/financeiro/list";
        } catch(Exception e){
            model.addAttribute("financeiro", financeiro);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "redirect:/pos-login/financeiro/list";
        }
    }
    @GetMapping("/pos-login/financeiro/delete/{id}")
    public String delete(@PathVariable long id){
        try{
            financeiroService.deleteById(id);
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/pos-login/financeiro/list";
    }
}

