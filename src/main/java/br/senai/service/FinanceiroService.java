package br.senai.service;

import br.senai.model.Financeiro;

import java.util.List;

public interface FinanceiroService {

    public List<Financeiro> findAll();
    public Financeiro findByIdOperacao(Long id);
    public Financeiro save(Financeiro financeiro);
    public void deleteById(Long id);
}