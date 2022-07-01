package br.senai.service;

import br.senai.model.Financeiro;
import br.senai.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceiroServiceImpl implements FinanceiroService{

    @Autowired
    FinanceiroRepository financeiroRepository;

    @Override
    public List<Financeiro> findAll() {
        return financeiroRepository.findAll();
    }

    @Override
    public Financeiro findByIdOperacao(Long id){
        Financeiro fin = financeiroRepository.findById(id).get();
        return fin != null ? fin : new Financeiro();
        
    }

    @Override
    public Financeiro save(Financeiro financeiro){
        try{
            return financeiroRepository.save(financeiro);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteById(Long id){
        try {
            financeiroRepository.deleteById(id);
        } catch (Exception e){
            throw e;
        }
    }
}
